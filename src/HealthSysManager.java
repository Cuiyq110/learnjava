import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HealthSysManager {
	Scanner sc = new Scanner(System.in);
	//声明一些检查项
	HealthCheckItem blood,X_ray,liver,eye,weight,height,ear,heart,B超;
	
	//存放所有检查项的集合
	List<HealthCheckItem> allItems = new ArrayList<HealthCheckItem>();
	List<HealthCheckItem> allItemsBak = new ArrayList<HealthCheckItem>();
	/*存放所有套餐的集合
	 *    key 套餐的名称  
	 *    value 当前套餐对象
	 */
	Map<String, HealthCheckSet> sets = new HashMap<String, HealthCheckSet>();
	
	public HealthSysManager(){
		this.initItem();
		this.initSet();
	}
	//初始化检查项的方法
	public void initItem() {
		this.blood = new HealthCheckItem("血常规", "检查血液有没有病毒", 49);
		this.X_ray = new HealthCheckItem("X射线", "检查肚子里有没有坏水", 249);
		this.liver = new HealthCheckItem("乙肝五项", "检查乙肝五项病毒", 189);
		this.eye = new HealthCheckItem("视力", "检查视力", 9);
		this.weight = new HealthCheckItem("体重", "检查体重", 9);
		this.height = new HealthCheckItem("身高", "检查身高", 9);
		this.ear = new HealthCheckItem("听力", "检查聋不聋", 19);
		this.heart = new HealthCheckItem("心电图", "看心脏跳动情况", 99);
		this.B超 = new HealthCheckItem("B超", "做个B超", 149);
		
		allItems.add(blood);
		allItems.add(X_ray);
		allItems.add(liver);
		allItems.add(eye);
		allItems.add(weight);
		allItems.add(height);
		allItems.add(ear);
		allItems.add(heart);
		allItems.add(B超);
	}
	//初始化一个套餐
	public void initSet() {
		
		HealthCheckSet set = new HealthCheckSet();
		//构建套餐名称
		set.setName("入学体检");
		//构建检查项的集合
		List<HealthCheckItem> items = new ArrayList<HealthCheckItem>();
		items.add(eye);
		items.add(ear);
		items.add(height);
		items.add(weight);
		items.add(liver);
		set.setItems(items);
		
		this.sets.put(set.getName(), set);
	}
	
	//显示检查项的集合
	public void showItems(List<HealthCheckItem> items) {
		for (int i = 0; i < items.size(); i++) {
			System.out.println((i+1)+"、"+items.get(i));
		}
	}
	
	
	//显示所有套餐信息
	public void showAllSet() {
		//遍历套餐集合values
		for (HealthCheckSet	 set : sets.values()) {
			this.showSet(set);
		}
	}
	//根据套餐名称 查询套餐信息
	public  void  showSetByName() {
		System.out.println("请输入套餐的名称:");
		String setName = sc.next();
		//套餐的名称 就是 map集合的key值
		if(sets.containsKey(setName)) {
			//map 集合 根据key 获取value     Object value = maps.get(key);
			HealthCheckSet set = sets.get(setName);
			this.showSet(set);
			
		}else {
			System.out.println("没有此套餐信息");
		}
	}
	/**新增一个套餐
	 *  实际上就是创建 HealthCheckSet的对象
	 *  就是 1)给套餐起名
	 *    2)给套餐增加 检查项目的列表
	 */   
	public void addSet() {
		HealthCheckSet set = new HealthCheckSet();
		System.out.println("请输入套餐的名称：");
		String setName = sc.next();
		while(sets.containsKey(setName)) {
			System.out.print("此套餐已存在 ，请重新录入：");
			setName = sc.next();
		}
		//套餐名称赋值
		set.setName(setName);
		//构建套餐中包含的检查项的集合
		List<HealthCheckItem> items = new ArrayList<HealthCheckItem> ();
		allItemsBak.clear();
		allItemsBak.addAll(allItems);
		
		int num = -1;
		do {
			System.out.println("以下为可以添加的检查项 输入-1结束");
			this.showItems(allItemsBak);
			num = sc.nextInt();
			if( num == -1) {
				break;
			}
			items.add(allItemsBak.get(num-1));
			System.out.println(allItemsBak.get(num-1) + "添加成功！！！");
			allItemsBak.remove(num-1);
			
		}while(num != -1);
		//设置套餐的检查项集合
		set.setItems(items);
		
		//把套餐对象添加到 套餐集合中
		this.sets.put(set.getName(), set);
		System.out.println("【"+set.getName() +"】  套餐添加成功，具体信息如下");
		this.showSet(set);
	}
	
	//显示套餐的基本信息
	public void showSet(HealthCheckSet set) {
		System.out.println("套餐名称：" + set.getName());
		System.out.println("检查项明细");
		for (HealthCheckItem item : set.getItems()) {
			System.out.println(item);
		}
		System.out.println("套餐的总金额：" + set.getPrice());
	}
	
	//移除一个套餐
	public void delSet() {
		System.out.println("请输入要删除的套餐名称:");
		String setName = sc.next();
		if(sets.containsKey(setName)) {
			this.showSet(sets.get(setName));
			System.out.println("确认要删除吗？y/n");
			if(sc.next().equalsIgnoreCase("y")) {
				this.sets.remove(setName);
				System.out.println("删除套餐成功");
			}
		}else {
			System.out.println("没有此套餐信息");
		}
	}
	//编辑套餐
	public void editSet() {
		this.allItemsBak.clear();
		this.allItemsBak.addAll(allItems);
		System.out.println("请输入要编辑的套餐名称：");
		String setName = sc.next();
		//根据套餐名称 获取到当前套餐
		HealthCheckSet set = this.sets.get(setName);
		this.showSet(set);
		System.out.println("请选择 1、增加检查项 2、删除检查项");
		int num = sc.nextInt();
		if(num == 1) {
			//加项
			do {
				System.out.println("请输入要添加的项目编号-1结束");
				//当前套餐中没有的检查项集合（总的集合中 移除已经存在的）
				allItemsBak.removeAll(set.getItems());
				this.showItems(allItemsBak);
				num = sc.nextInt();
				if(num == -1) {
					break;
				}
				set.getItems().add(allItemsBak.get(num-1));
				System.out.println("【" + allItemsBak.get(num-1) + " 】 添加成功！");
				allItemsBak.remove(num-1);
			
			}while(num != -1);
		}else {
			do {
				System.out.println("请输入要移除的项目编号-1结束");
				this.showItems(set.getItems());
				num = sc.nextInt();
				if(num == -1) {
					break;
				}
				System.out.println(set.getItems().get(num-1) + "被移除");
				set.getItems().remove(num-1);
			
			}while(num != -1);
		}
		
		System.out.println("编辑后的套餐信息入下：" );
		this.showSet(set);
		
	}
	
	//菜单
	public void menu() {
		boolean flag = true;
		do {
			System.out.println("1、显示所有套餐的信息");
			System.out.println("2、按照名称查看某一套餐");
			System.out.println("3、添加新套餐");
			System.out.println("4、删除套餐");
			System.out.println("5、修改套餐信息");
			System.out.println("请选择");
			int num = sc.nextInt();
			
			switch (num) {
			case 1:
				this.showAllSet();
				break;
			case 2:
				this.showSetByName();
				break;
			case 3:
				this.addSet();
				break;
			case 4:
				this.delSet();
				break;
			case 5:
				this.editSet();
				break;
			default:
				break;
			}
			
		}while(flag);
		
		
	}
	
	
	
	public static void main(String[] args) {
		new HealthSysManager().menu();
	}
	
	

}
