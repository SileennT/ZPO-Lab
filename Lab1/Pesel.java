import java.util.Scanner;
import java.util.function.DoubleToIntFunction;


public class Pesel {
    public static void main(String[] args) {
        System.out.print("Podaj PESEL: ");
        Scanner scan = new Scanner((System.in));
        String idpesel = scan.nextLine();
        if(walidacja.dlugosc(idpesel) == false) {
            System.out.print("Podałes błędnie pesel");
            System.exit(-1);
        }
        else if (walidacja.czy_numeryczne(idpesel) == false){
            System.out.println("Podales bledny pesel");
            System.exit(-2);
        }
        else if(walidacja.suma_kontrolna(idpesel) == false){
            System.out.println("Nieprawidlowa suma kontrolna");
            System.exit(-3);
        }
        if(data.dataval(idpesel)!=1){
            System.out.println("Nieprawidlowa data");
            System.exit(-4);
        }
        walidacja.plec(idpesel);
    }

}

class walidacja{
    static boolean dlugosc(String pesel){
        if(pesel.length() != 11){
            return false;
        }
        return true;
    }

    static boolean czy_numeryczne(String pesel){
        double a;
        try{
            a=Double.parseDouble(pesel);
        }
        catch(NumberFormatException nfe){
            return false;
        }
        return true;
    }
    static boolean suma_kontrolna(String pesel){
        int suma = 9*(pesel.charAt(0) - '0') + 7*(pesel.charAt(1) - '0') + 3*(pesel.charAt(2) - '0') + 1*(pesel.charAt(3) - '0')
                + 9*(pesel.charAt(4) - '0') + 7*(pesel.charAt(5) - '0') + 3*(pesel.charAt(6) - '0') + 1*(pesel.charAt(7) - '0')
                + 9*(pesel.charAt(8) - '0') + 7*(pesel.charAt(9) - '0');
        suma = suma%10;
        if(suma!=(pesel.charAt(10)-'0')){
            return false;
        }
        return true;
    }
    static void plec(String pesel){
        int plec = (pesel.charAt(9)-'0');
        if(plec%2 == 1){
            System.out.println("Mezczyzna");
        }
        else{
            System.out.println("Kobieta");
        }
    }
}

class data{
    static int rokurodzenia(String yy){
        int rok = 0;
        if(yy.charAt(2) == 2 || yy.charAt(2) == 3)
        {
            rok = (yy.charAt(1)-'0') + (yy.charAt(0) -'0')*10 + 2000;
        }
        else if(yy.charAt(2) == 5 || yy.charAt(2) == 4)
        {
            rok = (yy.charAt(1)-'0') + (yy.charAt(0) -'0')*10 + 2100;
        }
        else if(yy.charAt(2) == 7 || yy.charAt(2) == 6)
        {
            rok = (yy.charAt(1)-'0') + (yy.charAt(0) -'0')*10 + 2200;
        }
        else if(yy.charAt(2) == 9 || yy.charAt(2) == 8)
        {
            rok = (yy.charAt(1)-'0') + (yy.charAt(0) -'0')*10 + 1800;
        }
        else{
            rok = (yy.charAt(1)-'0') + (yy.charAt(0) -'0')*10 + 1900;
        }
        //System.out.println(rok);
        return rok;
    }
    static int miesiacurodzenia(String mm){
        int miesiac = 0;
        if(mm.charAt(2) == 2 || mm.charAt(2) == 3)
        {
            miesiac = (mm.charAt(3)-'0') + (mm.charAt(2) -'0')*10 - 20;
        }
        else if(mm.charAt(2) == 5 || mm.charAt(2) == 4)
        {
            miesiac = (mm.charAt(3)-'0') + (mm.charAt(2) -'0')*10 - 40;
        }
        else if(mm.charAt(2) == 7 || mm.charAt(2) == 6)
        {
            miesiac = (mm.charAt(3)-'0') + (mm.charAt(2) -'0')*10 - 60;
        }
        else if(mm.charAt(2) == 9 || mm.charAt(2) == 8)
        {
            miesiac = (mm.charAt(3)-'0') + (mm.charAt(2) -'0')*10 - 80;
        }
        else{
            miesiac = (mm.charAt(3)-'0') + (mm.charAt(2) -'0')*10;
        }
       //System.out.println(miesiac);
        return miesiac;
    }
    static int dzienurodzenia(String dd){
        int dzien = (dd.charAt(5)-'0') + (dd.charAt(4) -'0')*10;
        //System.out.println(dzien);
        return dzien;
    }
    static int dataval(String pesel){
        int dd = dzienurodzenia(pesel);
        int mm = miesiacurodzenia(pesel);
        int yy = rokurodzenia(pesel);

        if(dd < 1 || dd > 31){
            return -1;
        }
        else if(mm < 1 || mm > 12){
            return -1;
        }
        else if(mm == 2 && ((yy % 4 == 0 && dd > 29) || (yy%4 != 0 && dd > 28))){
            return -1;
        }
        else if((mm == 4 || mm == 6 || mm == 9 || mm == 11)  && dd >30){
            return -1;
        }
        else{
            if(mm<10){
                System.out.println(dd + ".0" +mm + "." +yy);
            }
            else {
                System.out.println(dd + "." + mm + "." + yy);
            }
        }
        return 1;
    }
}
