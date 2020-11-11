package lambdaExpressions;

import java.util.List;
import java.util.ArrayList;

public class Tester {
	public static void main(String[] args) {
		/*StringFormatter f1 = (s1,s2) -> s1 + s2;
		StringFormatter f2 = (String s1, String s2) -> s1 + " - " + s2;
		StringFormatter f3 = (s1,s2) -> (s1 + s2).toUpperCase();
		
		String s1 = "Lambda";
		String s2 = " Expression";
		
		System.out.println(f1.format(s1, s2));
		System.out.println(f2.format(s1, s2));
		System.out.println(f3.format(s1, s2));*/
		
		Employee e1 = new Employee(1, "Frank", "Trinidad and Tobago");
		Employee e2 = new Employee(2, "Hoss", "Barbados");
		Employee e3 = new Employee(3, "General", "Jamaica");
		List<Employee> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		System.out.println("before sort: " + empList);
		empList.sort((e,e6) -> Employee.compareByCountry(e, e6)); // can also be writeen as:
		empList.sort(Employee::compareByCountry);
		System.out.println("after sort by Country: " + empList);
		empList.sort(Employee::compareById);
		System.out.println("after sort by id: " + empList);
		empList.sort(Employee::compareByName);
		System.out.println("after sort by name: " + empList);
	}

}

@FunctionalInterface
interface StringFormatter{
	String format(String s1, String s2);
}

class Employee {
    private Integer empId;
    private String empName;
    private String country;
    
    Employee(){}
    Employee(Integer empId, String empName, String country){
    	this.empId = empId;
    	this.empName = empName;
    	this.country = country;
    }
    
    
    public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", country=" + country + "]";
	}
	public static int compareByCountry(Employee e1, Employee e2) {
    	return e1.getCountry().compareTo(e2.getCountry());
    }
	
	public static int compareById(Employee e1, Employee e2) {
		return e1.getEmpId().compareTo(e2.getEmpId());
	}
	
	public static int compareByName(Employee e1, Employee e2) {
		return e1.getEmpName().compareToIgnoreCase(e2.getEmpName());
	}
}
