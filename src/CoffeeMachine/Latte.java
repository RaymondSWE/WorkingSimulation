package CoffeeMachine;

public class Latte extends Coffee {
	private static final String TYPE = "Latte";
	private static final int HIGH_ENERGY = 35;
	private static final int LOW_ENERGY = 25;

	public Latte() {
		super(TYPE, HIGH_ENERGY, LOW_ENERGY);
	}
}
