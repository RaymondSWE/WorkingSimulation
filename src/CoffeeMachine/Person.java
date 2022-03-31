package CoffeeMachine;

public class Person implements Runnable{
	private final String name;
	CoffeeMachine machine;
	private int energyLevel;
	private long energyDecay;
	private long endTimer = System.currentTimeMillis() + 20 * 1000 ;
	private RandomUtility random=new RandomUtility();
	// The state of the worker to check if he/she is tired, working or on a break
	enum State {
		WORK, TIRED, BREAK,
	}

	public Person(String name, CoffeeMachine machine, int min, int max) {
		this.name = name;
		this.machine = machine;
//		this.energyLevel = random.getRandomNumber(max - min) + min;
this.energyLevel=random.getRandomNumber(min, max);
		//this.energyDecay = (int) (random.getRandomNumber(max - min) + min) / 1f);
		this.energyDecay=(long) random.getRandomNumber(500, 1500);

	}
	
	public void drinkCoffee(Coffee coffee) {
		this.energyLevel += coffee.getDrinkEnergy() ;
		System.out.println(this.name + " just enjoyed " + coffee.getType() + " increased energy with: "
				+ coffee.getDrinkEnergy() + " the energy is now: " + this.getEnergy());

	}
	public int getEnergy() {
		return this.energyLevel;
	}
	
	public String getName() {
		return name;
	}
	
	public double getEnergyDecay() {
		return this.energyDecay;
	}

	@Override
	public void run() {
		// Sets the workers enum to work.
			State personState = State.WORK;
			// If the energyLevel is 0 the worker stops working and also stop working if the
			// timer is 0
			while (this.energyLevel > 0 && System.currentTimeMillis() < endTimer) {

				// Checks if the worker has drank enough coffee to start working again, energy
				// over 100, sets the energy to 100. Just because the worker cannot have more
				// energy than 100
				if (this.energyLevel >= 100) {
					personState = State.WORK;
					this.energyLevel = 100;
				}

				// If worker working and the energy is decreased to 30. if 30 take a break and
				// start to queue up by the machine. If the worker drinks coffee and still has
				// less than 100, queue up again and start drinking.
				if (this.energyLevel < 30 || personState.equals(State.BREAK)) {
					System.out.println(this.name + " is on break with energy: " + this.energyLevel);
					personState = State.BREAK;
					this.machine.coffeeQueue(this);

				}
				//The worker has now over 100 energy and starts working again
				if (personState.equals(State.WORK)) {
					System.out.println(this.name + " is working with energy: " + this.energyLevel);
				}
				//decrease the energyLevel by 1
				this.energyLevel--;
				try {
					//Sleep for how long the energyDecay is
					Thread.sleep(this.energyDecay);
				} catch (InterruptedException e) {
					System.out.print("Cannot put into sleep");
				}
			}
			System.out.println(this.name + " has 0 energy and now goes home");
	}
	
}
