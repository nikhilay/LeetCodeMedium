/**
 * Created by Nikhil on 11/2/16.
 */
public class SpiralMatrixTwo {

    public static void main(String[] args) {
        new SpiralMatrixTwo().generateMatrix(3);
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int num  =1;
        if(n<=0) return result;
        while(rowStart<=rowEnd && colStart<=colEnd){
            for(int i=colStart;i<=colEnd;i++){
                result[rowStart][i] =num++;
            }
            rowStart++;

            for(int i=rowStart;i<=rowEnd;i++){
                result[i][colEnd] =num++;
            }
            colEnd--;

            for(int i=colEnd;i>=colStart;i--){
                result[rowEnd][i] =num++;
            }
            rowEnd--;

            for(int i=rowEnd;i>=rowStart;i--){
                result[i][colStart] =num++;
            }
            colStart++;
        }

     return result;
    }
}
