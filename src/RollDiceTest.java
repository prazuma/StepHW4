import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by hashimotomika on 6/22/15.
 */
public class RollDiceTest {
    
    @Test
    public void testProbabilityDice() throws Exception {
        assertTrue(probabilityDice(1));
        assertTrue(probabilityDice(2));
        assertTrue(probabilityDice(3));
        assertTrue(probabilityDice(4));
        assertTrue(probabilityDice(5));
        assertTrue(probabilityDice(6));
    }

    public static boolean probabilityDice(int dice){
        /*
        numThrow回中1/6回出れば確率は正しい。だが、必ずしもぴったり出るとは限らない。
        なので、ここでは、誤差の範囲は前後10%まで許し、だいたい1/6回出たらTrueを返すメソッドを作成した。
        テストでは、1~6がちゃんと1/6で出るかを確かめている。
        ここでは、人力で設定したが、許容範囲は何か明確な制度？方法？があるならば、
        それを使用するのが望ましいと思われる。
        また、サイコロを投げる回数が多くなればなるほど処理の時間がかかる。
        このプログラムはサイコロを計算するだけなのでさほど気にならないが、
        時間のかかるプログラムの場合は、時間がかかってしまう可能性がある。
        */
        Random rand = new Random();
        int numThrow = 60000; //投げる回数
        double tole = 1; //許される誤差(%)
        double tolerance = numThrow * tole / 100;
        int count = 0;
        for(int i = 0; i < numThrow; i++){
            int n  = RollDice.rollDice();
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