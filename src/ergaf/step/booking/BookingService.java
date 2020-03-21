package ergaf.step.booking;

import java.util.ArrayList;

public class BookingService {

    private BookingDao bookingDao;

    private String filename = "bookings.data";

    public BookingService(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public BookingService(BookingDao bookingDao, String filename) {

        this.bookingDao = bookingDao;
        this.filename = filename;
    }

    public Booking getBookingById(int id) {
        return bookingDao.
                getAllBookings().
                stream().
                filter(booking -> booking.getId() == id).
                findFirst().
                orElse(null);
    }

    public int count() {
        return getAllBookings().size();
    }

    public int getNextId() {
        int id = bookingDao.getAllBookings().
                stream().
                mapToInt(Booking::getId).
                reduce((first,second) -> second).orElse(0);

        return id + 1;
    }

    public Booking addBooking(Booking booking) {
        return bookingDao.addBooking(booking.setId(getNextId()));
    }

    public ArrayList<Booking> getAllBookings() {
        return bookingDao.getAllBookings();
    }
}
