package ergaf.step.booking;

import ergaf.step.flight.Flight;
import ergaf.step.user.User;

import java.io.Serializable;
import java.util.Objects;

public class Booking implements Serializable {

    private int id;
    private Flight flight;

    public Flight getFlight() {
        return flight;
    }

    public User getUser() {
        return user;
    }

    private User user;

    public Booking(Flight flight, User user) {
        this.flight = flight;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return getId() == booking.getId() &&
                flight.equals(booking.flight) &&
                user.equals(booking.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), flight, user);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", flight=" + flight +
                ", user=" + user +
                '}';
    }

    public int getId() {
        return id;
    }

    public Booking setId(int id) {
        this.id = id;
        return this;
    }
}
