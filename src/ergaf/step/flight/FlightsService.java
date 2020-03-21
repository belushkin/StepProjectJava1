package ergaf.step.flight;

import ergaf.step.io.FileWorker;
import ergaf.step.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlightsService {

    private FlightDao flightDao;

    private String filename = "flights.data";

    public FlightsService(FlightDao flightDao) {

        this.flightDao = flightDao;
    }

    public FlightsService(FlightDao flightDao, String filename) {

        this.flightDao = flightDao;
        this.filename = filename;
    }

    public ArrayList<Flight> getAllFlights() {
        return flightDao.getAllFlights();
    }

    public List<Flight> searchFlights(String to, LocalDate at, int ticketsAmount) {
        return getAllFlights().stream().filter(flight -> flight.getTo().equals(to) &&
                flight.getAt().toLocalDate().equals(at) &&
                flight.getFreePlaces() >= ticketsAmount).collect(Collectors.toList());
    }

    public void displayAllFlights() {
        displayFlights(flightDao.getAllFlights());
    }

    public void displayFlights(List<Flight> flights) {
        List<String> collect = flights.stream().map(flight -> flight.getId() + ")\t" + flight.prettyFormat())
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }

    public Flight getFlightById(int id) {
        return flightDao.
                getAllFlights().
                stream().
                filter(flight -> flight.getId() == id).
                findFirst().
                orElse(null);
    }

    public Flight addFlight(Flight flight) {
        return flightDao.addFlight(flight.setId(getNextId()));
    }

    public int getNextId() {
        int id = flightDao.getAllFlights().
                stream().
                mapToInt(Flight::getId).
                reduce((first,second) -> second).orElse(0);

        return id + 1;
    }

    public int count() {
        return flightDao.getAllFlights().size();
    }

    public void saveData(ArrayList<Flight> flights){
        FileWorker.serialize(filename, flights);
    }

    public ArrayList<Flight> prepareData() {
        return FileWorker.deserialize(filename);
    }

    public void loadData(ArrayList<Flight> flights){
        flightDao.loadData(flights);
    }

    public void clearFlights() {
        flightDao.clearFlights();
    }

    public boolean unlinkData() {
        return FileWorker.unlinkData(filename);
    }

}
