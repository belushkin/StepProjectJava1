package ergaf.step.flight;

import java.util.Random;

public class FlightCreator {

    public FlightCreator() {
        Random random = new Random();
        String from = Destination.values()[
                random.nextInt(Destination.values().length)
                ].name();

        String to = Destination.values()[
                random.nextInt(Destination.values().length)
                ].name();

//        new Flight()
    }

    public static void createFlightBase(FlightsController fcontroller){

//        fcontroller.saveFlight(new Flight("Киев", "Владивосток", "31/12/1998 15:20", "1", 20));
//        fcontroller.saveFlight(new Flight("Киев", "Харьков", "31/12/1998 00:00", "2", 11));
//        fcontroller.saveFlight(new Flight("Киев", "Одесса", "31/12/1998 07:30", "3", 1));
//        fcontroller.saveFlight(new Flight("Киев", "Львов", "31/12/1998 08:30", "4", 4));
//        fcontroller.saveFlight(new Flight("Киев", "Москва", "31/12/1998 09:30", "5", 8));
//        fcontroller.saveFlight(new Flight("Киев", "Краков", "31/12/1998 10:30", "6", 10));
//        fcontroller.saveFlight(new Flight("Киев", "Бостон", "31/12/1998 11:30", "7", 1));
//        fcontroller.saveFlight(new Flight("Киев", "Питер", "31/12/1998 12:30", "8", 1));
//        fcontroller.saveFlight(new Flight("Киев", "Нью-йорк", "31/12/1998 16:30", "9", 1));
//        fcontroller.saveFlight(new Flight("Киев", "Врослав", "31/12/1998 19:30", "10", 1));
//        fcontroller.saveFlight(new Flight("Киев", "Прага", "02:30", "11", 17));
//        fcontroller.saveFlight(new Flight("Киев", "Варшава", "08:00", "12", 28));
//        fcontroller.saveFlight(new Flight("Киев", "Вильнюс", "17:30", "13", 1));
//        fcontroller.saveFlight(new Flight("Киев", "Гамбург", "11:30", "14", 4));
//        fcontroller.saveFlight(new Flight("Киев", "Берлин", "00:30", "15", 2));
//        fcontroller.saveFlight(new Flight("Киев", "Минск", "03:30", "16", 21));
//        fcontroller.saveFlight(new Flight("Киев", "Будапешт", "15:30", "17", 2));
    }
}
