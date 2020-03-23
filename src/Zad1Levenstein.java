import java.util.HashMap;
import java.util.Scanner;

public class Zad1Levenstein {
    public static void main(String[] args) {

        System.out.println("Podaj pierwszy wyraz: ");
        Scanner scan = new Scanner(System.in);
        String wyraz1 = scan.nextLine();

        System.out.println("Podaj drugi wyraz: ");
        String wyraz2 = scan.nextLine();

        if(Validate.czy_istnieje(wyraz1,wyraz2) == false){
            System.out.println("Nie istniejacy wyraz");
            System.exit(-1);
        }
        else if(Validate.czy_duze(wyraz1,wyraz2) == false){
            System.out.println("Podales wyraz ktory zawiera liczbe, duza litere lub znak specjalny");
            System.exit(-1);
        }

        System.out.println(Levenstein.LevQWERTY(wyraz1,wyraz2));
        System.exit(0);
    }
}

class Levenstein{
    static double LevQWERTY(String s1, String s2){
        HashMap<Character, String> dictionary = new HashMap<Character, String>();
        dictionary.put('q',"ww");
        dictionary.put('w',"qe");
        dictionary.put('e',"wr");
        dictionary.put('r',"et");
        dictionary.put('t',"ry");
        dictionary.put('y',"tu");
        dictionary.put('u',"yi");
        dictionary.put('i',"uo");
        dictionary.put('o',"ip");
        dictionary.put('p',"oo");
        dictionary.put('a',"ss");
        dictionary.put('s',"ad");
        dictionary.put('d',"sf");
        dictionary.put('f',"dg");
        dictionary.put('g',"fh");
        dictionary.put('h',"gj");
        dictionary.put('j',"hk");
        dictionary.put('k',"jl");
        dictionary.put('l',"kk");
        dictionary.put('z',"xx");
        dictionary.put('x',"zc");
        dictionary.put('c',"xv");
        dictionary.put('v',"cb");
        dictionary.put('b',"vn");
        dictionary.put('n',"bm");
        dictionary.put('m',"nn");

        int lengths1 = s1.length();
        int lengths2 = s2.length();
        double LevTab[][] = new double [lengths1+1][lengths2+1];
        for(int i = 0; i<=lengths1; i++)
        {
            LevTab[i][0] = i;
        }
        for(int i = 0; i<=lengths2; i++)
        {
            LevTab[0][i] = i;
        }
        int m = 0;
        int n = 0;
        for(int i=1;i<lengths1+1; i++){
            for(int j=1; j<lengths2+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    LevTab[i][j] = Math.min(Math.min(LevTab[i-1][j]+1, LevTab[i][j-1]+1), LevTab[i-1][j-1]+0);
                }
                else{
                    if(s1.charAt(i-1) == dictionary.get(s2.charAt(j-1)).charAt(0) || s1.charAt(i-1) == dictionary.get(s2.charAt(j-1)).charAt(1)){
                        LevTab[i][j] = Math.min(Math.min(LevTab[i-1][j]+1, LevTab[i][j-1]+1), LevTab[i-1][j-1]+0.5);
                    }
                    else{
                        LevTab[i][j] = Math.min(Math.min(LevTab[i-1][j]+1, LevTab[i][j-1]+1), LevTab[i-1][j-1]+1);
                    }
                }
                m=j;
            }
            n=i;
        }

        return LevTab[n][m];
    }
}

class Validate{
    static boolean czy_istnieje(String s1, String s2) {

        if (s1 == null) {
            return false;
        }
        if (s2 == null) {
            return false;
        }
        return true;
    }
    static boolean czy_duze(String s1, String s2){
        int lengths1 = s1.length();
        int lengths2 = s2.length();

        for(int i = 0; i<lengths1; i++){
            if(s1.charAt(i) < 'a' || s1.charAt(i) > 'z'){
                return false;
            }
        }
        for(int i = 0; i<lengths1; i++){
            if(s2.charAt(i) < 'a' || s2.charAt(i) > 'z'){
                return false;
            }
        }
        return true;
    }
}