import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class md1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int T = in.nextInt();
        while(T-- >0){
            int x = in.nextInt();
            int n = in.nextInt();

            int y = minPrimeFactor(x);
            int z = x*7;
            int avg = z/y;
            int last = z - (y-1)*avg;

            int[] months = new int[y];
            Arrays.fill(months,0,y-1,avg);
            months[y-1]=last;

            long tDay = 1L * (n-1) * 7 + 1;
            long year = 1;
            long yearDays = z;

            if(tDay > yearDays){
                year += (tDay-1)/yearDays;
                tDay = (tDay-1)%yearDays + 1;
            }

            int month = 1;
            while(month<=y && tDay>months[month-1]){
                tDay -= months[month-1];
                month++;
            }
            System.out.println(year + " "+month+" "+tDay);
        }
    }

    public static int minPrimeFactor(int x){
        for(int i = 2; i*i <=x;i++){
            if(x%i==0)
                return i;
        }
        return x;
    }
}