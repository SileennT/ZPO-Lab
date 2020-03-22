import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class Konwersja {
    public static void main(String[] args) {
        int liczba = 0b1101_1000;
        System.out.println(liczba);
        System.out.println("Jaki system koweresji Cie interesuje: trojkowy, dziesiatkowy ,szenastkowy");
        Scanner scan = new Scanner(System.in);
        String halo = scan.nextLine();
        halo = halo.toLowerCase();
        if(halo.equals("trojkowy")){
            Conv.trojkowy(liczba);
        }
        else if(halo.equals("dziesiatkowy")){
            Conv.dziesiatkowy(liczba);
        }
        else if(halo.equals("szesnastkowy")){
            Conv.szesnastkowy(liczba);
        }
        else{
            System.out.println("Podałes niepoprawne dane :)");
            System.exit(-1);
        }
    }
}

class Conv{
    static void szesnastkowy(int liczba) {
        System.out.println(Integer.toString(liczba, 16));
    }
    static void trojkowy(int liczba) {
        System.out.println(Integer.toString(liczba, 3));
    }
    static void dziesiatkowy(int liczba) {
        System.out.println(Integer.toString(liczba, 10));
    }
}

