//检查项
public class HealthCheckItem {
	//名称
	private String name;
	//描述
	private String description;
	//单价
	private double price;
	public HealthCheckItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HealthCheckItem(String name, String description, double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "检查项： [name=" + name + ", description=" + description + ", price=" + price + "]";
	}

	
}
