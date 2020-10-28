package collections;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Collections;
import java.util.Comparator;

public class School{ // implements Comparable<School>{
	
	public static void main(String[] args) {
		// Using Comparable
//		ArrayList<School> list = new ArrayList<>();
//		list.add(new School(5, "St. Mary's"));
//		list.add(new School(7, "Trinity College East"));
//		list.add(new School(1, "Trinity College West"));
//		list.add(new School(11, "Arima Comprehensive"));
//		System.out.println(list);
//		Collections.sort(list);
//		System.out.println(list);
		
		// Using Comparable
//		TreeSet<School> tset = new TreeSet<>();
//		tset.add(new School(5, "St. Mary's"));
//		tset.add(new School(7, "Trinity College East"));
//		tset.add(new School(1, "Trinity College West"));
//		tset.add(new School(11, "Arima Comprehensive"));
//		
//		System.out.println(tset);
		
		// Using Comparator
//		ArrayList<School> list = new ArrayList<>();
//		list.add(new School(5, "St. Mary's"));
//		list.add(new School(7, "Trinity College East"));
//		list.add(new School(1, "Trinity College West"));
//		list.add(new School(11, "Arima Comprehensive"));
//		System.out.println(list);
//		Collections.sort(list, new CompareSchoolID());
//		System.out.println(list);
		
		// Using Comparator
		TreeSet<School> tset = new TreeSet<>(new ComparatorSchoolID()); // pass Comparator instance into constructor
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
	}
}

/*
 * this is an example of Comparable and Comparator and how they work.
 * if I have a collection that is of a String or primitive type, 
 * then I don't need to use Comparator or Comparable, however if I need to compare objects,
 * then I will have to use either comparable  or comparator.
 * Comparable has one method called compare To which compares two strings lexicographically and determines 
 * which comes before. In my school class, it compares the school names automatically. To implement
 * COMPARABLE : I only need my class to implement Comparable<School>, override compareTo() method and
 * can use Collections.sort(list) / and TreeSet/TreeMap will automatically sort. However to implement
 * COMPARATOR: I need to create another class that implements Comparator <School>, then override the
 * compare method (in line 73, I want to compare the school objects based on their schoolID.
 * then I can call Collections.sort(list, ComparatorSchoolID) -> the list and the Comparators instance.
 * or if I want to use a TreeSet/TreeMap, then I will have to pass the Comparator's instance into the 
 * constructor of the TreeMap/TreeSet.
 */
