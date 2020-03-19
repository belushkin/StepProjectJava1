package ergaf.step.flight;

import ergaf.step.io.FileWorker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlightsService {

    private FlightDao flightDao;

    private String filename = "step.data";

    public FlightsService(FlightDao flightDao) {

        this.flightDao = flightDao;
    }

    public FlightsService(FlightDao flightDao, String filename) {

        this.flightDao = flightDao;
        if (filename != null) {
            this.filename = filename;
        }
    }

    public ArrayList<Flight> getAllFlights() {
        return flightDao.getAllFlights();
    }

    public List<Flight> searchFlights(String to, LocalDate at, int ticketsAmount) {
        return getAllFlights().stream().filter(new Predicate<Flight>() {
            @Override
            public boolean test(Flight flight) {
                if (
                        flight.getTo().equals(to) &&
                                flight.getAt().toLocalDate().equals(at) &&
                                flight.getFreePlaces() >= ticketsAmount) {
                    return true;
                }
                return false;
            }
        }).collect(Collectors.toList());
    }

    public void displayAllFlights() {
        displayFlights(flightDao.getAllFlights());
    }

    public void displayFlights(List<Flight> flights) {
        List<String> collect = IntStream.range(0, flights.size())
                .mapToObj(index -> index+1 + ")\t" + flights.get(index).prettyFormat())
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

    public void addFlight(Flight... flights) {
        Arrays.stream(flights).forEach(flight -> flightDao.addFlight(flight));
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
}
