package ergaf.step.flight;

import ergaf.step.exceptions.FlightCreationException;

import java.text.ParseException;
import java.util.Random;

public class FlightCreator {

    private static final int FLIGHTS_AMOUNT = 20;
    private static final String START_DATE = "31/12/1998 10:00";
    private static final String END_DATE = "31/12/2020 10:00";

    FlightsController flightsController;
    DateGenerator dateGenerator;

    public FlightCreator(FlightsController flightsController) {
        this.flightsController = flightsController;
    }

    public void createFlightBase(){

        Random random = new Random();

        try {
            dateGenerator = new DateGenerator(
                    START_DATE,
                    END_DATE
            );
        } catch (ParseException e) {
            throw new FlightCreationException("Unable to create flight because of incorrect date time");
        }

        for (int i = 0; i < FLIGHTS_AMOUNT; i++) {
            String from = Destination.values()[
                    random.nextInt(Destination.values().length)
                    ].name();

            String to = Destination.values()[
                    random.nextInt(Destination.values().length)
                    ].name();

            flightsController.saveFlight(
                    new Flight(
                            i+1,
                            from,
                            to,
                            dateGenerator.getRandomFlightLocalDateTime(),
                            random.nextInt(100)
                    )
            );
        }
    }
}
