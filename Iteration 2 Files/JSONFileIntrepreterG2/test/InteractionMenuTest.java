import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InteractionMenuTest {


        public void main(){
            testInteractionMenu();
            testDisplayMenu();
            testFetchData_NoFileUploaded();
        }
        @Test
        public void testInteractionMenu(){
            JSONFile json= new JSONFile("file", 50, "{objects:[{\"hard\": \"rock\"},{\"soft\": \"pillow\"}]}");

            assertEquals(true, json.isValid());
            assertEquals(50,json.getSize());
            assertEquals("{objects:[{\"hard\": \"rock\"},{\"soft\": \"pillow\"}]}", json.getData());

        }

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
            assertDoesNotThrow(() -> menu.fetchData(null, false, false));
        }
        

    }