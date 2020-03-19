package ergaf.step.booking;

import ergaf.step.flight.Flight;

import java.util.ArrayList;

public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void addBooking(Booking... booking) {
        bookingService.addBooking(booking);
    }

//    public ArrayList<Flight> getAllBookings()
//    {
//        return service.getAllFlights();
//    }
}
