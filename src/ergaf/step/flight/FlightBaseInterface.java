package ergaf.step.flight;

import java.util.ArrayList;

public interface FlightBaseInterface {
    public ArrayList<Flight> getAllFlights();
    public void addFlight(Flight flight);
    public void clearFlights();
    public void loadData(ArrayList<Flight> flights);
}
