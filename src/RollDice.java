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

    public static boolean probabilityDice(int dice){
        /*
        600回中100回出れば確率は正しい
        けど、そうなるとは限らない。
        600回中95回数とかのとき、だいたいあってるとかどうやって判定するん？
        誤差を許す関数を作ればいい？
        誤差の範囲内ならtrueを返すものを…
        */
        Random rand = new Random();
        int numThrow = 60000; //この回数が大きくなるほど処理が遅くなる
        double tole = 10; //許される誤差(%)
        double tolerance = numThrow * tole /100;
        int count = 0;
        for(int i = 0; i < numThrow; i++){
            int n  = rollDice();
            if(dice == n) {
                count++;
            }
        }
        double probability = numThrow / 6;
        if(probability - tolerance <= count && count <= probability + tolerance)
            return true;
        return false;
    }
}
