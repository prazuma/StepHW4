/**
 * Created by hashimotomika on 6/20/15.
 */
public class Matrix {
    public static void main(String[] args){

    }
    public static double calculateSum(double[][] a){
        if(a == null) return -1;
        double sum = 0;
        int n = a.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sum += a[i][j];
            }
        }
        return sum;
    }
    public static double[][] mulMatrix(double[][]a, double[][] b){
        if(a.length != b.length) return null;
        int n = a.length;
        double[][] c = new double[n][n];
        int i, j;
        for(i = 0; i < n; i++){
            for(j = 0; j < n; j++){
                c[i][j] = 0;
            }
        }
        for(i = 0; i < n; i++){
            for(j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
    public static double[][] initializeMatrixA(int n){
        double[][] a = new double[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = i * n + j;
            }
        }
        return a;
    }
    public static double[][] initializeMatrixB(int n){
        double[][] b = new double[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                b[i][j] = j * n + i;
            }
        }
        return b;
    }
}
