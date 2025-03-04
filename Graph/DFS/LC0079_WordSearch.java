package Graph.DFS;

public class LC0079_WordSearch {


    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0)){//found the start index of the word and then begin dfs
                    if(dfs(board, word, 0, r, c, visited))
                        return true;
                }
            }
        }
        return false;
    }

    //index tracks the current character position in word that we are trying to match
    public boolean dfs(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if(row < 0 || col < 0|| row >= board.length || col >= board[0].length
                || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;// ❌ Out of bounds or mismatch
        }
        visited[row][col] = true;

        boolean res = dfs(board, word, index + 1, row + 1, col, visited) ||
                      dfs(board, word, index + 1, row - 1, col, visited) ||
                      dfs(board, word, index + 1, row, col + 1, visited) ||
                      dfs(board, word, index + 1, row, col - 1, visited);

        visited[row][col] = false;
        return res;
    }

    public static void main(String[] args) {
        LC0079_WordSearch sol = new LC0079_WordSearch();
        char[][] board = {{'B', 'B', 'C', 'E'},{'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}};
        System.out.println(sol.exist(board, "ABCCED"));
    }
}
