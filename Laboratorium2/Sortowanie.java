import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Sortowanie {
    public static void main(String[] args) {

        Collator collator = Collator.getInstance(new Locale("pl", "PL"));
        String[] names =new String[] {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka",
                "Zyta", "Órszula", "Świętopełk"};
        int length = names.length;
        sort.sortStrings(collator,names);
        for(int i=0; i<length; i++)
        {
            System.out.print(names[i]+" ");
        }
        System.out.println("");
        names =new String[] {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka",
                "Zyta", "Órszula", "Świętopełk"};

        sort.fastSortStrings(collator,names);
        for(int i=0; i<length; i++)
        {
            System.out.print(names[i]+" ");
        }
        System.out.println("");
        names =new String[] {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka",
                "Zyta", "Órszula", "Świętopełk"};
        sort.fastSortStrings2(collator, names);
        for(int i=0; i<length; i++)
        {
            System.out.print(names[i]+" ");
        }
        System.out.println("");
        sort.czas_trwania(collator,names);
    }
}

class sort {
    static void sortStrings(Collator collator, String[] words) {
        int length = words.length;
        for (int j = 1; j < length; j++) {
            String key = words[j];
            int i = j - 1;
            while ((i > -1) && collator.compare(words[i], key) == 1) {
                words[i + 1] = words[i];
                i--;
            }
            words[i + 1] = key;
        }
    }
    static void fastSortStrings(Collator collator, String[] words){
        Arrays.sort(words, new Comparator<String>() {
                @Override
            public int compare(String s, String t1) {
                return collator.compare(s, t1);
            }
        });
    }
    static void fastSortStrings2(Collator collator, String[] words){
    Arrays.sort(words,(wyraz1,wyraz2)->collator.compare(wyraz1,wyraz2));
    }
    static long czas_trwania(Collator collator, String[] words){
       long starTtime = System.nanoTime();
                for(int i=0; i<=100000; i++){
                    sortStrings(collator,words);
                    words =new String[] {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka",
                            "Zyta", "Órszula", "Świętopełk"};
                }
        long stopTime= System.nanoTime();
        long wynik = stopTime - starTtime;
        System.out.println("Insert Sort");
        System.out.println(wynik+"ns");
        System.out.println(wynik/10000000+"ms");
        starTtime = System.nanoTime();
                 for(int i=0; i<=100000; i++) {
                     words = new String[]{"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka",
                             "Zyta", "Órszula", "Świętopełk"};
                     sort.fastSortStrings(collator, words);
                     }
        stopTime= System.nanoTime();
        wynik = stopTime - starTtime;
        System.out.println("Fast sort 1");
        System.out.println(wynik+"ns");
        System.out.println(wynik/10000000+"ms");

        starTtime = System.nanoTime();
                for(int i=0; i<=100000; i++) {
                words = new String[]{"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka",
                "Zyta", "Órszula", "Świętopełk"};
                    sort.fastSortStrings2(collator, words);
                    }
        stopTime= System.nanoTime();
        wynik = stopTime - starTtime;
        System.out.println("Fast sort 2");
        System.out.println(wynik+"ns");
        System.out.println(wynik/10000000+"ms");
        return 0;
    }


}
