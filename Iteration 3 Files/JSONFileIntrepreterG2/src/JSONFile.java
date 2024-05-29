import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class JSONFile {
    private String filename;
    private int size;
    private String data;

    public JSONFile(String filename, int size, String data) {
        this.filename = filename;
        this.size = size;
        this.data = data;
    }

    public boolean isValid() {
        try {
            JSONParser.parse(data);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getSize() {
        return size;
    }

    public String getData() {
        return data;
    }

    public String getFilename() {
        return filename;
    }

    public static JSONFile fromFile(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            return new JSONFile(filePath, content.length(), content);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}