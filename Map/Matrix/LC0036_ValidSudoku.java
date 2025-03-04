package Map.Matrix;

import java.util.HashSet;

public class LC0036_ValidSudoku {

//    Use 3 HashSets per row, column, and 3x3 sub-box.
//    Iterate over the board and:
//    Check if a number already exists in the corresponding row set.
//            Check if a number already exists in the corresponding column set.
//            Check if a number already exists in the corresponding sub-box set.
//    If any of the conditions fail, return false.
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for(int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                char num = board[r][c];
                if(num == '.')// Ignore empty cells
                    continue;

                int boxIndex = (r / 3) * 3 + (c / 3);// Get 3x3 box index

                if(rows[r].contains(num) || cols[c].contains(num) || boxes[boxIndex].contains(num)){
                    return false;
                }

                rows[r].add(num);
                cols[c].add(num);
                boxes[boxIndex].add(num);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8', '.', '.', '.', '6', '.', '.','.','3'},
                {'4', '.', '.', '8', '.', '3', '.', '.','1'},
                {'7', '.', '.', '.', '2', '.', '.','.','6'},
                {'.','6','.', '.', '.','2','.','.','5'},
                {'.','.', '.', '4', '1', '9', '.', '.','5'},
                {'.','.', '.', '.', '8', '.', '.','7','9'}
        };
        LC0036_ValidSudoku solution = new LC0036_ValidSudoku();
        System.out.println(solution.isValidSudoku(board));
    }


}
