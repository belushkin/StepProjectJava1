package ergaf.step.flight;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Flight implements Serializable {
    String from;
    String to;
    LocalDate at;
    String id;
    int freePlaces;

    public Flight(String from, String to, LocalDate at, String id, int freePlaces) {
        this.from = from;
        this.to = to;
        this.at = at;
        this.id = id;
        this.freePlaces = freePlaces;
    }

    public void prettyFormat() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateGenerator.DATE_PATTERN);
        return "рейс: [" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", at='" + at + '\'' +
                ", id='" + id + '\'' +
                ", freePlaces=" + freePlaces +
                ", flightDate=" + formatter.format(at) +
                ']';
    }

}
