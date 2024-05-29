import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntrepreterTest {

    class JSONFileTest {

        public void testJSONFile(){
            JSONFile json= new JSONFile("file", 15, "Hello");

            assertEquals(true, json.isValid());
            assertEquals(15,json.getSize());
            assertEquals("Hello", json.getData());
        
        }

        @Test
        void testIsValid() {
            JSONFile validFile = new JSONFile("test.json", 10, "{}");
            assertTrue(validFile.isValid());
        }
        @Test
        void testIsValid_NullData() {
            JSONFile invalidFile = new JSONFile("test.json", 10, null);
            assertFalse(invalidFile.isValid());
        }
        
        @Test
        void testGetSize() {
            JSONFile file = new JSONFile("test.json", 15, "{\"key\": \"value\"}");
            assertEquals(15, file.getSize());
        }
        
        @Test
        void testGetData() {
            JSONFile file = new JSONFile("test.json", 20, "{\"key\": \"value\"}");
            assertEquals("{\"key\": \"value\"}", file.getData());
        }


    }

    class FileManagerTest{

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

    class InteractionMenuTest {
    
        @Test
        void testDisplayMenu() {
            InteractionMenu menu = new InteractionMenu(new FileManager());
            // It's difficult to test JOptionPane directly, 
            // so we can't test the actual display, but we can test that no exceptions are thrown
            assertDoesNotThrow(() -> menu.displayMenu());
        }
        
        @Test
        void testFetchData_NoFileUploaded() {
            FileManager fileManager = new FileManager();
            InteractionMenu menu = new InteractionMenu(fileManager);
            // It's difficult to test JOptionPane directly, 
            // so we can't test the actual display, but we can test that no exceptions are thrown
            assertDoesNotThrow(() -> menu.fetchData(null));
        }
        

    }


}
