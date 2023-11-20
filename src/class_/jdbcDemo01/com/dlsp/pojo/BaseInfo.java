package class_.jdbcDemo01.com.dlsp.pojo;
import java.sql.Date;

public class BaseInfo {
	//qq号
	private long qqid;
	//昵称
	private String nickName;
	//性别
	private int sex;
	//年龄
	private int age;
	//省份
	private String province;
	//城市
	private String city;
	//地址
	private String address;
	//联系方式
	private String phone;
	public BaseInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BaseInfo(long qqid, String nickName, int sex, int age, String province, String city, String address,
			String phone) {
		super();
		this.qqid = qqid;
		this.nickName = nickName;
		this.sex = sex;
		this.age = age;
		this.province = province;
		this.city = city;
		this.address = address;
		this.phone = phone;
	}
	public long getQqid() {
		return qqid;
	}
	public void setQqid(long qqid) {
		this.qqid = qqid;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "BaseInfo [qqid=" + qqid + ", nickName=" + nickName + ", sex=" + sex + ", age=" + age + ", province="
				+ province + ", city=" + city + ", address=" + address + ", phone=" + phone + "]";
	}
	
	
	

}
