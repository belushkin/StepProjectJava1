package ergaf.step.console;

import ergaf.step.menu.Menu;
import ergaf.step.menu.SubMenu;
import ergaf.step.booking.BookingController;
import ergaf.step.input.Input;
import ergaf.step.flight.*;

public class ConsoleMain implements ConsoleInterface{

    Input subInput;
    FlightsController fcontroller;
    BookingController bookingController;
    FlightCreator flightCreator;


    public ConsoleMain(
            FlightsController flightsController,
            BookingController bookingController,
            Input subInput,
            FlightCreator flightCreator
    ) {
        this.fcontroller = flightsController;
        this.bookingController = bookingController;
        this.subInput = subInput;
        this.flightCreator = flightCreator;
    }

    public String startConsole()
    {
        String userIn = subInput.getRawStringInput();

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

                ConsoleSearchAndBooking consoleSearchAndBooking =
                        new ConsoleSearchAndBooking(subInput, fcontroller);
                String command = consoleSearchAndBooking.startConsole();

                while (!command.equals("0")) { // 0 -> exit
                    System.out.println("\nPlease enter number from sub menu: ");
                    command = consoleSearchAndBooking.startConsole();
                }

                break;
            case "4":
                System.out.print("4: ");
                break;
            case "5":
                System.out.print("5: ");
                break;
            case "6":
                if (fcontroller.unlinkData()) {
                    System.out.println("Данние перегенерировани успешно.");
                    fcontroller.clearFlights();
                    flightCreator.createFlightBase();
                } else {
                    System.out.println("Не удалось перегенерировать данние.");
                }
                break;
            case "7":
                fcontroller.saveData(fcontroller.getAllFlights());
                break;
            default:
                System.out.println(Menu.MENU);
                break;

        }
        return userIn;
    }

}
