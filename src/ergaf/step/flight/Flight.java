package ergaf.step.flight;

import java.io.Serializable;
import java.util.Objects;

public class Flight implements Serializable {
    String from;
    String to;
    String at;
    String id;
    int freePlaces;

    {
        System.out.println("создался екземпляр "+this.getClass().getSimpleName());
    }

    public Flight(String from, String to, String at, String id, int freePlaces){
        this.from = from;
        this.to = to;
        this.at = at;
        this.id = id;
        this.freePlaces = freePlaces;
    }

    public void prettyFormat() {
        System.out.println("рейс:");
        System.out.print("    from: " + from);
        System.out.print("    to: " + to);
        System.out.print("    at: " + at);
        System.out.print("    id: " + id);
        System.out.print("    freePlaces: " + freePlaces);
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return freePlaces == flight.freePlaces &&
                Objects.equals(from, flight.from) &&
                Objects.equals(to, flight.to) &&
                Objects.equals(at, flight.at) &&
                Objects.equals(id, flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, at, id, freePlaces);
    }
}
