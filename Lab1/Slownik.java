import java.util.Scanner;
import java.util.HashMap;
import java.util.function.DoubleToIntFunction;

public class Slownik {
    public static void main(String[] args) {
        System.out.print("podaj liczbe slownie: ");
        Scanner scan = new Scanner(System.in);
        String liczba = scan.nextLine();
        System.out.println(dictionary.liczba(liczba));
    }
}

class dictionary{
    static StringBuffer liczba(String a){
        StringBuffer b = new StringBuffer();
        HashMap<Character, String> liczby = new HashMap<Character, String>();
        liczby.put('1',"jeden");
        liczby.put('2',"dwa");
        liczby.put('3',"trzy");
        liczby.put('4',"cztery");
        liczby.put('5',"pięć");
        liczby.put('6',"sześć");
        liczby.put('7',"siedem");
        liczby.put('8',"osiem");
        liczby.put('9',"dziewięć");
        liczby.put('0',"zero");
        liczby.put('-',"minus");

        if(a.length()>4 || (a.length() > 3 && a.charAt(0)!= '-')){
            throw new NumberFormatException("Podana wartość jest za długa :(");
        }
        else if(czy_numeryczne(a) == false){
            throw new NumberFormatException("Podana wartosć nie jest poprawną wartościa liczbową");
        }
        for(int i = 0; i<a.length(); i++){
            b.append(liczby.get(a.charAt(i)));
            b.append(' ');
        }
        return b;
    }

    static boolean czy_numeryczne(String value){
        double a;
        try {
            a = Double.parseDouble(value);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
