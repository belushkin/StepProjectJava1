package ergaf.step;

import ergaf.step.Menu;
import ergaf.step.booking.BookingController;
import ergaf.step.booking.BookingService;
import ergaf.step.booking.Input;
import ergaf.step.flight.*;

import java.util.Scanner;

public class ConsoleMain {

    Scanner in = new Scanner(System.in);
    Input subInput;
    FlightsController fcontroller;
    BookingController bookingController;
    FlightCreator flightCreator;


    {
        System.out.println("создался екземпляр "+this.getClass().getSimpleName());
    }


    public ConsoleMain(
            FlightsController flightsController,
            BookingController bookingController,
            FlightCreator flightCreator,
            Input subInput
    ) {
        this.fcontroller = flightsController;
        this.bookingController = bookingController;
        this.subInput = subInput;
        this.flightCreator = flightCreator;
    }

    public void startConsole()
    {
        boolean running = true;

        fcontroller.loadData();
        if(fcontroller.getAllFlights().size() <= 0){
            flightCreator.createFlightBase();
        }

        while (running) {
            System.out.println(Menu.MENU);
            System.out.println("введите номер действия:");

            String userIn = in.nextLine().toLowerCase();
            switch (userIn) {
                case "1":
                    fcontroller.displayAllFlights();
                    ifMenu();
                    break;
                case "2":
                    System.out.print("Введите айди рейса: ");
                    int id = subInput.getIntInput();
                    fcontroller.getFlightById(id).prettyFormat();
                    ifMenu();
                    break;
                case "3":
                    System.out.println("место назначения:");
                    String destination = subInput.getStringInput();
                    System.out.println("дата (год):");
                    int bookingYear = subInput.getIntInputYear();
                    System.out.println("дата (месяц):");
                    int bookingMonth = subInput.getIntInputMonth();
                    System.out.println("дата (день):");
                    int bookingDay = subInput.getIntInputDay(bookingYear, bookingMonth);
                    System.out.println("количество человек (сколько необходимо купить билетов):");
                    int ticketsAmount = subInput.getIntInput();
                    ifMenu();
                    break;
                case "4":
                    System.out.print("4: ");
                    ifMenu();
                    break;
                case "5":
                    System.out.print("5: ");
                    ifMenu();
                    break;
                case "6":
                    fcontroller.saveData(fcontroller.getAllFlights());
                    running = false;
                    break;

            }

        }
    }

    void ifMenu(){
        System.out.print("нажмите ввод что бы вернуться в главное меню: ");
        in.nextLine();
    }
}
