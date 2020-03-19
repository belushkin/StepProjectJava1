package ergaf.step.flight;

import ergaf.step.LogOrError;
import ergaf.step.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateGenerator {

    private long beginTime;
    private long endTime;

    public final static String DATE_PATTERN = "dd/MM/yyyy hh:mm";

    public DateGenerator(String beginTime, String endTime) throws ParseException {
        Date beginDate = new SimpleDateFormat(DATE_PATTERN).
                parse(beginTime);
        Date endDate = new SimpleDateFormat(DATE_PATTERN).
                parse(endTime);


        this.beginTime = beginDate.getTime();
        this.endTime = endDate.getTime();
    }

    public static LocalDate getFlightDate(int flightYear, int flightMonth, int flightDay) {

        String flightDate = String.valueOf(flightDay) +
                '/' +
                flightMonth +
                '/' +
                flightYear;

        return LocalDate.parse(flightDate);
    }

    public LocalDateTime getRandomFlightLocalDateTime() {
        return Instant.ofEpochMilli(
                getRandomTimeBetweenTwoDates()
        ).atZone(
                ZoneId.systemDefault()
        ).toLocalDateTime();
    }

    private long getRandomTimeBetweenTwoDates () {
        long diff = endTime - beginTime + 1;
        return beginTime + (long) (Math.random() * diff);
    }
}
