package ergaf.step.flight;

import ergaf.step.exceptions.FlightCreationException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;

public class FlightCreator {

    private static final String START_DATE = "01/01/2020 00:00";
    private static final String END_DATE = "03/01/2020 00:00";
    private String from;
    private int i = 0;
    Random random = new Random();

    private int flightAmount;

    FlightsController flightsController;
    DateGenerator dateGenerator;

    public FlightCreator(FlightsController flightsController, int flightAmount) {
        this.flightsController = flightsController;
        this.flightAmount = flightAmount;
    }

    public void createFlightBase(){
        i=0;
        try {
            dateGenerator = new DateGenerator(
                    START_DATE,
                    END_DATE
            );
        } catch (ParseException e) {
            throw new FlightCreationException("Unable to create flight because of incorrect date time");
        }

        ArrayList<String> toList = new ArrayList<>();
        int fiftyPercent = (int) (flightAmount*0.5);

        while (i < fiftyPercent) {
            String to = getNextDestination();
            addFlight(i+1, "Kyiv", to);
            toList.add(to);
            i++;
        }
        toList.forEach(s -> {
            i++;
            addFlight(i, s, getNextDestination());
        });
    }

    private void addFlight(int i, String from, String to) {
        flightsController.addFlight(
                new Flight(
                        from,
                        to,
                        dateGenerator.getRandomFlightLocalDateTime(),
                        random.nextInt(100)
                )
        );
    }

    private String getNextDestination() {
        return Destination.values()[
                random.nextInt(Destination.values().length)
                ].name();
    }
}
