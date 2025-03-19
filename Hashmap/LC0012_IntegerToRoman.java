package Hashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LC0012_IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                res.append(symbols[i]);
                num -= values[i];
            }
        }
        return res.toString();
    }

    public String intToRoman2(int num) {
        Map<Integer, String> romanMap = new LinkedHashMap<>();//LinkedHashMap Preserves insertion order, ensuring we process numerals from largest to smallest
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        StringBuilder res = new StringBuilder();
        for(Map.Entry<Integer, String> entry : romanMap.entrySet()) {
            while(num >= entry.getKey()) {
                res.append(entry.getValue());
                num -= entry.getKey();
            }
        }

        return res.toString();

    }


    public static void main(String[] args) {
        LC0012_IntegerToRoman solution = new LC0012_IntegerToRoman();
        System.out.println(solution.intToRoman(1987));
    }
}
