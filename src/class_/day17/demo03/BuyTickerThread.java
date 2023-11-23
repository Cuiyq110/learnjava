package class_.day17.demo03;

public class BuyTickerThread implements Runnable{

    //乘客
    private final Passenger passenger;

    //车票
    private final TrainTicket t;

    public BuyTickerThread(Passenger passenger, TrainTicket t) {
        this.passenger = passenger;
        this.t = t;
    }

    @Override
    public void run() {
        System.out.println(passenger.getName() + "正在买票" + t);
        synchronized (t) {
            TrainTicket ticket = TicketSeller.SellTicket(t);
            if (ticket == null)
            {
                System.out.println(passenger.getName() + "购票失败");
            } else {
                System.out.println(passenger.getName() + "购票成功");
            }
        }
    }
}
