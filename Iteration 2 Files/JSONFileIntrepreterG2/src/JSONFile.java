import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class JSONFile {
    private String filename;
    private int size;
    private String data;

    public JSONFile(String filename, int size, String data) {
        this.filename = filename;
        this.size = size;
        this.data = data;
    }

    public boolean isValid() {

        if (data == null) {
            return false;
        }

        if ((data.charAt(0) != '{') || (data.charAt(data.length()-1) != '}')){
            return false;
        }

        return true;


    }

    public int getSize() {
        return size;
    }

    public String getData() {
        return data;
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