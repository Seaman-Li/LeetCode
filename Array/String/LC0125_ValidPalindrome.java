package Array.String;

public class LC0125_ValidPalindrome {

    //Using Regex & StringBuilder
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public boolean isPalindrome1(String s) {
        int left = 0, right = s.length() - 1;
        // Skip non-alphanumeric characters
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (right > left && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            // Compare characters (case insensitive)
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        LC0125_ValidPalindrome sol = new LC0125_ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        String s2 = "OP";
        System.out.println(sol.isPalindrome(s2));
    }
}
