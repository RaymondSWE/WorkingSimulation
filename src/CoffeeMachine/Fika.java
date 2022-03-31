package CoffeeMachine;
import java.util.Random;

public class Fika {
	public static void main (String[] args) {
		/**
		 * Initiating Coffee Machine
		 */
		CoffeeMachine drink = new CoffeeMachine();
		/**
		 * Initiating different threads (multithreading)
		 */
		Thread machine = new Thread(drink);
		machine.start();
		Person[] persons = new Person[4];
		System.out.println("Welcome to work :)");
		/**
		 * Randomize names, taken from randomName method.
		 */
		RandomUtility random=new RandomUtility();
		for (int i = 0; i < 4; i++) {
			persons[i] = new Person(randomName(random), drink, 30, 90);
			Thread personThreads = new Thread(persons[i]);
			personThreads.start();
		}
		
	} 
	public static String randomName(RandomUtility random) {
		String[] firstTwo = { "Te", "Le", "Ma", "Si", "Pa", "Ro", "Ed", "Fu", "Ca", "Ka", "Ri", "Ev", "Pe", "Ze", "Co"};
		String[] lastTwo = { "ta", "xi", "ri", "ny", "er", "bu", "an", "ck", "rl", "ll", "on", "rt", "ra", "sa", "ta"};

		String selectFirstTwo = firstTwo[random.getRandomNumber(0, firstTwo.length)];
		String selectLastTwo = lastTwo[random.getRandomNumber(0, lastTwo.length-1)];
		return selectFirstTwo + selectLastTwo;
	}

}
