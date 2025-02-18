package Array.String;

public class LC0345_ReverseVowels {
    public static void main(String[] args) {
        String str ="IceCreAm";
        System.out.println(reverseVowels(str));
    }

//定义元音字母：首先，定义一个集合或数组来快速判断一个字符是否是元音字母（'a', 'e', 'i', 'o', 'u' 以及它们的大写形式）。
//初始化双指针：一个指针 left 从字符串的开头开始，另一个指针 right 从字符串的结尾开始。
//遍历和交换：移动两个指针向中间靠拢，当两个指针都指向元音时进行交换，然后各自向中心移动一步。如果指向的不是元音，则单独移动该指针直至指向元音或两指针相遇。
    public static String reverseVowels(String s) {
        if(s == null || s.length() == 0)  return s;
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        String vowels = "aeiouAEIOU";
        while(left < right) {

            while(left < right && !vowels.contains(String.valueOf(chars[left]))) {
                left++;
            }
//这里!vowels.contains(String.valueOf(chars[left])和vowels.indexOf(chars[right]) == -1等价
            while(left < right && vowels.indexOf(chars[right]) == -1){
                right--;
            }

            if(left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
