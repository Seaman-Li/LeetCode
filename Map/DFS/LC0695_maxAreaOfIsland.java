package Map.DFS;

import java.util.LinkedList;
import java.util.Queue;

public class LC0695_maxAreaOfIsland {

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // 遍历网格
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) { // 如果是陆地，启动 DFS
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, int row, int col) {
        // 边界检查和是否已访问检查
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        // 将当前格子标记为已访问
        grid[row][col] = 0;

        // 计算面积
        int area = 1;

        // 遍历上下左右
        area += dfs(grid, row - 1, col);
        area += dfs(grid, row + 1, col);
        area += dfs(grid, row, col - 1);
        area += dfs(grid, row, col + 1);

        return area;
    }

//    在 bfs 方法中，方向数组的作用如下：
//    初始化队列：
//    起始格子入队，并将其标记为已访问。
//    弹出队首元素：
//    每次从队列中取出当前格子，统计面积。
//    遍历邻居：
//    使用 directions 数组生成上下左右的邻居格子。
//    检查这些邻居是否有效（未越界、未访问、值为 1）。
//    如果满足条件，将邻居入队，并标记为已访问。
    private int bfs(int[][] grid, int row, int col) {
        int area = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        grid[row][col] = 0; // 标记为已访问

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上下左右方向

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            area++;

            for (int[] direction : directions) {
                int newRow = cell[0] + direction[0];
                int newCol = cell[1] + direction[1];

                // 检查边界和是否是陆地
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                    queue.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 0; // 标记为已访问
                }
            }
        }

        return area;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));
    }

}
