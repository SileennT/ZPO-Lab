import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class sortTest {

    @Test
    void sortStrings() {
        Collator collator = Collator.getInstance(new Locale("pl", "PL"));
        String[] sortowanie= new String[] {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka",
                "Zyta", "Órszula", "Świętopełk"};
        String[] posortowane = new String[]{"Agnieszka","Darek","Łukasz","Órszula","Stefania","Ścibor","Świętopełk","Zyta" };
        sort.sortStrings(collator,sortowanie);
        assertArrayEquals(posortowane,sortowanie);
    }

    @Test
    void fastSortStrings() {
        Collator collator = Collator.getInstance(new Locale("pl", "PL"));
        String[] sortowanie= new String[] {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka",
                "Zyta", "Órszula", "Świętopełk"};
        String[] posortowane = new String[]{"Agnieszka","Darek","Łukasz","Órszula","Stefania","Ścibor","Świętopełk","Zyta" };
        sort.fastSortStrings(collator,sortowanie);
        assertArrayEquals(posortowane,sortowanie);
    }

    @Test
    void fastSortStrings2() {
        Collator collator = Collator.getInstance(new Locale("pl", "PL"));
        String[] sortowanie= new String[] {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka",
                "Zyta", "Órszula", "Świętopełk"};
        String[] posortowane = new String[]{"Agnieszka","Darek","Łukasz","Órszula","Stefania","Ścibor","Świętopełk","Zyta" };;
        sort.fastSortStrings2(collator,sortowanie);
        assertArrayEquals(posortowane,sortowanie);
    }
}