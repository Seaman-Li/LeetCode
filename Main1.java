import java.util.Scanner;

public class Main1 {
    public static char unshift(char ch, int k){
        if(ch >= 'a' && ch <= 'z'){
            int temp = ch - k;
            if(temp < 'a'){
                temp = temp + 26;
            }
            return (char) temp;
        }else{
            return ch;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int q = sc.nextInt(); //q行操作次数
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt() - 1;//左端
            int r = sc.nextInt() - 1;//右端
            int k = sc.nextInt();   //位移量
            for (int j = l; j <= r; j++) {
                k = k % 26;
                sb.setCharAt(j, unshift(sb.charAt(j), k));
            }
//            System.out.println(sb.toString());
        }
        System.out.println(sb);
        sc.close();
//        System.out.println(shift('y', 3));
    }
}
