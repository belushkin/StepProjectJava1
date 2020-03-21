package ergaf.step.flight;

import java.time.LocalDate;
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

    public void displayFlights(List<Flight> flights) {
        service.displayFlights(flights);
    }

    public List<Flight> searchFlights(String to, LocalDate at, int ticketsAmount) {
        return service.searchFlights(to, at, ticketsAmount);
    }

    public Flight getFlightById(int id) {
        return service.getFlightById(id);
    }

    public int count() {
        return service.count();
    }

    public void clearFlights() {
        service.clearFlights();
    }

    public boolean unlinkData() {
        return service.unlinkData();
    }

    public void addFlight(Flight flight) {
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
