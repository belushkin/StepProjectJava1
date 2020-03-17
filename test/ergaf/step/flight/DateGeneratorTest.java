package ergaf.step.flight;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class DateGeneratorTest {

    @Test
    void getDateString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateGenerator.DATE_PATTERN);
//        formatter.format(getFlightDateLocalDate())
        try {
            DateGenerator dateGenerator = new DateGenerator(
                    "31/12/1998 10:00",
                    "31/12/2020 10:00"
            );
            System.out.println(dateGenerator.getFlightDateLocalDateTime());
        } catch (ParseException ignored) {

        }
//        assertEquals();
    }
}