package ergaf.step.flight;

import ergaf.step.io.FileWorker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
