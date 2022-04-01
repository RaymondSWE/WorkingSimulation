package CoffeeMachine;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CoffeeMachine implements Runnable {
	ConcurrentLinkedQueue<Person> personQueue = new ConcurrentLinkedQueue<Person>();
	ConcurrentLinkedQueue<Coffee> coffeeList = new ConcurrentLinkedQueue<Coffee>();
	// The higher the coffeeSleeper is, the longer it takes to brew drinks
	private int coffeeSleeper = (int) (2000 / 1f);
	// The higher the giveDrinkSleeper is the longer it takes to give out drinks to
	// the workers
	private int giveDrinkSleeper = (int) (1000 / 1);
	long endTimer = System.currentTimeMillis() + 20 * 1000;
	private RandomUtility random = new RandomUtility();

	public void run() {
		// Start the Coffemachine process
		startProducing();
		while (System.currentTimeMillis() < endTimer) {
			// Checks if the queue is empty and if coffee list is empty. If they are null it
			// will not do anything
			if (!personQueue.isEmpty() && !coffeeList.isEmpty()) {
				System.out.println("Check queue - " + personQueue.element().getName());
				giveCoffee(personQueue.poll(), coffeeList.poll());
			}

			try {
				Thread.sleep(giveDrinkSleeper);
			} catch (InterruptedException e) {
				System.out.println("Cannot sleep coffeMachine");
			}
		}
		System.out.println("Coffee machine is turned off for the day");
	}

	// Method to start thread for producing drinks
	public void startProducing() {
		ProduceCoffee produceCoffee = new ProduceCoffee();
		produceCoffee.start();
	}

	CoffeeMachine() {
	}

	// Takes in worker and first checks if worker exist in queue. If not the worker
	// is placed in queue
	public void coffeeQueue(Person person) {
		if (!personQueue.contains(person)) {
			personQueue.add(person);
		}
	}

	// Give drink to the requesting worker
	public void giveCoffee(Person person, Coffee coffee) {
		person.drinkCoffee(coffee);
	}

	// Adds drink to the coffee list
	public void addDrink() {
		String coffeeType;
		int min;
		int max;
		// Random value between 0-2
		int randomCoffee = random.getRandomNumber(0, 2);

		// Sets the value depending on what randomCoffee gives
		if (randomCoffee == 0) {
			coffeeType = "BlackCoffee";
			min = 15;
			max = 20;
		} else if (randomCoffee == 1) {
			coffeeType = "Cappucino";
			min = 20;
			max = 30;
		} else {
			coffeeType = "Latte";
			min = 25;
			max = 35;
		}
		coffeeList.add(new Coffee(coffeeType, max, min));
	}

	public class ProduceCoffee extends Thread {
		public void run() {
			while (System.currentTimeMillis() < endTimer) {
				// If the size of the coffee list is greater than 20 it will not store anymore
				// drinks. Else add drink to the coffee list
				if (coffeeList.size() < 20) {
					addDrink();
					System.out
							.println("Drink created. Coffee Machine has " + coffeeList.size() + " drinks in reserve.");
				} else {
					System.out.println("Max amount of coffee in reserve");
				}
				try {
					Thread.sleep(coffeeSleeper);
				} catch (InterruptedException e) {
					System.out.println("Cannot sleep coffeMachine");
				}
			}
		}
	}

}
