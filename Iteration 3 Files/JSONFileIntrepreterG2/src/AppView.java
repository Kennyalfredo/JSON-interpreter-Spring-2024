import javax.swing.JOptionPane;

public class AppView {
    public String getInput(String message) {
        return JOptionPane.showInputDialog(message);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}