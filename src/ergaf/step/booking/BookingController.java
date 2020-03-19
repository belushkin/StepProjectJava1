package ergaf.step.booking;


public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void addBooking(Booking... booking) {
        bookingService.addBooking(booking);
    }

    public int count() {
        return bookingService.count();
    }

//    public ArrayList<Flight> getAllBookings()
//    {
//        return service.getAllFlights();
//    }
}
