import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest{


        public void main(){
            testUploadFile_Valid();
            testUploadFile_Invalid();
            testReset();
        }

        @Test
        void testUploadFile_Valid() {
            FileManager fileManager = new FileManager();
            JSONFile validFile = new JSONFile("test.json", 10, "{}");
            assertTrue(fileManager.uploadFile(validFile));
            assertEquals(validFile, fileManager.getUploadedFile());
        }


        @Test
        void testUploadFile_Invalid() {
            FileManager fileManager = new FileManager();
            JSONFile invalidFile = new JSONFile("test.json", 10, null);
            assertFalse(fileManager.uploadFile(invalidFile));
            assertNull(fileManager.getUploadedFile());
         }

         @Test
         void testReset() {
             FileManager fileManager = new FileManager();
             JSONFile file = new JSONFile("test.json", 10, "{}");
             fileManager.uploadFile(file);
             assertNotNull(fileManager.getUploadedFile());
             fileManager.reset();
             assertNull(fileManager.getUploadedFile());
         }
         
    }