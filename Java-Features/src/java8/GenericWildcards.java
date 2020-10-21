package java8;

import java.util.ArrayList;
import java.util.List;

public class GenericWildcards {
	public static void main(String[] args) {
		Directory<Human> dirHuman = new Directory<Human>();
		Directory<Man> dirMen = new Directory<Man>();
		Directory<MaleSoccerPlayer> dirMSP = new Directory<MaleSoccerPlayer>();
		
		MaleSoccerPlayer msp1 = new MaleSoccerPlayer(true);
		Man man = new Man(31, true);
		Human human = new Human(21);
		dirHuman.add(human);
		
		System.out.println(dirHuman.displayMenAndHuman(dirHuman));
		dirMen.displayMenAndHuman(dirMen);
		dirMSP.add(msp1);
		dirMSP.displayMenAndSoccerPlayers(dirMSP);
		
		NumberRestriction<Integer> nr1= new NumberRestriction<>(12);
		//NumberRestriction<String> nr1= new NumberRestriction<>(); this is not valid because String does not extend Number
		
		
	}
	

}

class Directory<E>{
	List<E> list = new ArrayList<>();
	
	public void add(E e) {list.add(e);}
	
	public String toString() {
		return "list is: " + list;
	}
	
	public String displayMenAndSoccerPlayers(Directory<? extends Human> list) {
		return "Displaying Men or Soccer Players: " + list;
	}
	
	public String displayMenAndHuman(Directory<? super Man> list) {
		return "Displaying Men and Humans: " + list;
	}
	
}

class NumberRestriction<E extends Number>{
	E item;
	
	NumberRestriction(E item){this.item = item;}
	
	public E returnType(){
		System.out.println(item.getClass().getName());
		return item;
	}
}

class Man extends Human{
	int age;
	boolean hasBeard;
	
	public Man() {}
	public Man(int age) {super(age);}
	public Man(int age, boolean isBearded) {
		super(age);
		this.hasBeard = isBearded;
	}
	
	public String toString() {
		return " This man's age is: " + age +" does he have a beard?: "+hasBeard;
	}
}

class MaleSoccerPlayer extends Man{
	boolean playsSoccer;
	
	public MaleSoccerPlayer() {}
	public MaleSoccerPlayer(boolean playsSoccer) {this.playsSoccer = playsSoccer;}
	
	public <E> void boyDirectoryofFriends(List<E> friendList) {
		for(E friend: friendList) System.out.print(friend + ", ");
	}
	
	public String toString() {return "Do I play Soccer?: " + playsSoccer;}
}

class Human{
	int age;
	
	public Human() {}
	public Human (int age) {this.age = age;}
	
	public String toString() {return "I am a Human";}
}
