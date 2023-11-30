package class_.jdbcDemo03.com.cuiyq.pojo;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
public class Book {
    private String bookNo; //图书编号
    private String bookName; //图书名字
    private int TypeId; //图书类别
    private double price;//单价
    private String author;//作者
    private String publishing;//出版社
    private int storage;//库存

    public Book() {
    }

    public Book(String bookNo, String bookName, int typeId, double price, String author, String publishing, int storage) {
        this.bookNo = bookNo;
        this.bookName = bookName;
        TypeId = typeId;
        this.price = price;
        this.author = author;
        this.publishing = publishing;
        this.storage = storage;
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getTypeId() {
        return TypeId;
    }

    public void setTypeId(int typeId) {
        TypeId = typeId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookNo='" + bookNo + '\'' +
                ", bookName='" + bookName + '\'' +
                ", TypeId=" + TypeId +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", publishing='" + publishing + '\'' +
                ", storage=" + storage +
                '}';
    }
}
