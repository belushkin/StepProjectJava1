package ergaf.step.flight;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Flight implements Serializable {

    private int id;
    private String from;
    private String to;
    private LocalDateTime at;
    private int freePlaces;

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

    public Flight(int id, String from, String to, LocalDateTime at, int freePlaces) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.at = at;
        this.freePlaces = freePlaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return getId() == flight.getId() &&
                getFreePlaces() == flight.getFreePlaces() &&
                getFrom().equals(flight.getFrom()) &&
                getTo().equals(flight.getTo()) &&
                getAt().equals(flight.getAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFrom(), getTo(), getAt(), getFreePlaces());
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", at=" + at +
                ", freePlaces=" + freePlaces +
                '}';
    }

    public String prettyFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateGenerator.DATE_PATTERN);
        StringBuilder flight = new StringBuilder();
        flight.append("\t" + String.format("%1$-" + 10 + "s", getFrom()));
        flight.append("\t -> \t");
        flight.append(String.format("%1$-" + 10 + "s", getTo()));
        flight.append("\t" + formatter.format(getAt()) + " ");
        flight.append("\t Free seats: " + getFreePlaces());

        return flight.toString();
    }
}
