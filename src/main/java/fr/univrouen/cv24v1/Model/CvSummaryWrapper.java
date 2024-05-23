package fr.univrouen.cv24v1.Model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "CvSummaries")
public class CvSummaryWrapper {
    private List<CvSummary> summaries;

    public CvSummaryWrapper() {
    }

    public CvSummaryWrapper(List<CvSummary> summaries) {
        this.summaries = summaries;
    }

    @XmlElement(name = "CvSummary")
    public List<CvSummary> getSummaries() {
        return summaries;
    }

    public void setSummaries(List<CvSummary> summaries) {
        this.summaries = summaries;
    }
}