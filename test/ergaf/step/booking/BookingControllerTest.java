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
    public void display_flights_by_user() {
        //given
        User user = userController.addUser(new User("A", "B"));
        Flight flight = flightsController.getFlightById(1);
        bookingController.addBooking(new Booking(flight, user));
        //when
        List<Booking> bookings = bookingController.getBookingsByUser(user);
        //then
        bookingController.displayFlights(bookings);
    }

    @Test
    public void cancel_booking_works_properly() {
        //given
        User user = userController.addUser(new User("A", "B"));
        Flight flight1 = flightsController.getFlightById(1);
        Flight flight2 = flightsController.getFlightById(2);
        bookingController.addBooking(new Booking(flight1, user));
        bookingController.addBooking(new Booking(flight2, user));

        //when
        List<Booking> bookings = bookingController.getBookingsByUser(user);
        assertEquals(2, bookings.size());

        //then
        assertTrue(bookingController.cancelBookingById(1));
        assertEquals(flight2, bookingController.getBookingById(2).getFlight());
    }

    @Test
    public void adding_equal_bookings_does_not_add_new_one() {
        //given
        User user = userController.addUser(new User("A", "B"));
        Flight flight = flightsController.getFlightById(1);
        bookingController.addBooking(new Booking(flight, user));
        bookingController.addBooking(new Booking(flight, user));

        //when
        List<Booking> bookings = bookingController.getBookingsByUser(user);

        //then
        assertEquals(1, bookings.size());
    }

    @Test
    public void display_bookings_by_user() {
        //given
        User user1 = userController.addUser(new User("A", "B"));
        Flight flight1 = flightsController.getFlightById(1);
        Flight flight2 = flightsController.getFlightById(2);
        bookingController.addBooking(new Booking(flight1, user1));
        bookingController.addBooking(new Booking(flight2, user1));

        User user2 = userController.addUser(new User("B", "C"));
        Flight flight3 = flightsController.getFlightById(3);
        Flight flight4 = flightsController.getFlightById(4);
        bookingController.addBooking(new Booking(flight3, user2));
        bookingController.addBooking(new Booking(flight4, user2));

        //when
        //then
        bookingController.displayBookings(bookingController.getAllBookings());
    }

    @Test
    public void login_and_password_rewrite_user_when_register_booking() {
        //given
        User user1 = userController.addUser(new User("A", "B").setLogin("a").setPassword("b"));
        Flight flight = flightsController.getFlightById(1);
        User user2 = userController.addUser(new User("A", "B"));
        bookingController.addBooking(new Booking(flight, user2));
        //when
        //then
        assertEquals(1, userController.getUserById(1).getId());
        assertEquals("a", userController.getUserById(1).getLogin());
        assertEquals("b", userController.getUserById(1).getPassword());
    }
}
