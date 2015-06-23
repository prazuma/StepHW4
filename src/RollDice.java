import java.util.Random;

/**
 * Created by hashimotomika on 6/22/15.
 */
public class RollDice {
    public static int rollDice(){
        Random rand = new Random();
        int dice = rand.nextInt(6) + 1;
        return dice;
    }
}
