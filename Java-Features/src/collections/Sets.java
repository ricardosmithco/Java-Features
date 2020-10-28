package collections;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.Map;
import java.util.Set;

public class Sets {
	public static void main (String[] args) {
//		HashSet<FakeStudent> hset = new HashSet<>();
//		hset.add(new FakeStudent("Ricardo",1,90));
//		hset.add(new FakeStudent("Rico",2,98));
//		hset.add(new FakeStudent("Enoch",3,23));
//		hset.add(new FakeStudent("Brass",4,55));
//		System.out.println(hset);
		FakeStudent fs = new FakeStudent();
		
		Map<Integer,String> tmap = new TreeMap<Integer,String>();
		tmap.put(1, fs.calculateGrade(90));
		tmap.put(2, fs.calculateGrade(98));
		tmap.put(3, fs.calculateGrade(23));
		tmap.put(4, fs.calculateGrade(55));
		
		for(Map.Entry<Integer,String> set: tmap.entrySet()) {
			System.out.println("Grade for Student: " + set.getKey() + " is: " + set.getValue());
		}
	}
	
}

class FakeStudent{
	private String name;
	private int rollNumber;
	private int totalMarks;
	
	 FakeStudent() {}
	 FakeStudent(String name, int rn, int totalMarks) {
		this.name = name;
		this.rollNumber = rn;
		this.totalMarks = totalMarks;
	}
	
	public void setName(String name) {this.name = name;}
	public void setRollNumber(int rollNumber) {this.rollNumber = rollNumber;}
	public String getName() {return name;}
	public int getRollNumber() {return rollNumber;}
	public void setTotalMarks(int totalMarks) {
		if(totalMarks >100) totalMarks = 100;
		if(totalMarks <0) totalMarks = 0;
		this.totalMarks = totalMarks;
	}
	public int getTotalMarks() {return totalMarks;}
	
	public String calculateGrade(int totalMarks) {
		if(totalMarks >= 60) return "A";
		if((totalMarks > 40) && (totalMarks < 60)) return "B";
		else return "C";
	}
	
	@Override
	public String toString() {
		return "name: " + name + " & roll number: " + rollNumber + " & total marks: " + totalMarks;
	}
	
}
