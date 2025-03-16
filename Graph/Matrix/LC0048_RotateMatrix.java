package Graph.Matrix;

import java.util.Arrays;
import java.util.Collections;

public class LC0048_RotateMatrix {

//    You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
//    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                swap_RowColumn(matrix, i, j);
            }
        }
        // Reverse rows
        for(int[] row : matrix){
            reverseArray(row);
        }
    }

    public static void swap_RowColumn(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    public static void reverseArray(int[] row) {
        int left = 0, right = row.length - 1;
        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }

    public static void PrintMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void RotateMatrix180(int[][] matrix) {
        // Step 1: Reverse rows using Collections.reverse()
        Collections.reverse(Arrays.asList(matrix)); // Reverses the row order

        // Step 2: Reverse each row manually
        for (int[] row : matrix) {
            reverseArray(row); // Reverse elements within each row
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Original Matrix: ");
        PrintMatrix(matrix);
        LC0048_RotateMatrix sol = new LC0048_RotateMatrix();
//        sol.rotate(matrix);
//        System.out.println("\nAfter Rotate 90°: ");
//        PrintMatrix(matrix);
        sol.RotateMatrix180(matrix);
        System.out.println("\nAfter Rotate 180°: ");
        PrintMatrix(matrix);

    }
}
