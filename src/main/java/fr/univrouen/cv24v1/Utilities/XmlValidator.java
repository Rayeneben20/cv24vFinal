package fr.univrouen.cv24v1.Utilities;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

public class XmlValidator {

    public static void validateXml(String xml) throws SAXException, IOException {
        String xsdPath = "cv24.xsd";
        try (InputStream xsdStream = XmlValidator.class.getClassLoader().getResourceAsStream(xsdPath)) {
            if (xsdStream == null) {
                throw new IOException("Le fichier XSD ne peut pas être trouvé : " + xsdPath);
            }
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new StreamSource(xsdStream));

            Validator validator = schema.newValidator();
            validator.setErrorHandler(new ValidationErrorHandler());

            validator.validate(new StreamSource(new StringReader(xml)));

            System.out.println("La validation du fichier XML a réussi.");
        } catch (SAXException e) {
            System.err.println("Erreur SAX lors de la validation du fichier XML : " + e.getMessage());
            throw e;
        } catch (IOException e) {
            System.err.println("Erreur d'entrée/sortie lors de la validation du fichier XML : " + e.getMessage());
            throw e;
        }
    }

    private static class ValidationErrorHandler extends DefaultHandler {
        @Override
        public void error(SAXParseException e) throws SAXException {
            throw e;
        }

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            throw e;
        }

        @Override
        public void warning(SAXParseException e) throws SAXException {
            System.err.println("Avertissement SAX lors de la validation du fichier XML : " + e.getMessage());
        }
    }
}
