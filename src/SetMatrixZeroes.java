/**
 * Created by Nikhil on 11/13/16.
 */
public class SetMatrixZeroes {
    /**
     * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
     */
    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        boolean[] rows = new boolean[rowLen];
        boolean[] cols = new boolean[colLen];

        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                if(matrix[i][j]==0){
                    rows[i]=true;
                    cols[j]= true;

                }
            }
        }

        for(int i =0;i<rowLen;i++){
            if(rows[i]){
                for(int j=0;j<colLen;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int i =0;i<colLen;i++){
            if(cols[i]){
                for(int j=0;j<rowLen;j++){
                    matrix[j][i]=0;
                }
            }
        }

    }
}
