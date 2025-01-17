package Map.DFS;

//深度优先搜索（DFS）
//定义：
//深度优先搜索是一种图的遍历方法，它优先沿着一条路径深入到尽可能深的节点，然后再回溯到上一个节点并探索其他路径。
//特点：
//遍历目标：DFS 通常用于遍历所有节点，或者找到某种特定的路径/结构。
//数据结构：使用递归或显式栈来实现。
//适用场景：
//图或树的遍历。
//找到特定路径、连通分量、拓扑排序等。

public class LC130_SurroundedRegions {
    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;

        // 标记边界连通的 'O' 为 '#'
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0); // 左边界
            dfs(board, i, cols - 1); // 右边界
        }
        for (int j = 0; j < cols; j++) {
            dfs(board, 0, j); // 上边界
            dfs(board, rows - 1, j); // 下边界
        }

        // 遍历网格，修改内容，此时O都是被包围的，变成X即可，再把#还原成O
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // 未标记的 'O' 是被包围的，变为 'X'
                }else if (board[i][j] == '#') {
                    board[i][j] = 'O'; // 恢复边界连通的 'O'
                }
            }
        }
    }

    private static void dfs(char[][] board, int row, int col) {
        // 检查边界和是否为 'O'
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') {
            return;
        }

        // 标记当前格子
        board[row][col] = '#';

        // 递归标记上下左右
        dfs(board, row - 1, col); // 上
        dfs(board, row + 1, col); // 下
        dfs(board, row, col - 1); // 左
        dfs(board, row, col + 1); // 右
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'}, {'O','O','X','X'},{'X','X','O','X'},{'X','X','X','X'}};
        solve(board);
        for(char[] arr : board){
            System.out.println(arr);
        }
    }
}
