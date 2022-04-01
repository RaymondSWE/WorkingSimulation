package CoffeeMachine;

public class BlackCoffee extends Coffee {
	private static final String TYPE = "BlackCoffee";
	private static final int HIGH_ENERGY = 40;
	private static final int LOW_ENERGY = 20;

	public BlackCoffee() {
		super(TYPE, HIGH_ENERGY, LOW_ENERGY);
	}
}
