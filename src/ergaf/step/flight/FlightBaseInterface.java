package ergaf.step.flight;

import java.util.ArrayList;

public interface FlightBaseInterface {
    ArrayList<Flight> getAllFlights();
    void saveFlight(Flight flight);
    void clearFlights();
    void loadData(ArrayList<Flight> flights);
}
