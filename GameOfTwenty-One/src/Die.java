import java.util.Random;
public final class Die 
{

    private final int NUMBER_OF_SIDES = 6;
    private int value;

  //Constructor will call the roll method to set the value of the die
    Die() 
    {
        roll();
    }

  //The roll method sets the value of the die to a random number
    public void roll() 
    {
        Random randomValue = new Random();
        value = randomValue.nextInt(NUMBER_OF_SIDES) + 1;
    }

  //Return value
    public int getValue()
    {
        return value;
    }
}