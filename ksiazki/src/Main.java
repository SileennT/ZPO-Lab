public class Main {
    public static void main(String[] args) {
        Publication k1 = new Book("Adam Mickiewicz","Pan Tadeusz", 340);
        Publication k2 = new Book("Adam Mickiewicz","Dziady", 130);
        Publication kk1 = new KsiazkaZOkladkaMiekka(k1);
        Publication kk2 = new KsiazkaZOkladkaTwarda(k2);
        Publication kk3 = new KsiazkaZOkladkaMiekka(kk2);
        Publication fakeOkladka = new KsiazkaZOkladkaTwarda(k1);
        Publication fakeBook = new KsiazkaZObwoluta(k1);
        Publication kkk2 = new KsiazkaZObwoluta(kk2);
        Publication odrzut = new KsiazkaZObwoluta(kkk2);
        try {
            Publication dziadyZAutografemWieszcza = new KsiazkaZAutografem(kk2, "Drogiej Hani - Adam Mickiewicz");
            System.out.println(dziadyZAutografemWieszcza);
            Publication dziadyZDwomaAutografami = new KsiazkaZAutografem(dziadyZAutografemWieszcza, "Haniu, to nieprawda, Dziady napisałem ja Julek Słowacki");
            System.out.println(dziadyZDwomaAutografami);
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println(kk1);
        System.out.println(kk2);

    }
}
