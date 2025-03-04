package Graph.Matrix;

public class LC0289_GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] res = new int[m][n]; // Create a new array to store next state

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j, m, n);

                // Apply Game of Life rules directly to res array
                if (board[i][j] == 1) {  // Live cell
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        res[i][j] = 0; // Dies
                    } else {
                        res[i][j] = 1; // Stays alive
                    }
                } else {  // Dead cell
                    if (liveNeighbors == 3) {
                        res[i][j] = 1; // Becomes alive
                    }
                }
            }
        }

        // Efficiently copy res into board (row by row)
        for (int i = 0; i < m; i++) {
            System.arraycopy(res[i], 0, board[i], 0, n);
//            for (int j = 0; j < n; j++) {
//                board[i][j] = res[i][j];
//            }
        }
    }

    // Function to count live neighbors
    private int countLiveNeighbors(int[][] board, int row, int col, int m, int n) {
        int count = 0;
        int[] directions = {-1, 0, 1}; // Used for 8 directions

        for (int dx : directions) {
            for (int dy : directions) {
                if (dx == 0 && dy == 0) continue; // Skip the cell itself
                int newRow = row + dx, newCol = col + dy;
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && board[newRow][newCol] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        LC0289_GameOfLife game = new LC0289_GameOfLife();
        game.gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
