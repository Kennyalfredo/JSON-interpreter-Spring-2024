import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        JButton showAllButton = new JButton("Show All");
        showAllButton.addActionListener(e -> {
            JSONFile uploadedFile = fileManager.getUploadedFile();
            if (uploadedFile != null) {
                JOptionPane.showMessageDialog(null, uploadedFile.getData(), "All Content", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No file uploaded.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(resetButton);
        panel.add(showAllButton);

        JOptionPane.showMessageDialog(null, panel, "Menu Displayed", JOptionPane.PLAIN_MESSAGE);
    }

    // Search for exact match of any kind of data within JSON
    public void fetchData(String keyword, boolean caseSensitive, boolean useRegex) {
        JSONFile uploadedFile = fileManager.getUploadedFile();
        if (uploadedFile != null) {
            String data = uploadedFile.getData();
            String[] lines = data.split("\\r?\\n"); // Split data into lines
            List<String> outputLines = new ArrayList<>();
            for (String line : lines) {
                boolean match = false;
                if (useRegex) {
                    // Use regular expression search
                    Pattern pattern;
                    if (caseSensitive) {
                        pattern = Pattern.compile(keyword);
                    } else {
                        pattern = Pattern.compile(keyword, Pattern.CASE_INSENSITIVE);
                    }
                    Matcher matcher = pattern.matcher(line);
                    match = matcher.find();
                } else {
                    // Use simple string search
                    if (caseSensitive) {
                        match = line.contains(keyword);
                    } else {
                        match = line.toLowerCase().contains(keyword.toLowerCase());
                    }
                }
                if (match) {
                    outputLines.add(line);
                }
            }
            if (!outputLines.isEmpty()) {
                // Display matched lines
                StringBuilder message = new StringBuilder("Found: " + outputLines.size() + "\n");
                for (String line : outputLines) {
                    message.append(line).append("\n");
                }
                JOptionPane.showMessageDialog(null, message.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No matches found.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No file uploaded.");
        }
    }

}