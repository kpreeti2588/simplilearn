
public class EmployeeTest {
	
	public static void main(String[] args) {
		System.out.println(Employee.counter);
		
		EmployeeTest et = new EmployeeTest();
		et.main();
		
		Employee emp1 = new Employee(100, "Rajesh", "Reliance");
		
	//	emp1.insertemp(100, "Rajesh", "Reliance");
		emp1.displayemp();
		
		Employee emp2 = new Employee(101, "Raj", "Simpli");
		
	//	emp2.insertemp(101, "Raj", "Simpli");
		
		emp2.displayemp();
		
		Employee.changeCompany("ITC");
		
		emp1.displayemp();
		emp2.displayemp();
		
		Employee.changeCompany("Capgemini");
		
		emp1.displayemp();
		emp2.displayemp();
		
	//	System.out.println(Employee.company);
		
	}
	
	public void main() {
		System.out.println("-------------main method------------------");
	}

}
