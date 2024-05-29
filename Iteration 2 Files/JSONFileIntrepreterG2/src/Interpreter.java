import javax.swing.*;


public class Interpreter {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        InteractionMenu menu = new InteractionMenu(fileManager);

        boolean fileUploaded = false;
        do {
            String filePath = JOptionPane.showInputDialog("Enter the file path/name:");
            if (filePath != null && !filePath.isEmpty()) {
                JSONFile file = JSONFile.fromFile(filePath);
                if (file != null && fileManager.uploadFile(file)) {
                    fileUploaded = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid file or unable to upload. Please try again.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid file path. Please try again.");
            }
        } while (!fileUploaded);

        String keyword = JOptionPane.showInputDialog("Enter the search keyword:");
        if (keyword != null && !keyword.isEmpty()) {
            // Ask for search options
            String[] options = {"Case-sensitive", "Case-insensitive", "Regular expression"};
            int choice = JOptionPane.showOptionDialog(null, "Choose search options:", "Search Options",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            boolean caseSensitive = false;
            boolean useRegex = false;
            switch (choice) {
                case 0:
                    caseSensitive = true;
                    break;
                case 1:
                    caseSensitive = false;
                    break;
                case 2:
                    useRegex = true;
                    break;
                default:
                    break;
            }
            menu.displayMenu();
            menu.fetchData(keyword, caseSensitive, useRegex);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid keyword. Exiting.");
        }

        fileManager.reset();
    }
}












