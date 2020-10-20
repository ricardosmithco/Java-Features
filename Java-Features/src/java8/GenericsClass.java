package java8;

public class GenericsClass {
	
	public static void main(String[] args) {
		Student s1 = new Student(123, "Ricardo Smith");
		Book b1 = new Book(21, "A House for Mr Biswas");
		Record<Student> r1 = new Record<Student>();
		Record<Book> r2 = new Record<Book>();
		Record <Integer> i1 = new Record<Integer>(1);
		Record <String> i2 = new Record<String>("Hello World");
		Record <Boolean> i3 = new Record<Boolean>(true);
		
		
		System.out.println(r1.display(s1));
		System.out.println(r2.display(b1));
		System.out.println(i1.genClass());
		System.out.println(i2.genClass());
		System.out.println(i3.genClass());
		
	}

}

class Student{
	int studentID;
	String studentName;
	public Student(){}
	public Student(int studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
	}
	
	public String toString() {return "Student # :" +studentID + ", Student Name: "+ studentName;}
}

class Book{
	int bookID;
	String bookName;
	public Book(){}
	public Book(int bookID, String bookName) {
		this.bookID = bookID;
		this.bookName = bookName;
	}
	
	public String toString() {return "Book #: " + bookID + ", Book Name: "+ bookName;}
}

class Record<E>{
	public E object;
	
	public E display(E item) {
		return item;
	}
	
	public Record() {}
	public Record(E object) {
		this.object = object;
	}
	
	public String genClass(){
		return "Object type is " + object.getClass().getName();
	}
}
