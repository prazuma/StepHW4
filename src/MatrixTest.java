import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hashimotomika on 6/20/15.
 */
public class MatrixTest {
    
    @Test
    public void testCalculateSum(){
        double[][] c3 = {{5, 14, 23}, {14, 50, 86}, {23, 86, 149}};
        double[][] c4 = {{14, 38, 62, 86}, {38, 126, 214, 302}, {62, 214, 366, 518}, {86, 302, 518, 734}};
        double[][] c5 = {{30, 80, 130, 180, 230}, {80, 255, 430, 605, 780}, {130, 430, 730, 1030, 1330}, {180, 605, 1030, 1455, 1880}, {230, 780, 1330, 1880, 2430}};
        double[][] cNull = null;
        assertEquals(Matrix.calculateSum(c3), 450.0, 0);
        assertEquals(Matrix.calculateSum(c4), 3680.0, 0);
        assertEquals(Matrix.calculateSum(c5), 18250.0, 0);
        assertEquals(Matrix.calculateSum(cNull), -1, 0);
    }

    @Test
    public void testMulMatrix(){
        double[][] a3 = Matrix.initializeMatrixA(3);
        double[][] b3 = Matrix.initializeMatrixB(3);
        double[][] a4 = Matrix.initializeMatrixA(4);
        double[][] b4 = Matrix.initializeMatrixB(4);
        double[][] c3 = {{5, 14, 23}, {14, 50, 86}, {23, 86, 149}};
        double[][] c3result = Matrix.mulMatrix(a3, b3);
        for(int i = 0; i < c3.length; i++){
            for(int j = 0; j < c3.length; j++) {
                assertEquals(c3result[i][j], c3[i][j], 0);
            }
        }
    }

    @Test
    public void testInitializeMatrixA(){
        double[][] a3 = Matrix.initializeMatrixA(3);
        double[][] a3Actual = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        for(int i = 0; i < a3.length; i++){
            for(int j = 0; j < a3.length; j++) {
                assertEquals(a3[i][j], a3Actual[i][j], 0);
            }
        }
    }

    @Test
    public void testInitializeMatrixB(){
        double[][] b3 = Matrix.initializeMatrixB(3);
        double[][] b3Actual = {{0, 3, 6}, {1, 4, 7}, {2, 5, 8}};
        for(int i = 0; i < b3.length; i++){
            for(int j = 0; j < b3.length; j++) {
                assertEquals(b3[i][j], b3Actual[i][j], 0);
            }
        }
    }
}