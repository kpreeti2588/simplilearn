
public class Employee {
	
	private int empid;
	private String empname;
	private static String company;
	static int counter;
	
	static {
		counter=0;
		company = "infosys";
		System.out.println(company);
	}
	
	public static String changeCompany(String comp) {
		company = comp;
		return company;
	}
	
	public Employee() {}
	
	public Employee(int empid, String empname) {
		this.empid = empid;
		this.empname = empname;
	}
	
	public Employee (int empid,String empname,String company) {
		    this(empid,empname);
	        System.out.println("parameterized constructor");
			this.company =company; 
			counter=counter+1;

		}
		
	
	public void insertemp(int id,String name,String comp) {
	   empid = id;
	   empname = name;
	   company = comp;   
	   System.out.println("displayed values");
	}
	
	public void displayemp() {
		System.out.println("counter  "+ counter +"  empid    "+ empid  + "  empname "+ empname  + "  company  "+ company);
	}
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public static String getCompany() {
		return company;
	}
	public static void setCompany(String company) {
		Employee.company = company;
	}
	

}
