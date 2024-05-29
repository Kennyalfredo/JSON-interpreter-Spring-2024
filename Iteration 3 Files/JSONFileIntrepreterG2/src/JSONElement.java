public class JSONElement {
    String data;

    public JSONElement(String data) {
        this.data = data;
    }

    public boolean contains(String keyword) {
        return data.contains(keyword);
    }
}