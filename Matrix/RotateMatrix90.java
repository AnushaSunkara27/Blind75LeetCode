package Matrix;

public class RotateMatrix90 {

    public static int[][] rotateBruteForce(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] result = new int[rows][columns];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                result[j][rows-i-1] = matrix[i][j];
            }
        }
        return result;
    }
    

    public static int[][] rotateOptimalApproach(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        // step 1 : Transpose the matrix
        for(int i=0; i<rows; i++) {
            for(int j=i; j<columns; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // step 2 : Reverse elements in each row
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][rows-1-j];
                matrix[i][rows-1-j] = temp;
            }
        }

        return matrix;
    }
}
