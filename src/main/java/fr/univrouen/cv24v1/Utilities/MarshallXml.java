package fr.univrouen.cv24v1.Utilities;

import fr.univrouen.cv24v1.Model.Cv24id;

import fr.univrouen.cv24v1.Model.CvSummary;
import fr.univrouen.cv24v1.Model.CvSummaryWrapper;
import fr.univrouen.cv24v1.Model.cv24.Cv24;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

public class MarshallXml {

    public static String convertCvToXml(Cv24 cv) {
        try {
            JAXBContext context = JAXBContext.newInstance(Cv24.class);
            StringWriter writer = new StringWriter();
            context.createMarshaller().marshal(cv, writer);
            return writer.toString();
        } catch (JAXBException e) {
            throw new RuntimeException("Error converting CV to XML", e);
        }
    }

    public static String transformXmlToHtml(String xml, String xsltPath) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            StreamSource xslt = new StreamSource(MarshallXml.class.getResourceAsStream(xsltPath));
            Transformer transformer = factory.newTransformer(xslt);

            StreamSource text = new StreamSource(new StringReader(xml));
            StringWriter writer = new StringWriter();
            transformer.transform(text, new StreamResult(writer));
            return writer.toString();
        } catch (TransformerException e) {
            throw new RuntimeException("Error transforming XML to HTML", e);
        }
    }

    public static String convertCvSummariesToXml(List<CvSummary> summaries) {
        try {
            JAXBContext context = JAXBContext.newInstance(CvSummaryWrapper.class);
            CvSummaryWrapper wrapper = new CvSummaryWrapper(summaries);
            StringWriter writer = new StringWriter();
            context.createMarshaller().marshal(wrapper, writer);
            return writer.toString();
        } catch (JAXBException e) {
            throw new RuntimeException("Error converting CV summaries to XML", e);
        }
    }
}
