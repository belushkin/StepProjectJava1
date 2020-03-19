package ergaf.step.booking;

import java.util.ArrayList;

public interface BookingBaseInterface {
    public ArrayList<Booking> getAllBookings();
    public void addBooking(Booking booking);
    public void clearBookings();
    public void loadData(ArrayList<Booking> bookings);
}
