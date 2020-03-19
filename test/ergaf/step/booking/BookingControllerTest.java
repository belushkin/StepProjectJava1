package ergaf.step.booking;

import ergaf.step.flight.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class BookingControllerTest {

    FlightsController flightsController;
    BookingController bookingController;

    private final static int FLIGHTS_AMOUNT = 5;
    private final static String TEST_DB = "bookings.test.data";

    @BeforeEach
    public void executedBeforeEach() {
        flightsController = new FlightsController(
                new FlightsService(
                        new FlightDao(),
                        TEST_DB
                )
        );
        FlightCreator flightCreator = new FlightCreator(flightsController, FLIGHTS_AMOUNT);
        flightCreator.createFlightBase();

        bookingController = new BookingController(
                new BookingService(
                        new BookingDao(),
                        TEST_DB
                )
        );
    }

    @Test
    void new_booking_should_be_added_to_dao_when_being_added() {
        //given
        Booking booking = new Booking(
                1,
                12
        );
        //when
        bookingController.addBooking(booking);
        //then
        assertEquals(1, bookingController.count());
    }

}