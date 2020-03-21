package ergaf.step.booking;


import java.util.ArrayList;

public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public Booking addBooking(Booking booking) {
        return bookingService.addBooking(booking);
    }

    public int count() {
        return bookingService.count();
    }

    public ArrayList<Booking> getAllBookings()
    {
        return bookingService.getAllBookings();
    }
}
