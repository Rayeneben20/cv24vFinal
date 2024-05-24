package fr.univrouen.cv24v1;

import fr.univrouen.cv24v1.Model.cv24.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class XmlProjectApplicationTests {
    private final String xsdFilePath = "src/main/resources/XML/cv24.xsd";
    private final String xmlInputFilePath = "src/main/resources/XML/cv24.tp2a.xml";
    private final String xmlOutputFilePath = "src/main/resources/XML/output.xml";
    private final String xmlTempPath = "src/main/resources/XML/temp.xml";

    @Test
    public void testUnmarshal() {

        File xmlFile = new File(xmlInputFilePath);
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Cv24.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Cv24 cv = (Cv24) jaxbUnmarshaller.unmarshal(xmlFile);
            System.out.println(cv);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMarshal() {
        File source = new File(xmlInputFilePath);
        File output = new File(xmlOutputFilePath);
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Cv24.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Cv24 cv = (Cv24) jaxbUnmarshaller.unmarshal(source);
            cv.getIdentite().setNom("AMARA");


            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            Schema schema = schemaFactory.newSchema(new File(xsdFilePath));

            Validator validator = schema.newValidator();

            File tempFile = new File(xmlTempPath);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(cv, tempFile);

            validator.validate(new StreamSource(tempFile));


            marshaller.marshal(cv, output);
            System.out.println("Marshalled XML successfully.");
        } catch (JAXBException | IOException | SAXException e) {
            if (e instanceof SAXParseException) {

                SAXParseException saxParseException = (SAXParseException) e;
                String errorMessage = String.format("Validation error at line %d, column %d: %s",
                        saxParseException.getLineNumber(), saxParseException.getColumnNumber(),
                        saxParseException.getMessage());
                System.out.println("Error: " + errorMessage);
            } else {
                e.printStackTrace();
                System.out.println("Error: The created XML is not valid against the XSD file.");
            }
        }
    }

}
