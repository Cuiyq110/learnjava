package class_.jdbcDemo02.com.tentact.pojo;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */

public class Subject {

    private int subjectNo;
    private String subjextName;
    private int classHour;
    private double point;

    public Subject(int subjectNo, String subjextName, int classHour, double point) {
        super();
        this.subjectNo = subjectNo;
        this.subjextName = subjextName;
        this.classHour = classHour;
        this.point = point;
    }

    public Subject() {
        super();
    }

    public int getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(int subjectNo) {
        this.subjectNo = subjectNo;
    }

    public String getSubjextName() {
        return subjextName;
    }

    public void setSubjextName(String subjextName) {
        this.subjextName = subjextName;
    }

    public int getClassHour() {
        return classHour;
    }

    public void setClassHour(int classHour) {
        this.classHour = classHour;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Subject [subjectNo=" + subjectNo + ", subjextName=" + subjextName + ", classHour=" + classHour
                + ", point=" + point + "]";
    }

}