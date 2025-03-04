package Graph.DFS;

public class LC1254_NumOfClosedIslands {

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int j = 0; j < n; j++){
            dfs(grid, 0, j);// 把靠上边界的岛屿淹掉
            dfs(grid, m - 1, j);// 把靠上边界的岛屿淹掉
        }
        for(int i = 0; i < m; i++){
            dfs(grid, i, 0);// 把靠左边界的岛屿淹掉
            dfs(grid, i, n - 1);// 把靠右边界的岛屿淹掉
        }
        int res = 0;
        // 遍历 grid，剩下的岛屿都是封闭岛屿
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }


    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 1) { // 已经是海水了
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = 1;
        // 淹没上下左右的陆地
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        LC1254_NumOfClosedIslands sol = new LC1254_NumOfClosedIslands();
        System.out.println(sol.closedIsland(grid));
    }
}
