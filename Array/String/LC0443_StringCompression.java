package Array.String;

import java.util.Arrays;

public class LC0443_StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b','b','b'};
        LC0443_StringCompression sol = new LC0443_StringCompression();
        System.out.println(sol.compress(chars) + Arrays.toString(chars));
    }

    public int compress(char[] chars) {
        int write = 0, anchor = 0;

        for (int read = 0; read < chars.length; read++) {
            // Check if we are at the end of the array or the current character is different from the next character
            if (read + 1 == chars.length || chars[read] != chars[read + 1]) {
                chars[write++] = chars[anchor]; // Write the character
                if (read > anchor) { // More than one of this character
                    String count = Integer.toString(read - anchor + 1);
                    for (char c : count.toCharArray()) {
                        chars[write++] = c; // Write the count
                    }
                }
                anchor = read + 1; // Move anchor to the next new character
            }
        }

        return write;
    }
}
