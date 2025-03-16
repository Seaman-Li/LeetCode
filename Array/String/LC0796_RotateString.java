package Array.String;

//Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
//A shift on s consists of moving the leftmost character of s to the rightmost position.
//For example, if s = "abcde", then it will be "bcdea" after one shift.
//        Example 1:
//Input: s = "abcde", goal = "cdeab"
//Output: true

public class LC0796_RotateString {
    //Check if s2 is a substring of s1 + s1
    public boolean rotateString(String s, String goal) {
        return (s.length() == goal.length()) && (s + s).contains(goal);
    }


}
