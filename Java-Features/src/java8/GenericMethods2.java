package java8;

public class GenericMethods2 {
	public static void main(String[] args) {
		Grades<DayStudent> g1 = new Grades<DayStudent>();
		NightStudent ns = new NightStudent();
		ns.<DayStudent>update(g1);
	}

}

class Student1{}

class DayStudent extends Student{}

class NightStudent extends Student{
	public <E> void update(Grades<E> student) {}
}

class Grades<E> {
	E item;
	
	public Grades(){}
	public Grades(E item) {
		this.item = item;
	}
	
	public String genClass() {
		return item.getClass().getName();
	}
}
