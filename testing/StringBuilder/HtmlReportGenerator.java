import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlReportGenerator {

    public static void generateHtmlReport(String filename, List<String> data) throws IOException {
        StringBuilder html = new StringBuilder();
        html.append("<html><body><table>");

        for (String row : data) {
            html.append("<tr><td>").append(row).append("</td></tr>");
        }

        html.append("</table></body></html>");

        // Write the HTML content to a file
        FileWriter writer = new FileWriter(filename);
        writer.write(html.toString());
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        List<String> data = new ArrayList<>();
        data.add("Row 1");
        data.add("Row 2");
        data.add("Row 3");
        data.add("Row 4");
        data.add("Row 5");
        data.add("Row 6");
        data.add("Row 7");

        String filename = "report.html";
        generateHtmlReport(filename, data);

        System.out.println("HTML report generated: " + filename);
        // Print a message to the console using a separate string
        String multilineString = """
            This is a multiline 
            string with preserved 
            indentation. 
            """; 
    
        System.out.println(multilineString); 
    }
}