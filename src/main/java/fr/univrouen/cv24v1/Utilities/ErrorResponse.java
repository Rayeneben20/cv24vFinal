package fr.univrouen.cv24v1.Utilities;

public class ErrorResponse extends RuntimeException {
    private final String id;

    public ErrorResponse(String id) {
        super("CV with ID " + id + " not found");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getFormattedMessage() {
        return "<response><id>" + id + "</id><status>ERROR</status></response>";
    }
}
