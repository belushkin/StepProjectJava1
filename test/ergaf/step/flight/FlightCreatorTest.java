package ergaf.step.flight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightCreatorTest {

    @Test
    public void generate_flight_base_from_and_to() {
        FlightsController flightsController = new FlightsController(
                new FlightsService(
                        new FlightDao()
                )
        );
        FlightCreator flightCreator = new FlightCreator(flightsController, 20);
        flightCreator.createFlightBase();
        System.out.println(flightsController.getAllFlights());
    }
}