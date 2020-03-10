package ergaf.step.flight;

import ergaf.step.LogOrError;
import ergaf.step.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionFlightDao implements FlightBaseInterface {
    private List<Flight> flights = new ArrayList<>();
    private File file = new File("Data");
    Logger logger = new Logger();

    {
        System.out.println("создался екземпляр "+this.getClass().getSimpleName());
    }


    @Override
    public List<Flight> giveAllFlights() {
        return this.flights;
    }

    @Override
    public void saveFlightToCollection(Flight flight) {
        flights.add(flight);
    }

    @Override
    public void clearFlightList() {
        flights.clear();
    }

    @Override
    public void saveDataToFile() {
        try {
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);

            if (file.exists()) {
                file.delete();
                file.createNewFile();
            }

            for (Flight flight : flights) {
                o.writeObject(flight);
            }

            o.close();
            f.close();

        } catch (IOException e ) {
            e.printStackTrace();
            logger.log(LogOrError.ERROR, "ошибка записи в файл базы данных");
        }
    }

    @Override
    public void loadDataInFile() {
        try {
            FileInputStream f = new FileInputStream(file);
            ObjectInputStream o = new ObjectInputStream(f);

            while(f.available() > 0) {
                flights.add((Flight) o.readObject());
            }

            o.close();
            f.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            logger.log(LogOrError.ERROR, "ошибка чтения из файла базы данных");
        }
    }
}
