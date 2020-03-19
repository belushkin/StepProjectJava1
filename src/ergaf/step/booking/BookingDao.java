package ergaf.step.booking;

import ergaf.step.Logger;

import java.util.ArrayList;

public class BookingDao implements BookingBaseInterface {

    private ArrayList<Booking> bookings = new ArrayList<>();
    Logger logger = new Logger();

    @Override
    public ArrayList<Booking> getAllBookings() {
        return bookings;
    }

    @Override
    public void addBooking(Booking booking) {
        int index = bookings.indexOf(booking);
        if (index == -1) {
            bookings.add(booking);
        } else {
            bookings.set(index, booking);
        }
    }

    @Override
    public void clearBookings() {
        bookings.clear();
    }

    @Override
    public void loadData(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
}
