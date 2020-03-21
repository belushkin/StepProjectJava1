package ergaf.step.booking;

import java.util.ArrayList;

public class BookingDao implements BookingBaseInterface {

    private ArrayList<Booking> bookings = new ArrayList<>();

    @Override
    public ArrayList<Booking> getAllBookings() {
        return bookings;
    }

    @Override
    public Booking addBooking(Booking booking) {
        int index = bookings.indexOf(booking);
        if (index == -1) {
            bookings.add(booking);
        } else {
            bookings.set(index, booking);
        }
        return booking;
    }

    @Override
    public void clearBookings() {
        bookings.clear();
    }

    @Override
    public void loadData(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public boolean deleteBooking(Booking booking) {
        return bookings.remove(booking);
    }

}
