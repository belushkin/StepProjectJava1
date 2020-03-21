package ergaf.step.booking;


import ergaf.step.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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

    public void saveData(ArrayList<Booking> bookings){
        bookingService.saveData(bookings);
    }

    public void loadData(){
        bookingService.loadData(
                bookingService.prepareData()
        );
    }

    public List<Booking> getBookingsByUser(User user) {
        return bookingService.getBookingsByUser(user);
    }

    public void displayFlights(List<Booking> bookings) {
        bookings.forEach(booking -> System.out.println(booking.getFlight().prettyFormat()));
    }

}
