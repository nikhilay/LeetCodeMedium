/**
 * Created by Nikhil on 12/14/16.
 */
/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner
 * a(row1, col1) and lower right corner (row2, col2).
 */

/**
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 */
public class RangeSumQuery2DImmutable {

    private int[][] summation;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        if(matrix!=null && matrix.length!=0&&matrix[0].length!=0){
        summation = new int[matrix.length+1][matrix[0].length+1];}
        for (int row = 0; row < matrix.length; row++) {
            int sum =0;
            for (int col = 0; col < matrix[0].length; col++) {
                sum+=matrix[row][col];
                summation[row+1][col+1] = sum+ summation[row][col+1];

            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return summation[row2+1][col2+1]- summation[row1][col2+1]-summation[row2+1][col1]+summation[row1][col1];
    }
}
