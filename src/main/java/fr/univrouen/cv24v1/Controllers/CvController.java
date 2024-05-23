package fr.univrouen.cv24v1.Controllers;

import fr.univrouen.cv24v1.Model.Cv24id;
import fr.univrouen.cv24v1.Model.CvSummary;
import fr.univrouen.cv24v1.Repository.Cv24Repository;
import fr.univrouen.cv24v1.Services.Cv24Service;
import fr.univrouen.cv24v1.Utilities.ErrorResponse;
import fr.univrouen.cv24v1.Utilities.MarshallXml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cv24")
public class CvController {

    @Autowired
    private Cv24Service cv24Service;
    @Autowired
    private Cv24Repository cvRepository;

    @PostMapping("/insert")
    public ResponseEntity<String> insertCv(@RequestBody String xml) {
        return cv24Service.insertCv(xml);
    }

    @GetMapping(value = "/xml", produces = "application/xml")
    public ResponseEntity<String> getXmlCvById(@RequestParam("id") String id) {
        try {
            Cv24id cv = cv24Service.getCvById(id);
            return ResponseEntity.ok(MarshallXml.convertCvToXml(cv.getCv24()));
        } catch (ErrorResponse e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getFormattedMessage());
        }
    }

    @GetMapping(value = "/resume/xml", produces = "application/xml")
    public ResponseEntity<List<CvSummary>> getAllCvSummaries() {
        List<CvSummary> summaries = cv24Service.getAllCvSummaries();
        return ResponseEntity.ok(summaries);
    }

    @GetMapping("/html")
    public String getHtmlCvById(@RequestParam("id") String id) {
        Optional<Cv24id> cv = cvRepository.findById(id);
        if (cv.isPresent()) {
            String xml = MarshallXml.convertCvToXml(cv.get().getCv24());
            return MarshallXml.transformXmlToHtml(xml,"/templates/cv.xslt");
        } else {
            return "cv_not_found";
        }
    }

    @GetMapping("resume")
    public String getAllCvSummaries(Model model) {
        List<CvSummary> summaries = cv24Service.getAllCvSummaries();
        String xml = MarshallXml.convertCvSummariesToXml(summaries);
        String cvs = MarshallXml.transformXmlToHtml(xml, "/templates/cv_list.xslt");
        model.addAttribute("htmlContent", cvs);
        return cvs;
    }

    @DeleteMapping(value="/delete")
    public ResponseEntity<String> deleteCvById(@RequestParam("id") String id) {
        return cv24Service.deleteCv(id);
    }


    @GetMapping(value = "/search",produces = "application/xml")
    public ResponseEntity<?> searchCv(
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "objective", required = false) String objective){
        if(date==null && objective==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("<response><status>ERROR</status></response>");        }
        List<Cv24id> results = cv24Service.searchCv(date, objective);
        if (results == null || results.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("<response><status>NONE</status></response>");
        } else {
            String xmlResults = MarshallXml.convertCvSummariesToXml(
                    results.stream().map(cv24Service::convertToSummary).collect(Collectors.toList()));
            return ResponseEntity.ok(xmlResults);
        }
    }

    }







