import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

public class Main {
    static JFXPanel jfxPanel = new JFXPanel();
    public static void main(String[] args) {
        PolEngTest polEngTest = new PolEngTest();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                polEngTest.Start();
                Platform.exit();
            }
        });

    }
}
