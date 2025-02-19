package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC0077_Combinations {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();


    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }

    public void backtrack(int start, int n, int k) {
        if(track.size() == k) {// Base case: A valid combination is found
            res.add(new ArrayList<>(track));
            return;
        }
        for(int i = start; i <= n; i++) {
            track.add(i);// Choose a number
            backtrack(i + 1, n, k);// Explore further
            track.removeLast();// Undo choice (backtrack)
        }


    }

    public static void main(String[] args) {
        LC0077_Combinations sol = new LC0077_Combinations();
        System.out.println(sol.combine(4, 3));
    }

}
