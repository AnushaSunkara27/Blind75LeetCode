package Matrix;

import java.util.Arrays;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];

        Arrays.fill(row,0);
        Arrays.fill(column, 0);
        for(int i=0; i< matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        for(int i=0; i<matrix.length; i++) {
            for(int j=0;j< matrix[i].length; j++) {
                if(row[i] == 1 || column[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        SetMatrixZeroes obj = new SetMatrixZeroes();
        obj.setZeroes(matrix);

        System.out.println(matrix.toString());
    }
}
