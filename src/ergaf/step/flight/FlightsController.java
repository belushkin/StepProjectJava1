package ergaf.step.flight;

import java.util.ArrayList;
import java.util.List;

public class FlightsController {
    FlightsService service;

    public FlightsController(FlightsService service) {
        this.service = service;
    }

    public ArrayList<Flight> getAllFlights()
    {
        return service.getAllFlights();
    }

    public void displayAllFlights() {
        service.displayAllFlights();
    }

    public Flight getFlightById(int id) {
        return service.getFlightById(id);
    }

    public void saveFlight(Flight flight) {
        service.saveFlight(flight);
    }

    public void saveData(ArrayList<Flight> flights){
        service.saveData(flights);
    }

    public void loadData(){
        service.loadData(
                service.prepareData()
        );
    }
}
