import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class InterpreterTest {

    @Test
    void testSearchFor_WithMatchingKeyword() {
        // Arrange
        FileManager fileManager = new FileManager();
        InteractionMenu interactionMenu = new InteractionMenu(fileManager);
        String filePath = "test.json";
        String keyword = "value";
        JSONFile file = new JSONFile(filePath, 20, "{\"key\": \"value\"}");
        fileManager.uploadFile(file);

        // Act
        List<String> result = interactionMenu.searchFor(keyword);

        // Assert
        assertEquals(1, result.size());
        assertTrue(result.get(0).contains(keyword));
    }

    @Test
    void testSearchFor_WithNonMatchingKeyword() {
        // Arrange
        FileManager fileManager = new FileManager();
        InteractionMenu interactionMenu = new InteractionMenu(fileManager);
        String filePath = "test.json";
        String keyword = "nonexistent";
        JSONFile file = new JSONFile(filePath, 20, "{\"key\": \"value\"}");
        fileManager.uploadFile(file);

        // Act
        List<String> result = interactionMenu.searchFor(keyword);

        // Assert
        assertEquals(0, result.size());
    }

    @Test
    void testSearchFor_NoFileUploaded() {
        // Arrange
        FileManager fileManager = new FileManager();
        InteractionMenu interactionMenu = new InteractionMenu(fileManager);
        String keyword = "value"; // This doesn't matter since no file is uploaded

        // Act
        List<String> result = interactionMenu.searchFor(keyword);

        // Assert
        assertEquals(0, result.size());
    }
}