package example;

import java.util.Arrays;

public class sol {

    public static int arrangeClues(int[] clues) {
        // write code here
        if(!hasDuplicates(clues)){
            return factorial(clues.length);
        }else{
            return 0;
        }

    }

    public static boolean hasDuplicates(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i+1]){
                return true;
            }
        }
        return false;
    }

    public static int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        int []nums = {1,2,3};
        System.out.println(hasDuplicates(nums));
        System.out.println(factorial(nums.length));
        System.out.println(arrangeClues(nums));
    }
}
