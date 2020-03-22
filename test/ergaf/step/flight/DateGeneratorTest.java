package ergaf.step.flight;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

public class DateGeneratorTest {

    @Test
    public void getDateString() {
        try {
            for (int x = 0; x < 7; x++) {
                DateGenerator dateGenerator = new DateGenerator(
                        "31/12/1998 10:00",
                        "31/12/2020 10:00"
                );
                assertNotNull(dateGenerator.getRandomFlightLocalDateTime());
            }
        } catch (ParseException ignored) {

        }
    }
}
