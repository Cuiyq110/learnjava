package class_.day17.demo03;

/**
 * 乘客
 */
public class Passenger {
    private String name;

    public Passenger(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void buy(TrainTicket t) {
//        BuyTickerThread buy = new BuyTickerThread();
        BuyTickerThread buy = new BuyTickerThread(this,t);
        Thread thread = new Thread(buy);
        thread.start();
    }

    public void tui() {

    }
}
