package ergaf.step.booking;

import java.util.Arrays;

public class BookingService {

    private BookingDao bookingDao;

    private String filename = "bookings.data";

    public BookingService(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public BookingService(BookingDao bookingDao, String filename) {

        this.bookingDao = bookingDao;
        if (filename != null) {
            this.filename = filename;
        }
    }

    public void addBooking(Booking... bookings) {
        Arrays.stream(bookings).forEach(flight -> bookingDao.addBooking(flight));
    }
}
