import java.util.List;
import java.util.ArrayList;

public class FileManager {
    private List<JSONFile> uploadedFiles;

    public FileManager() {
        uploadedFiles = new ArrayList<>();
    }

    public boolean uploadFile(JSONFile file) {
        if (file != null && file.isValid()) {
            uploadedFiles.add(file);
            return true;
        } else {
            return false;
        }
    }

    public void reset() {
        uploadedFiles.clear();
    }

    public List<JSONFile> getUploadedFiles() {
        return uploadedFiles;
    }
}