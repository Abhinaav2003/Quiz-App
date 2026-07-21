import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        // Launch Login Window
        SwingUtilities.invokeLater(() -> {
            new LoginFrame();
        });
    }
}