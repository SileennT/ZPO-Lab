import java.io.IOException;

public class main {
    public static void main(String[] args) {
        try {
            DaneStream.RunFile("src/dane.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
