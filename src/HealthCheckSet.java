import java.util.ArrayList;
import java.util.List;

//检查套餐
public class HealthCheckSet {
	//套餐名称
	private String name;
	//检查项的集合
		private List<HealthCheckItem> items = new ArrayList<HealthCheckItem>();
	//金额
	private double price;

	public HealthCheckSet() {
		super();
	}

	public HealthCheckSet(String name, List<HealthCheckItem> items) {
		super();
		this.name = name;
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<HealthCheckItem> getItems() {
		return items;
	}

	public void setItems(List<HealthCheckItem> items) {
		this.items = items;
	}

	//套餐的金额 每个检查项的单价累加和
	public double getPrice() {
		for (int i = 0; i < this.items.size(); i++) {
			this.price += this.items.get(i).getPrice();
		}
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
}
