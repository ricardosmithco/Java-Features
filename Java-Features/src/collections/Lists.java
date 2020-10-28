package collections;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.List;


public class Lists {
	
	public static void main(String[] args) {
//		ArrayList<String> names = new ArrayList<>();
//		names.add("Smith");
//		names.add("Williams");
//		names.add("Pereira");
//		names.add("Johnson");
//		
//		printArrayList(names);
		
		LinkedList<String> names = new LinkedList<>();
		names.add("Smith");
		names.add("Williams");
		names.add("Pereira");
		names.add("Johnson");
		
		linkedListForLoop(names);
		System.out.println();
		linkedListRemoveFirstAndLast(names);
		System.out.println();
		linkedListAddFirstAndLast(names);
	}
	
	public static <E> void printArrayList(List<E> list) {
		ListIterator<E> iterator = list.listIterator();
		while(iterator.hasNext()) System.out.println(iterator.next());
		System.out.println();
		while(iterator.hasPrevious()) System.out.println(iterator.previous());
	}

	public static <E> void linkedListForLoop(List<E> list){
		for(int i = 0; i < list.size(); i++) System.out.println(list.get(i));
	}
	
	public static <E> void linkedListRemoveFirstAndLast(List<E> list) {
		LinkedList<E> list1 = (LinkedList<E>) list;
		list1.removeFirst();
		list1.removeLast();
		linkedListForLoop(list1);
	}
	
	public static <E> void linkedListAddFirstAndLast(List <E> list) {
		@SuppressWarnings("unchecked")
		LinkedList<String> list1 = (LinkedList<String>) list;
		list1.addFirst("Borat");
		list1.addLast("Spy");
		linkedListForLoop(list1);
	}
}

class ArrayLists{
	
}
