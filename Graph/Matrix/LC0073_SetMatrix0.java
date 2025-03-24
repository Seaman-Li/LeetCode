package Graph.Matrix;

public class LC0073_SetMatrix0 {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRowZero = false,firstColZero = false;

        // Step 1: Check first row and column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero  = true;
                break;
            }
        }

        // Step 2: Use first row/col as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Step 3: Zero marked rows/columns
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 4: Zero first row/col if needed
        if (firstColZero) {
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
        if (firstRowZero) {
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
    }


    public static void main(String[] args) {
        LC0073_SetMatrix0 sol = new LC0073_SetMatrix0();
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        sol.setZeroes(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
