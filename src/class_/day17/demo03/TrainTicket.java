package class_.day17.demo03;

/**
 * 票
 */
public class TrainTicket {
    private String trainNo; //车次
    private String seatNo; //座位号
    private String date; //时间

    public TrainTicket() {
    }

    public TrainTicket(String trainNo, String seatNo, String date) {
        this.trainNo = trainNo;
        this.seatNo = seatNo;
        this.date = date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result= prime * result + ((date == null) ? 0: date.hashCode());
        result= prime * result + ((seatNo == null) ? 0: seatNo.hashCode());
        result= prime * result + ((trainNo == null) ? 0: trainNo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        else {
            return false;
        }
    }
}
