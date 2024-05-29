import java.util.List;
import java.util.ArrayList;

public class JSONParser {
    public static List<JSONElement> parse(String jsonData) {
        List<JSONElement> elements = new ArrayList<>();
        String[] lines = jsonData.split("\\r?\\n");
        for (String line : lines) {
            elements.add(new JSONElement(line));
        }
        return elements;
    }
}