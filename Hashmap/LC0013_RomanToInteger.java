package Hashmap;

import java.util.HashMap;
import java.util.Map;

public class LC0013_RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int preVal = 0;

        //Iterate through the string from left to right
        for (int i = s.length() - 1; i >= 0; i--) {
            int curVal = romanMap.get(s.charAt(i));
            if(curVal < preVal){
                total -= curVal;// Handle subtractive notation (e.g., IV, IX, etc.)
            }else{
                total += curVal;// Add normal values
            }
            preVal = curVal;// Update previous value for comparison
        }
        return total;
    }

    public static void main(String[] args) {
        LC0013_RomanToInteger sol = new LC0013_RomanToInteger();
        System.out.println(sol.romanToInt("MCMXCIV")); // Output: 1994
    }

}
