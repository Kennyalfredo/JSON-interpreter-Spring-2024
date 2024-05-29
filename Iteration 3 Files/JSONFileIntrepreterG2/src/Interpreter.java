import java.util.List;

import javax.swing.JOptionPane;

public class Interpreter {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        InteractionMenu interactionMenu = new InteractionMenu(fileManager);
        AppView view = new AppView();

        boolean restartProgram;
        do {
            boolean fileUploaded = false;
            do {
                String filePath1 = view.getInput("Enter the file path/name for the first JSON file (leave empty to skip):");
                String filePath2 = view.getInput("Enter the file path/name for the second JSON file (leave empty to skip):");
                String filePath3 = view.getInput("Enter the file path/name for the third JSON file (leave empty to skip):");

                if (filePath1 == null || filePath2 == null || filePath3 == null) {
                    System.exit(0); // Terminate the program
                }

                boolean uploadSuccess1 = filePath1.isEmpty() || interactionMenu.uploadFile(filePath1);
                boolean uploadSuccess2 = filePath2.isEmpty() || interactionMenu.uploadFile(filePath2);
                boolean uploadSuccess3 = filePath3.isEmpty() || interactionMenu.uploadFile(filePath3);

                if (uploadSuccess1 && uploadSuccess2 && uploadSuccess3) {
                    fileUploaded = true;
                } else {
                    view.showMessage("Invalid file or unable to upload. Please try again.");
                }
            } while (!fileUploaded);

            String keyword = view.getInput("Enter the search keyword:");
            if (keyword != null && !keyword.isEmpty()) {
                List<String> searchResult = interactionMenu.searchFor(keyword);
                view.showMessage("Found: " + searchResult.size() + " occurrences of keyword: " + keyword);
                if (!searchResult.isEmpty()) {
                    StringBuilder resultMessage = new StringBuilder("Matching information:");
                    for (String info : searchResult) {
                        resultMessage.append("\n").append(info);
                    }
                    view.showMessage(resultMessage.toString());
                }
            } else {
                view.showMessage("Invalid keyword. Exiting.");
            }

            interactionMenu.resetUploadedFiles();

            // Prompt user to restart the program
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to search again?", "Restart", JOptionPane.YES_NO_OPTION);
            restartProgram = (choice == JOptionPane.YES_OPTION);
        } while (restartProgram);
    }
}