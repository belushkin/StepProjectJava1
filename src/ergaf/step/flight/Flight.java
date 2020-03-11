package ergaf.step.flight;

import java.io.Serializable;

public class Flight implements Serializable {
    String from;
    String to;
    String at;
    String id;
    int freePlaces;

    {
        System.out.println("создался екземпляр "+this.getClass().getSimpleName());
    }

    public Flight(String from, String to, String at, String id, int freePlaces){
        this.from = from;
        this.to = to;
        this.at = at;
        this.id = id;
        this.freePlaces = freePlaces;
    }

    public void prettyFormat() {
        System.out.println("рейс:");
        System.out.print("    from: " + from);
        System.out.print("    to: " + to);
        System.out.print("    at: " + at);
        System.out.print("    id: " + id);
        System.out.print("    freePlaces: " + freePlaces);
        System.out.println();
    }


}
