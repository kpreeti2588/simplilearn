package springapp;



public class EmployeeDetails {

	public EmployeeDetails() {
		// TODO Auto-generated constructor stub
	}
    

	private Address address;
	
	private int id;
	private String name;
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public EmployeeDetails(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	
	
	
	public EmployeeDetails(Address address, int id, String name, String phone) {
		super();
		this.address = address;
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [address=" + address + ", id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	
	
}
