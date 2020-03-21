package ergaf.step.booking;

import java.io.Serializable;

public class Booking implements Serializable {

    private int flightId;
    private int userId;

    public Booking(int flightId, int userId) {
        this.flightId = flightId;
        this.userId = userId;
    }

    public int getFlightId() {
        return flightId;
    }

    public int getUserId() {
        return userId;
    }
}
