import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class JSONFileTest {

    @Test
    public void testJSONFile(){
        JSONFile json = new JSONFile("file", 15, "Hello");

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