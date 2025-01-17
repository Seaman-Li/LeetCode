package Map.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//逆向思维：从太平洋和大西洋的边界反向出发，找出能到达的点。
//分别构建两个布尔网格 pacific 和 atlantic：
//pacific[i][j] = true 表示从网格边界流向太平洋的水可以到达 (i, j)。
//atlantic[i][j] = true 表示从网格边界流向大西洋的水可以到达 (i, j)。
//最终答案是同时满足 pacific[i][j] 和 atlantic[i][j] 的点。

public class LC417_PacificAtlanticWaterFlow {

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // 从边界出发进行 DFS
        for (int i = 0; i < rows; i++) {
            dfs(heights, pacific, i, 0);       // 左边界（太平洋）
            dfs(heights, atlantic, i, cols - 1); // 右边界（大西洋）
        }
        for (int j = 0; j < cols; j++) {
            dfs(heights, pacific, 0, j);       // 上边界（太平洋）
            dfs(heights, atlantic, rows - 1, j); // 下边界（大西洋）
        }

        // 找到能流向两个洋的点,遍历整个网格，将两个布尔网格都为 true 的点加入结果
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    public static void dfs(int[][] heights, boolean[][] ocean, int row, int col) {
        ocean[row][col] = true;//标记为已访问
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            // 检查边界条件和高度条件:①未超过边界②未访问条件：相邻单元格还未被访问过（避免重复计算）③高度判断：确保从当前单元格 (row, col) 流向相邻单元格 (newRow, newCol) 是合法的
            if (newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length
                    && !ocean[newRow][newCol] && heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, ocean, newRow, newCol);
            }
        }
    }

    public List<List<Integer>> pacificAtlanticBFS(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        // 初始化边界
        for (int i = 0; i < rows; i++) {
            pacificQueue.add(new int[]{i, 0});       // 左边界
            atlanticQueue.add(new int[]{i, cols - 1}); // 右边界
            pacific[i][0] = true;
            atlantic[i][cols - 1] = true;
        }
        for (int j = 0; j < cols; j++) {
            pacificQueue.add(new int[]{0, j});       // 上边界
            atlanticQueue.add(new int[]{rows - 1, j}); // 下边界
            pacific[0][j] = true;
            atlantic[rows - 1][j] = true;
        }

        // BFS 从边界出发
        bfs(heights, pacificQueue, pacific);
        bfs(heights, atlanticQueue, atlantic);

        // 找到能流向两个洋的点
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] ocean) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // 检查边界条件和高度条件
                if (newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length
                        && !ocean[newRow][newCol] && heights[newRow][newCol] >= heights[row][col]) {
                    ocean[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
