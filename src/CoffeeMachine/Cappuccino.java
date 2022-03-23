package CoffeeMachine;

public class Cappuccino extends Coffee {
	
	private static final String TYPE = "Cappuccino";
	private static final int HIGH_ENERGY = 30;
	private static final int LOW_ENERGY = 20;

	public Cappuccino() {
		super(TYPE, HIGH_ENERGY, LOW_ENERGY);
	}
}
