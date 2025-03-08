package Graph.Matrix;

import java.util.ArrayList;
import java.util.List;

public class LC0054_SpiralMatrix {

//    Traverse in four directions (right, down, left, up):
//    Move right → from left to right, then increment top
//    Move down ↓ from top to bottom, then decrement right
//    Move left ← from right to left, then decrement bottom
//    Move up ↑ from bottom to top, then increment left
//    Repeat until all elements are visited.

//We use four boundaries to keep track of where we are:
//    top: The current top row that hasn't been traversed yet.
//    bottom: The current bottom row that hasn't been traversed yet.
//    left: The current left column that hasn't been traversed yet.
//    right: The current right column that hasn't been traversed yet.
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while(top <= bottom && left <= right) {
            // Move right
            for(int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;// Move boundary down
            // Move down
            for(int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--; // Move boundary left

            // Move left (only if top <= bottom)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--; // Move boundary up
            }
            // Move up (only if left <= right)
            if(left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        LC0054_SpiralMatrix solution = new LC0054_SpiralMatrix();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(solution.spiralOrder(matrix));
    }
}
