package Hashmap;

import java.util.HashSet;


//When dealing with loop detection problems, you can use HashSet or Slow & Fast Pointers


public class LC0202_HappyNumber {
//    Compute the sum of squares of digits.
//    If the sum becomes 1, return true (happy number).
//    If the sum repeats (exists in a HashSet), return false (cycle detected).
//    Repeat the process until either condition is met.
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)) {
            set.add(n);
            n = sqrtSum(n);
        }
        return n == 1;
    }

    public int sqrtSum(int n) {
        int sum = 0;
        while (n != 0) {
            int num = n % 10;
            sum += num * num;
            n = n / 10;
        }
        return sum;
    }


//    Use two pointers:
//    Slow pointer moves one step at a time.
//    Fast pointer moves two steps at a time.
//    If they meet at 1, return true.
//    If they meet at a repeating number, return false (cycle detected).
    public boolean isHappy2(int n) {
        int slow = n, fast = n;

        do {
            slow = sqrtSum(slow);          // Move one step
            fast = sqrtSum(sqrtSum(fast));  // Move two steps
        } while (slow != fast);

        return slow == 1;
    }

    public static void main(String[] args) {
        LC0202_HappyNumber sol = new LC0202_HappyNumber();
        System.out.println(sol.isHappy(2));
    }
}
