package fr.univrouen.cv24v1.Utilities;

public class ErrorHtml {

    public static String cvNotFound() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>CV Not Found</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "<h1>CV Not Found</h1>\n" +
                "<p>The CV with the provided ID was not found.</p>\n" +
                "</body>\n" +
                "</html>";
    }
}

