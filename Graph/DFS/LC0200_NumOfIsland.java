package Graph.DFS;

public class LC0200_NumOfIsland {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        // 检查边界条件
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        // 将当前格子标记为已访问.dfs 函数遍历到值为 0 的位置会直接返回，所以只要把经过的位置都设置为 0，就可以起到不走回头路的作用
        grid[row][col] = '0';
        // 遍历上下左右四个方向
        dfs(grid, row - 1, col); // 上
        dfs(grid, row + 1, col); // 下
        dfs(grid, row, col - 1); // 左
        dfs(grid, row, col + 1); // 右
    }



    public static void main(String[] args) {
        char[][] grid = new char[4][];
        grid[0] = "11000".toCharArray();
        grid[1] = "11000".toCharArray();
        grid[2] = "00100".toCharArray();
        grid[3] = "00011".toCharArray();

//        for(int i = 0;i < grid.length;i++) {
//            for(int j = 0;j < grid[0].length;j++) {
//                System.out.print(grid[i][j] + " ");
//            }
//        }

        LC0200_NumOfIsland sol = new LC0200_NumOfIsland();

        System.out.println(sol.numIslands(grid));

    }
}
