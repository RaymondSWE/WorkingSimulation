package CoffeeMachine;
import java.util.Random;

public class Fika {
	
	// nextInt is normally exclusive of the top value,
	// so add 1 to make it inclusive
	 static int max = 90;
	 static int min = 30;
	 
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
		for (int i = 0; i < 4; i++) {
			persons[i] = new Person(randomName(), drink, min, max);
			Thread personThreads = new Thread(persons[i]);
			personThreads.start();
		}
		
	} 
	public static String randomName() {
		String[] firstTwo = { "Te", "Le", "Ma", "Si", "Pa", "Ro", "Ed", "Fu", "Ca", "Ka", "Ri", "Ev", "Pe", "Ze", "Co"};
		String[] lastTwo = { "ta", "xi", "ri", "ny", "er", "bu", "an", "ck", "rl", "ll", "on", "rt", "ra", "sa", "ta"};

		Random rand = new Random();
		
		String selectFirstTwo = firstTwo[rand.nextInt(firstTwo.length)];
		String selectLastTwo = lastTwo[rand.nextInt(lastTwo.length)];
		return selectFirstTwo + selectLastTwo;
	}
	
	public static int random(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min) + min;
	}

}
