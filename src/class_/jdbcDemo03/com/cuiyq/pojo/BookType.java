package class_.jdbcDemo03.com.cuiyq.pojo;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
@SuppressWarnings("all")
public class BookType {
    private int typeId;
    private String typeName;

    public BookType() {
    }

    public BookType(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
