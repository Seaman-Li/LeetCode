package DP;

import java.util.Arrays;

public class LC304_NumMatrix {
    private int[][] prefixSum;

    public LC304_NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int m = matrix.length;
        int n = matrix[0].length;
        prefixSum = new int[m + 1][n + 1];



//        直接加上当前元素的值：matrix[i-1][j-1] 表示矩阵中第 i 行、第 j 列的元素值。
//        prefixSum[i][j] 表示从矩阵左上角 (1,1) 到 (i,j) 的子矩阵的和。
//        加上上方和左侧的前缀和：
//        prefixSum[i-1][j] 表示从 (0,0) 到 (i-2,j-1) 的子矩阵和，覆盖了当前元素上方的区域。
//        prefixSum[i][j-1] 表示从 (0,0) 到 (i-1,j-2) 的子矩阵和，覆盖了当前元素左侧的区域。
//        减去重复计算的区域：由于上方和左侧的前缀和在计算时，区域 (i-2,j-2) 到 (i-1,j-1) 的部分被重复计算了一次，因此需要减去该区域的前缀和 prefixSum[i-1][j-1]。

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                prefixSum[i][j] = matrix[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        for(int[] arr : prefixSum){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("\n");
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1] -
                prefixSum[row2 + 1][col1] -
                prefixSum[row1][col2 + 1] +
                prefixSum[row1][col1];
    }


    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        for(int[] arr : grid){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("\n");
        LC304_NumMatrix martix = new LC304_NumMatrix(grid);
        System.out.println(martix.sumRegion(1, 1, 2, 2));
    }
}
