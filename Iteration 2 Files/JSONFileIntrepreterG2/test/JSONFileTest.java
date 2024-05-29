import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JSONFileTest {


        public void main(){
            testJSONFile();
            testIsValid();
            testIsValid_NullData();
            testGetSize();
            testGetData();
        }

        @Test
        public void testJSONFile(){
            JSONFile json= new JSONFile("file", 50, "{objects:[{\"hard\": \"rock\"},{\"soft\": \"pillow\"}]}");
            assertEquals(true, json.isValid());
            assertEquals(50,json.getSize());
            assertEquals("{objects:[{\"hard\": \"rock\"},{\"soft\": \"pillow\"}]}", json.getData());
        
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