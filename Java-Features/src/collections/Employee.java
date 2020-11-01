package collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Employee extends EmployeeComparator {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(12, "R&D"));
		list.add(new Employee(7, "Accounting"));
		list.add(new Employee(27, "Marketing"));
		Collections.sort(list, new EmployeeComparator());
		System.out.println(list);
		
	}
	
	private int id;
	private String dept;
	Employee(){}
	Employee(int id, String dept){
		this.id = id;
		this.dept = dept;
	}
	
	public void setId(int id) { this.id = id;}
	public int getId() {return id;}
	public void setDept(String dept) { this.dept = dept;}
	public String getDept() {return dept;}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", dept=" + dept + "]";
	}
//	@Override
//	public int compareTo(Employee otherEmployee) {
//		return this.id - otherEmployee.getId();
//	}
}

class EmployeeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getDept().compareTo(e2.getDept());
	}}
