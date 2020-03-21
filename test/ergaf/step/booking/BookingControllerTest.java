package ergaf.step.booking;

import ergaf.step.flight.*;
import ergaf.step.user.User;
import ergaf.step.user.UserController;
import ergaf.step.user.UserDao;
import ergaf.step.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class BookingControllerTest {

    FlightsController flightsController;
    BookingController bookingController;
    UserController userController;

    private final static int FLIGHTS_AMOUNT = 20;

    private final static String TEST_FLIGHTS_DB = "flights.test.data";
    private final static String TEST_BOOKINGS_DB = "bookings.test.data";
    private final static String TEST_USERS_DB = "users.test.data";

    @BeforeEach
    public void executedBeforeEach() {
        flightsController = new FlightsController(
                new FlightsService(
                        new FlightDao(),
                        TEST_FLIGHTS_DB
                )
        );
        FlightCreator flightCreator = new FlightCreator(flightsController, FLIGHTS_AMOUNT);
        flightCreator.createFlightBase();

        bookingController = new BookingController(
                new BookingService(
                        new BookingDao(),
                        TEST_BOOKINGS_DB
                )
        );

        userController = new UserController(
                new UserService(
                        new UserDao(),
                        TEST_USERS_DB
                )
        );
    }

    @Test
    public void save_data_generates_db_when_called() {
        //given
        User user = userController.addUser(new User("A", "B"));
        Flight flight = flightsController.getFlightById(1);
        bookingController.addBooking(new Booking(flight, user));

        //when
        ArrayList<Booking> bookings = bookingController.getAllBookings();
        bookingController.saveData(bookings);
        //then
        bookingController.loadData();
        assertEquals(bookings, bookingController.getAllBookings());
    }

    @Test
    public void get_bookings_by_user_returns_bookings() {
        //given
        User user = userController.addUser(new User("A", "B"));
        Flight flight = flightsController.getFlightById(1);
        bookingController.addBooking(new Booking(flight, user));
        //when
        List<Booking> bookings = bookingController.getBookingsByUser(user);
        //then
        assertEquals(1, bookings.size());
    }

    @Test
    public void display_bookings_by_user() {
        //given
        User user = userController.addUser(new User("A", "B"));
        Flight flight = flightsController.getFlightById(1);
        bookingController.addBooking(new Booking(flight, user));
        //when
        List<Booking> bookings = bookingController.getBookingsByUser(user);
        //then
        bookingController.displayFlights(bookings);
    }
}