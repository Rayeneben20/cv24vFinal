package fr.univrouen.cv24v1.Services;

import fr.univrouen.cv24v1.Model.Cv24id;
import fr.univrouen.cv24v1.Model.CvSummary;
import fr.univrouen.cv24v1.Model.cv24.Cv24;
import fr.univrouen.cv24v1.Model.cv24.DiplomeType;
import fr.univrouen.cv24v1.Model.cv24.GenreType;
import fr.univrouen.cv24v1.Repository.Cv24Repository;
import fr.univrouen.cv24v1.Utilities.ErrorResponse;
import fr.univrouen.cv24v1.Utilities.XmlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class Cv24Service {

    private static final Logger logger = LoggerFactory.getLogger(Cv24Service.class);

    @Autowired
    private Cv24Repository cvRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private final AtomicInteger counter = new AtomicInteger();

    public ResponseEntity<String> insertCv(String xml) {
        try {
            // Validate the XML
            XmlValidator.validateXml(xml);

            // Unmarshal the XML to a Cv24 object
            JAXBContext jaxbContext = JAXBContext.newInstance(Cv24.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Cv24 cv = (Cv24) unmarshaller.unmarshal(new StringReader(xml));

            // Create Cv24id object
            Cv24id cv24id = new Cv24id(cv);

            // Vérifier si un CV avec les mêmes nom, prénom, genre et téléphone existe déjà
            if (cvExists(cv24id)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("<response><status>ERROR</status><detail>DUPLICATE_ENTRY</detail></response>");
            }

            // Ensure ID is set
            if (cv24id.getId() == null) {
                String nextId = getNextId();
                cv24id.setId(nextId);
                logger.info("Generated ID: {}", nextId);
            } else {
                logger.info("Using existing ID: {}", cv24id.getId());
            }

            persistCv(cv24id);

            logger.info("Persisted CV with ID: {}", cv24id.getId());

            return ResponseEntity.ok("<response><id>" + cv24id.getId() + "</id><status>INSERTED</status></response>");

        } catch (JAXBException | SAXException e) {
            logger.error("JAXBException or SAXException: ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("<response><status>ERROR</status><detail>INVALID</detail><message>" + e.getMessage() + "</message></response>");
        } catch (IOException e) {
            logger.error("IOException: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("<response><status>ERROR</status><detail>INTERNAL_ERROR</detail><message>" + e.getMessage() + "</message></response>");
        }
    }

    public Cv24id getCvById(String id) {
        return cvRepository.findById(id)
                .orElseThrow(() -> new ErrorResponse(id));
    }

    public List<CvSummary> getAllCvSummaries() {
        return cvRepository.findAll().stream()
                .map(this::convertToSummary)
                .collect(Collectors.toList());
    }

    public CvSummary convertToSummary(Cv24id cv24id) {
        String id = cv24id.getId();
        GenreType genre = cv24id.getIdentite().getGenre();
        String prenom = cv24id.getIdentite().getPrenom();
        String nom = cv24id.getIdentite().getNom();
        String objectif = cv24id.getObjectif().getStatus() + ": " + cv24id.getObjectif().getValue();

        // Trouver le diplôme le plus élevé ou le plus récent
        String diplome = cv24id.getCompetences().getDiplome().stream()
                .max(Comparator.comparingInt(DiplomeType::getNiveau)
                        .thenComparing(d -> {
                            String xmlDate = d.getDate();
                            LocalDate localDate = LocalDate.parse(xmlDate);
                            return localDate;
                        }))
                .map(d -> "Niveau " + d.getNiveau() + " - " + d.getDate())
                .orElse("Aucun diplôme");

        return new CvSummary(id, genre, prenom, nom, objectif, diplome);
    }

    private boolean cvExists(Cv24id cv) {
        return cvRepository.findAll().stream().anyMatch(existingCv ->
                existingCv.getIdentite().getNom().equals(cv.getIdentite().getNom()) &&
                        existingCv.getIdentite().getPrenom().equals(cv.getIdentite().getPrenom()) &&
                        existingCv.getIdentite().getGenre().equals(cv.getIdentite().getGenre()) &&
                        existingCv.getIdentite().getTel().equals(cv.getIdentite().getTel())
        );
    }

    public ResponseEntity<String> deleteCv(String id) {
        if (cvRepository.existsById(id)) {
            cvRepository.deleteById(id);
            return ResponseEntity.ok("<response><status>DELETED</status><id>" + id + "</id></response>");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("<response><status>ERROR</status><detail>NOT_FOUND</detail><id>" + id + "</id></response>");
        }
    }

    private void persistCv(Cv24id cv) {
        cvRepository.save(cv);
    }

    public List<Cv24id> searchCv(String date, String objective) {
        try {
            logger.info("Searching CVs with date: {} and objective: {}", date, objective);
            Query query = new Query();
            List<Criteria> criteriaList = new ArrayList<>();

            if (date != null) {
                try {
                    LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
                    Criteria dateCriteria = new Criteria().orOperator(
                            Criteria.where("cv.prof.detail.datedeb").gte(parsedDate.toString()),
                            Criteria.where("cv.prof.detail.datefin").gte(parsedDate.toString()),
                            Criteria.where("cv.competences.diplome.date").gte(parsedDate.toString()),
                            Criteria.where("cv.competences.certif.datedeb").gte(parsedDate.toString()),
                            Criteria.where("cv.competences.certif.datefin").gte(parsedDate.toString())
                    );
                    criteriaList.add(dateCriteria);
                } catch (Exception e) {
                    logger.error("Invalid date format: {}", date, e);
                    return null;
                }
            }

            if (objective != null) {
                String[] words = objective.split("\\s+");
                for (String word : words) {
                    criteriaList.add(Criteria.where("cv.objectif.value").regex("\\b" + word + "\\b", "i"));
                }
            }

            if (!criteriaList.isEmpty()) {
                Criteria[] allCriteria = criteriaList.toArray(new Criteria[0]);
                query.addCriteria(new Criteria().orOperator(allCriteria));
            }

            List<Cv24id> results = mongoTemplate.find(query, Cv24id.class);
            logger.info("Found {} CVs matching the criteria", results.size());
            return results;
        } catch (DataAccessException ex) {
            logger.error("Database connection failed while searching CVs", ex);
            return null;
        }
    }

    private String getNextId() {
        List<Cv24id> allCvs = cvRepository.findAll();
        if (allCvs.isEmpty()) {
            return "1"; // Starting ID if no CVs exist
        } else {
            int maxId = allCvs.stream()
                    .map(cv -> Integer.parseInt(cv.getId()))
                    .max(Comparator.naturalOrder())
                    .orElse(0);
            return String.valueOf(maxId + 1);
        }
    }
}
