package ergaf.step.flight;

public class Flight {
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
        System.out.println("    from: " + from);
        System.out.println("    to: " + to);
        System.out.println("    at: " + at);
        System.out.println("    id: " + id);
        System.out.println("    freePlaces: " + freePlaces);
        System.out.println();
    }


}
