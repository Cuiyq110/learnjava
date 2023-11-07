package class_.day17.demo03;

import java.util.ArrayList;
import java.util.List;

/**
 * 售票员
 */
public class TicketSeller {

    private static List<TrainTicket> pool = new ArrayList<TrainTicket>();

    //初始化票池
    static {
        TrainTicket t1 = new TrainTicket("G8965", "7车6座","20231120");
        TrainTicket t2 = new TrainTicket("G8965", "7车5座","20231120");
        TrainTicket t3 = new TrainTicket("G8965", "7车4座","20231120");
        TrainTicket t4 = new TrainTicket("G8965", "7车3座","20231120");
        TrainTicket t5 = new TrainTicket("G8965", "6车6座","20231120");
        TrainTicket t6 = new TrainTicket("G8965", "6车5座","20231120");
        TrainTicket t7 = new TrainTicket("G8965", "6车4座","20231120");
        TrainTicket t8 = new TrainTicket("G8965", "6车3座","20231120");

        pool.add(t1);
        pool.add(t2);
        pool.add(t3);
        pool.add(t4);
        pool.add(t5);
        pool.add(t6);
        pool.add(t7);
        pool.add(t8);
    }

    /**
     * 买票方法
     * @param t 传一张票
     * @return
     */
    public static TrainTicket SellTicket(TrainTicket t) {
        TrainTicket ticket = null;
        if (pool.contains(t)) {
            ticket = t;
            System.out.println("正在出票" + ticket);
            //在票池中 移除 刚刚购买的车票
            pool.remove(t);
        } else {
            System.out.println("票已卖出");
        }
        return ticket;
    }



}
