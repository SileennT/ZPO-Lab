import java.text.DecimalFormat;
import java.util.*;

public class PolEngTest {
    Scanner scan = new Scanner(System.in);
    private String name;
    private String surename;


    public Set<Question> questions = new HashSet<Question>();
    public double time;
    public double score;

    public PolEngTest() {
        time = 0;
        List<Question> temp = JsonHelp.GetQeestions();
        while (questions.size() < 5) {
            Question tmp = temp.get(new Random().nextInt(temp.size()));
            if(!questions.contains(tmp))
                questions.add(tmp);

        }
    }


    public void Start() {
        score = 0;
        System.out.println("Imie: ");
        name = scan.nextLine();
        System.out.println("Nazwisko: ");
        surename = scan.nextLine();
        long start = System.nanoTime();
        for (Question q : questions) {
            System.out.println(q.Pol);
            String answer = scan.nextLine();

            for (String e : q.Eng) {
                if (Levenstein.LevQWERTY(e, answer.toLowerCase()) == 0) {
                    score++;
                }
                if (Levenstein.LevQWERTY(e, answer.toLowerCase()) == 1) {
                    score += 0.5;
                } else {
                    score += 0;
                }
            }
        }
        time = (System.nanoTime() - start) / 1000000000.0;
        Stop();
        System.out.println("Wynik: " + score);
        DecimalFormat decimal = new DecimalFormat("##.0");
        System.out.println("Czas: " + decimal.format(time) + "s");
    }

    public void Stop() {
        JsonHelp.pathOut = String.format("src/%s_%s.json", name, surename);
        JsonHelp.WriteJson(questions);
    }
}


class Levenstein {
    static int LevQWERTY(String s1, String s2) {
        int lengths1 = s1.length();
        int lengths2 = s2.length();
        int LevTab[][] = new int[lengths1 + 1][lengths2 + 1];
        for (int i = 0; i <= lengths1; i++) {
            LevTab[i][0] = i;
        }
        for (int i = 0; i <= lengths2; i++) {
            LevTab[0][i] = i;
        }
        int m = 0;
        int n = 0;
        for (int i = 1; i < lengths1 + 1; i++) {
            for (int j = 1; j < lengths2 + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    LevTab[i][j] = Math.min(Math.min(LevTab[i - 1][j] + 1, LevTab[i][j - 1] + 1), LevTab[i - 1][j - 1] + 0);
                } else {
                    LevTab[i][j] = Math.min(Math.min(LevTab[i - 1][j] + 1, LevTab[i][j - 1] + 1), LevTab[i - 1][j - 1] + 1);
                }
                m = j;
            }
            n = i;
        }
        return LevTab[n][m];
    }
}

