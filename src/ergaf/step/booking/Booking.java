package ergaf.step.booking;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Booking implements Serializable {

    private String destination;
    private LocalDateTime time;
    private int seatsNumber;

    public Booking(String destination, LocalDateTime time, int seatsNumber) {
        this.destination = destination;
        this.time = time;
        this.seatsNumber = seatsNumber;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getDestination() {
        return destination;
    }
}
