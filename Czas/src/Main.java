import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static java.util.Objects.isNull;

public class Main {

    public static void main(String[] args) {
    }

    public static long secondWorldWar(LocalDate warBegin, LocalDate warEnd) {
        if (isNull(warBegin) | isNull(warEnd)) {
            return -1;
        } else {
            return ChronoUnit.DAYS.between(warBegin, warEnd) + 1;
        }
    }
    public static int dayOfYear(int year, int day){
        LocalDate calendar = LocalDate.ofYearDay(year,day);
        day = calendar.getDayOfMonth();
        year = calendar.getMonthValue();
        if(day < 1 || day>365 ){
            return -1;
        }
        else{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM");
            return Integer.parseInt(formatter.format(calendar));
        }
    }
}