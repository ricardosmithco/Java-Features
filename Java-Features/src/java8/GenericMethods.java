package java8;

public class GenericMethods {
	
	public static <E> void display(E[] list) {
		for(E item: list) System.out.print(item + ", ");
	}
	
	public static void main(String[] args) {
		String[] countries = new String[] {"USA", "Mexico", "Germany"};
		Integer[] ages = {30, 22, 57, 12};
		
		GenericMethods.<String>display(countries);
		System.out.println();
		GenericMethods.<Integer>display(ages);
	}

}
