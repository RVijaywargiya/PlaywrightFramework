package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String getCurrentDateDDMMYYYY() {
        return getDateFormatterDDMMYYYY().format(LocalDate.now());
    }

    public static DateTimeFormatter getDateFormatterDDMMYYYY() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }


}
