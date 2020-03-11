package ergaf.step.flight;

import java.util.List;

public interface FlightBaseInterface {
    List<Flight> giveAllFlights();
    void saveFlightToCollection(Flight flight);
    void clearFlightList();
    void saveDataToFile();
    void loadDataInFile();
}
