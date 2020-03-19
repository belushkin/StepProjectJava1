package ergaf.step.booking;

import java.io.Serializable;

public class Booking implements Serializable {

    private int flightId;
    private int seatsNumber;

    public Booking(int flightId, int seatsNumber) {
        this.flightId = flightId;
        this.seatsNumber = seatsNumber;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public int getFlightId() {
        return flightId;
    }

}
