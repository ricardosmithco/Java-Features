package collections;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Collections;
import java.util.Comparator;

public class School{ // implements Comparable<School>{
	
	public static void main(String[] args) {
//		ArrayList<School> list = new ArrayList<>();
//		list.add(new School(5, "St. Mary's"));
//		list.add(new School(7, "Trinity College East"));
//		list.add(new School(1, "Trinity College West"));
//		list.add(new School(11, "Arima Comprehensive"));
//		System.out.println(list);
//		Collections.sort(list, new CompareSchoolID());
//		System.out.println(list);
		
		TreeSet<School> tset = new TreeSet<>(new ComparatorSchoolID());
		tset.add(new School(5, "St. Mary's"));
		tset.add(new School(7, "Trinity College East"));
		tset.add(new School(1, "Trinity College West"));
		tset.add(new School(11, "Arima Comprehensive"));
		
		System.out.println(tset);

	}
	
	public int schoolID;
	public String name;
	
	public School() {}
	public School(int id, String name) {
		schoolID = id;
		this.name = name;
	}
	public int getSchoolID() {
		return schoolID;
	}
	public void setSchoolID(int schoolID) {
		this.schoolID = schoolID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "School [schoolID=" + schoolID + ", name=" + name + "]";
	}
//	@Override
//	public int compareTo(School otherSchool) {
//		return this.name.compareTo(otherSchool.name);
//	}
	
}

class ComparatorSchoolID implements Comparator<School>{

	@Override
	public int compare(School a, School b) {
		return a.schoolID - b.schoolID;
	}}
