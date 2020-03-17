package ergaf.step.flight;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Flight implements Serializable {

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public LocalDateTime getAt() {
        return at;
    }

    public int getId() {
        return id;
    }

    public int getFreePlaces() {
        return freePlaces;
    }

    private String from;
    private String to;
    private LocalDateTime at;
    private int id;
    private int freePlaces;

    public Flight(int id, String from, String to, LocalDateTime at, int freePlaces) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.at = at;
        this.freePlaces = freePlaces;
    }

    public void prettyFormat() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateGenerator.DATE_PATTERN);
        return "flight: " +
                "id= " + id  +
                ", from= '" + from + '\'' +
                ", to= '" + to + '\'' +
                ", at= '" + formatter.format(at) + '\'' +
                ", free places= " + freePlaces;
    }

}
