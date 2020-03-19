package ergaf.step.flight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.Assert.*;

class FlightsControllerTest {

    FlightsController flightsController;
    DateGenerator dateGenerator;

    private final static int FLIGHTS_AMOUNT = 1;
    private final static String TEST_DB = "flights.test.data";

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
    public void get_all_flights_should_return_correct_amount_of_flights() {
        //given
        //when
        //then
        assertEquals(FLIGHTS_AMOUNT, flightsController.getAllFlights().size());
    }

    @Test
    public void get_flight_by_id_should_return_correct_flight_when_called() {
        //given
        Flight flight = flightsController.getFlightById(1);
        //when
        //then
        assertEquals(1, flight.getId());
    }

    @Test
    public void get_flight_by_id_should_return_null_when_flight_does_not_exists() {
        //given
        Flight flight = flightsController.getFlightById(0);
        //when
        //then
        assertNull(flight);
    }

    @Test
    public void save_flight_should_append_flight_to_the_dao() {
        //given
        Flight flight = new Flight(
                1,
                "Kyiv",
                "Boyarka",
                dateGenerator.getRandomFlightLocalDateTime(),
                55
        );
        //when
        flightsController.addFlight(flight);
        //then
        assertEquals(FLIGHTS_AMOUNT+1, flightsController.count());
    }


    @Test
    public void save_flight_should_replace_flight_in_the_dao_when_equal_flight_added() {
        //given
        Flight flight = flightsController.getFlightById(1);
        //when
        flightsController.addFlight(flight);
        //then
        assertEquals(FLIGHTS_AMOUNT, flightsController.count());
    }

    @Test
    public void save_data_generates_db_when_called() {
        //given
        ArrayList<Flight> flights = flightsController.getAllFlights();
        //when
        flightsController.saveData(flights);
        //then
        flightsController.loadData();
        assertEquals(flights, flightsController.getAllFlights());
    }

}
