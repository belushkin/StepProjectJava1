package ergaf.step.console;

import ergaf.step.flight.Flight;
import ergaf.step.flight.FlightsController;

import java.util.Scanner;

public class ConsoleMain {
    Scanner in = new Scanner(System.in);
    FlightsController controller = new FlightsController();

    {
        System.out.println("создался екземпляр "+this.getClass().getSimpleName());
    }



    public void startConsole(){
        if(controller.giveAllFlights().size() <= 0){
            controller.saveFlightToCollection(new Flight("kiev", "vladivostok", "15:20", "1", 20));
            controller.saveFlightToCollection(new Flight("kiev", "kharkov", "00:00", "2", 11));
            controller.saveFlightToCollection(new Flight("kiev", "odessa", "07:30", "3", 1));
        }
        while (true){
            printMainMenu();
            String userIn = in.nextLine();
            switch (userIn) {
                case "1":
                    controller.displayAllFlights();
                    in.nextLine();
                    break;
                case "2":
                    System.out.print("Введите айди рейса: ");
                    controller.giveFlightForId(in.nextLine()).prettyFormat();
                    in.nextLine();
                    break;

            }

        }
    }

    void printMainMenu(){
        System.out.println("1 - Онайн-табло.");
        System.out.println("2 - Посмотреть информацию о рейсе.");
        System.out.println("3 - Поиск и бронировка рейса.");
        System.out.println("4 - Отменить бронирование.");
        System.out.println("5 - Мои рейсы.");
        System.out.println("6 - Выход.");
        System.out.println("10 - Создать тестовые полеты.");
        System.out.print("введите номер действия: ");
    }
}
