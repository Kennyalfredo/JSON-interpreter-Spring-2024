import java.util.List;
import java.util.ArrayList;

public class InteractionMenu {
    private FileManager fileManager;

    public InteractionMenu(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public boolean uploadFile(String filePath) {
        JSONFile file = JSONFile.fromFile(filePath);
        return fileManager.uploadFile(file);
    }

    public void resetUploadedFiles() {
        fileManager.reset();
    }

    public List<String> searchFor(String keyword) {
        List<String> matchingInfo = new ArrayList<>();
        for (JSONFile uploadedFile : fileManager.getUploadedFiles()) {
            searchInJSON(uploadedFile.getData(), keyword, matchingInfo);
        }
        return matchingInfo;
    }

    private void searchInJSON(String jsonData, String keyword, List<String> matchingInfo) {
        // Remove whitespace and newline characters
        jsonData = jsonData.replaceAll("\\s", "");

        // Split JSON data into objects and arrays
        String[] elements = jsonData.split("[{}\\[\\]]");

        // Search each element for the keyword
        for (String element : elements) {
            if (element.contains(keyword)) {
                matchingInfo.add("{" + element + "}"); // Add the entire JSON object containing the keyword
            }
        }
    }
}