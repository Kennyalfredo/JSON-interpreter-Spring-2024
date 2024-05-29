import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FileManagerTest {

    @Test
    void testUploadFile_Valid() {
        FileManager fileManager = new FileManager();
        JSONFile validFile = new JSONFile("test.json", 10, "{}");
        assertTrue(fileManager.uploadFile(validFile));
        assertEquals(validFile, fileManager.getUploadedFiles().get(0));
    }

    @Test
    void testUploadFile_Invalid() {
        FileManager fileManager = new FileManager();
        JSONFile invalidFile = new JSONFile("test.json", 10, null);
        assertFalse(fileManager.uploadFile(invalidFile));
        assertNull(fileManager.getUploadedFiles());
    }

    @Test
    void testReset() {
        FileManager fileManager = new FileManager();
        JSONFile file = new JSONFile("test.json", 10, "{}");
        fileManager.uploadFile(file);
        assertFalse(fileManager.getUploadedFiles().isEmpty());
        fileManager.reset();
        assertTrue(fileManager.getUploadedFiles().isEmpty());
    }
}