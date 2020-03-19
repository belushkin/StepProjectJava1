package ergaf.step.flight;

import ergaf.step.LogOrError;
import ergaf.step.Logger;

import java.util.ArrayList;

public class FlightDao implements FlightBaseInterface {

    private ArrayList<Flight> flights = new ArrayList<>();
    Logger logger = new Logger();

    @Override
    public ArrayList<Flight> getAllFlights() {
        logger.log(LogOrError.LOG, "был получен список полетов");
        return flights;
    }

    @Override
    public void addFlight(Flight flight) {
        logger.log(LogOrError.LOG, "addFlightToCollection");

        int index = flights.indexOf(flight);
        if (index == -1) {
            flights.add(flight);
        } else {
            flights.set(index, flight);
        }
    }

    @Override
    public void clearFlights() {
        logger.log(LogOrError.LOG, "clearFlightList");
        flights.clear();
    }

    @Override
    public void loadData(ArrayList<Flight> flights) {
        logger.log(LogOrError.LOG, "loadData");
        this.flights = flights;
    }
}
