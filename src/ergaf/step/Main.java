package ergaf.step;

import ergaf.step.booking.BookingController;
import ergaf.step.booking.BookingService;
import ergaf.step.booking.Input;
import ergaf.step.flight.FlightDao;
import ergaf.step.flight.FlightCreator;
import ergaf.step.flight.FlightsController;
import ergaf.step.flight.FlightsService;

public class Main {

    private static final int FLIGHTS_AMOUNT = 20;

    public static void main(String[] args) {

        FlightDao flightDao = new FlightDao();

        FlightsController flightsController = new FlightsController(
                new FlightsService(flightDao)
        );

        BookingController bookingController = new BookingController(
                new BookingService(flightDao)
        );

        ConsoleMain console = new ConsoleMain(
                flightsController,
                bookingController,
                new FlightCreator(flightsController, FLIGHTS_AMOUNT),
                new Input()
        );
        console.startConsole();
    }
}
