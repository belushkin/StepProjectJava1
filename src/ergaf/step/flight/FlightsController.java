package ergaf.step.flight;

import java.util.ArrayList;
import java.util.List;

public class FlightsController {
    private FlightsService service;

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

//    public ArrayList<Flight> searchFlights() {
//        return service.searchFlights();
//    }

    public Flight getFlightById(int id) {
        return service.getFlightById(id);
    }

    public int count() {
        return service.count();
    }

    public void addFlight(Flight... flight) {
        service.addFlight(flight);
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
