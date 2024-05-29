import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


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

class FileManager {
    private JSONFile uploadedFile;

    public boolean uploadFile(JSONFile file) {
        if (file != null && file.isValid()) {
            uploadedFile = file;
            return true;
        } else {
            return false;
        }
    }

    public void reset() {
        uploadedFile = null;
    }

    public JSONFile getUploadedFile() {
        return uploadedFile;
    }
}

class InteractionMenu {
    private FileManager fileManager;

    public InteractionMenu(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public void displayMenu() {
    	JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            fileManager.reset();
            JOptionPane.showMessageDialog(null, "Uploaded file reset.");
        });

        JPanel panel = new JPanel();
        panel.add(resetButton);

        JOptionPane.showMessageDialog(null, panel, "Menu Displayed", JOptionPane.PLAIN_MESSAGE);
    }

    //searches for exact match of any kind of data within json
    public void fetchData(String keyword) {
        JSONFile uploadedFile = fileManager.getUploadedFile();
        if (uploadedFile != null) {
            String data = uploadedFile.getData();
            String[] lines = data.split("\\r?\\n"); //new line in regex
            List<String> outputLines = new ArrayList<>();
            for (String line : lines) {
                if (line.contains(keyword)) {
                    //TODO: walk up and down until find { and } for this entry and get all of this entry's data to display as well (would be found between { and })
                    outputLines.add(line);
                }
            }
            JOptionPane.showMessageDialog(null, "Found: " + outputLines.size() + outputLines);
        } else {
            JOptionPane.showMessageDialog(null, "No file uploaded.");
        }
    }

}


public class Intrepreter {
    public static void main(String[] args) {
        //input1
    	FileManager fileManager = new FileManager();
        InteractionMenu menu = new InteractionMenu(fileManager);

        boolean fileUploaded = false;
        do {
            String filePath = JOptionPane.showInputDialog("Enter the file path/name:");
            JSONFile file = JSONFile.fromFile(filePath);

            if (fileManager.uploadFile(file)){
                fileUploaded = true;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid file. Please try again.");
            }
        } while (!fileUploaded);

        
        String keyword = JOptionPane.showInputDialog("Enter the search keyword:");//for when the file is input correctly

        menu.displayMenu();
        menu.fetchData(keyword);

        fileManager.reset();
    }
}