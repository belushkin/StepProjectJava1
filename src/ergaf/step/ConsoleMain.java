package ergaf.step;

import ergaf.step.booking.BookingController;
import ergaf.step.input.Input;
import ergaf.step.flight.*;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleMain {

    Scanner in = new Scanner(System.in);
    Input subInput;
    FlightsController fcontroller;
    BookingController bookingController;


    public ConsoleMain(
            FlightsController flightsController,
            BookingController bookingController,
            Input subInput
    ) {
        this.fcontroller = flightsController;
        this.bookingController = bookingController;
        this.subInput = subInput;
    }

    public String startConsole()
    {
        String userIn = in.nextLine().toLowerCase();

        switch (userIn) {
            case "1":
                fcontroller.displayAllFlights();
                break;
            case "2":
                System.out.print("Введите айди рейса: ");
                int id = subInput.getIntInput();
                System.out.println(fcontroller.getFlightById(id).prettyFormat());
                break;
            case "3":
                System.out.print("Поиск и бронировка рейса. ");
                System.out.println(SubMenu.SUB_MENU);
                int subMenuInput = subInput.getIntSubInput();
                switch (subMenuInput) {
                    case 0:
                        System.out.println("вернуться в главное меню");
                        break;
                    case 1:
                        System.out.println("место назначения:");
                        String destination = subInput.getStringInput();
                        System.out.println("дата (год):");
                        int flightYear = subInput.getIntInputYear();
                        System.out.println("дата (месяц):");
                        int flightMonth = subInput.getIntInputMonth();
                        System.out.println("дата (день):");
                        int flightDay = subInput.getIntInputDay(flightYear, flightMonth);
                        System.out.println("количество человек (сколько необходимо купить билетов):");
                        int ticketsAmount = subInput.getIntInput();

                        LocalDate desiredFlightDate = DateGenerator.getFlightDate(
                                flightYear,
                                flightMonth,
                                flightDay
                        );
                        fcontroller.displayFlights(
                                fcontroller.
                                        searchFlights(
                                                destination,
                                                desiredFlightDate,
                                                ticketsAmount
                                        )
                        );
                        break;
                    default:
                        break;
                }
                break;
            case "4":
                System.out.print("4: ");
                break;
            case "5":
                System.out.print("5: ");
                break;
            case "6":
                fcontroller.saveData(fcontroller.getAllFlights());
                break;
            default:
                System.out.println(Menu.MENU);
                break;

        }
        return userIn;
    }

}
