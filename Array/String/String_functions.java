package Array.String;
//1. 检查和比较
//equals(Object another): 比较两个字符串的内容是否相同。
//equalsIgnoreCase(String anotherString): 比较两个字符串的内容是否相同，忽略大小写差异。
//compareTo(String anotherString): 字典顺序比较两个字符串。
//compareToIgnoreCase(String str): 字典顺序比较两个字符串，忽略大小写差异。
//2. 搜索和位置查找
//contains(CharSequence s): 检查字符串是否包含指定的字符序列。
//startsWith(String prefix): 检查字符串是否以指定的前缀开始。
//endsWith(String suffix): 检查字符串是否以指定的后缀结束。
//indexOf(int ch): 返回指定字符在此字符串中第一次出现处的索引。
//lastIndexOf(int ch): 返回指定字符在此字符串中最后一次出现处的索引。
//indexOf(String str): 返回指定子字符串在此字符串中第一次出现处的索引。
//lastIndexOf(String str): 返回指定子字符串在此字符串中最后一次出现处的索引。
//3. 长度和切割
//length(): 返回字符串的长度。
//substring(int beginIndex): 返回一个新字符串，它是此字符串的一个子字符串，从指定索引开始到结尾。
//substring(int beginIndex, int endIndex): 返回一个新字符串，它是此字符串的一个子字符串，从 beginIndex 到 endIndex - 1。
//split(String regex): 根据匹配给定的正则表达式来拆分字符串。
//trim(): 返回字符串的副本，忽略前导空白和尾部空白。
//4. 修改和替换
//replace(char oldChar, char newChar): 返回一个新的字符串，它是通过替换此字符串中出现的所有老字符为新字符获得的。
//replaceAll(String regex, String replacement): 使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
//replaceFirst(String regex, String replacement): 使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
//5. 转换和其他操作
//toLowerCase(): 使用默认语言环境的规则将此 String 中的所有字符都转换为小写。
//toUpperCase(): 使用默认语言环境的规则将此 String 中的所有字符都转换为大写。
//concat(String str): 将指定字符串连接到此字符串的结尾。
//valueOf(): 返回不同类型数据的字符串表示形式（此为 String 类的静态方法）。
//6. 字符串格式化
//format(String format, Object... args): 返回一个格式化字符串使用指定的格式字符串和参数（此为 String 类的静态方法）。
public class String_functions {
    public static void main(String[] args) {
        String a = "abc123";
        String b = "abc";
        String c = a;
        String d = "ABc123";
        System.out.println("a.equals(c) " +a.equals(c));
        System.out.println("a.equalsIgnoreCase(d) " +a.equalsIgnoreCase(d));
        System.out.println("a.compareToIgnoreCase(d) " +a.compareToIgnoreCase(d));//一旦发现两个字符串在某个位置上的字符不同，比较就会停止，然后根据这两个字符的ASCII差异返回一个整数值

        System.out.println("a.contains(b) "+a.contains(b));
        System.out.println("a.startsWith(b) "+a.startsWith(b));

        System.out.println("a.substring "+a.substring(1, 3));
        String e = "       abc1 2 3 4 5      ";
        System.out.println(e+ "e.trim() "+e.trim());
    }
}
