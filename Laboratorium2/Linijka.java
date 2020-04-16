public class Linijka {
    public static void main(String[] args) {
        RysujLinijke(3,4);
    }
    public static void RysujLinijke(int Podzialka, int dlugoscLinijki) {
        dlugoscLinijki*=2;
        Rekurencja(dlugoscLinijki, 0, dlugoscLinijki);
        for (int i=1; i<=Podzialka; i++) {
            Podzialka(dlugoscLinijki -1, dlugoscLinijki);
            Rekurencja(dlugoscLinijki, i, dlugoscLinijki);
        }
    }
    public static void Rekurencja(int dlugoscPomiedzy, int dlugoscLinijki) {
        Rekurencja(dlugoscPomiedzy, -1, dlugoscLinijki);
    }

    public static void Rekurencja(int dlugoscPodzialki, int oznaczeniePodzialki, int dlugoscLinijki) {
        int spacja=dlugoscLinijki-dlugoscPodzialki;
        for (int i=0; i<dlugoscPodzialki; i++){
            char c;
            if(i<spacja){
                c=' ';
            }
            else{
                c='-';
            }
            System.out.printf("%c", c);
            if(i == dlugoscPodzialki - 1 && oznaczeniePodzialki >=0) {
                System.out.printf(" %d", oznaczeniePodzialki);
            }
        }
        System.out.print("\n");
    }

    public static void Podzialka(int dlugoscJednejPodzialkki, int dlugoscLinijki) {
        if (dlugoscJednejPodzialkki>dlugoscLinijki*0.5) {
            Podzialka(dlugoscJednejPodzialkki - 1, dlugoscLinijki);
            Rekurencja(dlugoscJednejPodzialkki, dlugoscLinijki);
            Podzialka(dlugoscJednejPodzialkki - 1, dlugoscLinijki);
        }
    }
}
