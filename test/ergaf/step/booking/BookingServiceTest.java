package ergaf.step.booking;

import ergaf.step.flight.DateGenerator;
import ergaf.step.flight.Flight;
import ergaf.step.flight.FlightDao;
import ergaf.step.flight.FlightsService;
import ergaf.step.user.User;
import ergaf.step.user.UserDao;
import ergaf.step.user.UserService;
import org.junit.Before;
import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {

    BookingService bookingService;
    UserService userService;
    FlightsService flightsService;
    DateGenerator dateGenerator;

    @Before
    public void executedBeforeEach() {
        bookingService = new BookingService(
                new BookingDao()
        );
        userService = new UserService(
                new UserDao()
        );
        flightsService = new FlightsService(
                new FlightDao()
        );

        try {
            dateGenerator = new DateGenerator(
                    "31/12/1998 10:00",
                    "31/12/2020 10:00"
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void get_bookings_should_return_bookings() {
        //given
        User user = userService.addUser(
                new User("A", "B")
        );
        Flight flight = flightsService.addFlight(
                new Flight("Kyiv",
                        "London",
                        dateGenerator.getRandomFlightLocalDateTime(),
                        12
                )
        );
        //when
        Booking booking = bookingService.addBooking(
                new Booking(flight, user)
        );

        //then
        assertEquals(1, bookingService.count());
        assertEquals(1, bookingService.getBookingById(1).getId());
    }
}