package ergaf.step.console;

import ergaf.step.flight.DateGenerator;
import ergaf.step.flight.Flight;
import ergaf.step.flight.FlightsController;
import ergaf.step.input.Input;
import ergaf.step.menu.Menu;
import ergaf.step.menu.SubMenu;
import ergaf.step.user.User;
import ergaf.step.user.UserController;

import java.time.LocalDate;
import java.util.List;

public class ConsoleSearchAndBooking implements ConsoleInterface{

    private Input input;
    private FlightsController flightsController;
    private UserController userController;

    public ConsoleSearchAndBooking(
            Input input,
            FlightsController flightsController,
            UserController userController
    ) {
        this.input = input;
        this.flightsController = flightsController;
        this.userController = userController;
    }

    public String startConsole()
    {
        String userIn = input.getRawStringInput();
        switch (userIn) {
            case "0":
                System.out.println(Menu.MENU);
                break;
            case "1":
                System.out.println("Поиск и бронировка рейса. -> место назначения:");
                String destination = input.getStringInput();
                System.out.println("Поиск и бронировка рейса. -> дата (год):");
                int flightYear = input.getIntInputYear();
                System.out.println("Поиск и бронировка рейса. -> дата (месяц):");
                int flightMonth = input.getIntInputMonth();
                System.out.println("Поиск и бронировка рейса. -> дата (день):");
                int flightDay = input.getIntInputDay(flightYear, flightMonth);
                System.out.println("Поиск и бронировка рейса. -> количество человек (сколько необходимо купить билетов):");
                int ticketsAmount = input.getIntInput();

                LocalDate desiredFlightDate = DateGenerator.getFlightDate(
                        flightYear,
                        flightMonth,
                        flightDay
                );
                List<Flight> flights = flightsController.searchFlights(
                        destination,
                        desiredFlightDate,
                        ticketsAmount
                );
                if (flights.size() == 0) {
                    System.out.println("No flights found according to your data");
                    break;
                }

                flightsController.displayFlights(flights);
                System.out.println("Укажите id рейса:");
                int flightId = input.getIntInputFlight(flightsController.count());
                Flight flight = flightsController.getFlightById(flightId);
                if (flight == null || flight.getFreePlaces() < ticketsAmount) {
                    System.out.println("Flight has not been found or there is not enough seats");
                    break;
                }

                System.out.println("Укажите имя и фамилию для "+ticketsAmount+ " пасажиров:");
                String firstName;
                String lastName;
                for (int i = 0; i < ticketsAmount; i++) {
                    System.out.println("Укажите имя для пасажира #" + (i+1));
                    firstName = input.getRawStringInput();
                    System.out.println("Укажите фамилию для пасажира #" + (i+1));
                    lastName  = input.getRawStringInput();
                    userController.addUser(new User(firstName, lastName));
                }

//                userIn = input.getRawStringInput();
                break;
            default:
                System.out.print("Поиск и бронировка рейса. ");
                System.out.println(SubMenu.SUB_MENU);
                break;
        }
        return userIn;
    }

}
