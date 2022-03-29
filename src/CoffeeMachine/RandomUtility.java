package CoffeeMachine;
import java.util.Random;

public class RandomUtility
 {
private Random random=new Random();
public RandomUtility()
{

}
//this function takes an integer that is a max number and generates a random number between 0 and the number given.
public int getRandomNumber(int min, int max)
{
    // nextInt is normally exclusive of the top value, so we add 1 to make it inclusive
    return random.nextInt(min, max+1);
}
}
