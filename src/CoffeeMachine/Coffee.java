package CoffeeMachine;
import java.util.Random;

public class Coffee {
	private final int highEnergy;
	private final int lowEnergy;
	private final int drinkEnergy;
	private final String type;
	
	public Coffee(String type, int highEnergy, int lowEnergy) {
		this.type = type;
		this.highEnergy = highEnergy;
		this.lowEnergy = lowEnergy;
		Random rand = new Random();
		this.drinkEnergy = rand.nextInt(highEnergy-lowEnergy) + lowEnergy;
	}

	public String getType(){
		return type;
	}
	
	public String toString() {
		return  getType();
	}

	public int getHighEnergy() {
		return highEnergy;
	}

	public int getLowEnergy() {
		return lowEnergy;
	}

	public int getDrinkEnergy() {
		return drinkEnergy;
	}
}