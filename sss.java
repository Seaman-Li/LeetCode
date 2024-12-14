import java.util.Scanner;

public class sss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 数组长度
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 结果数组，存储每个位置的最大和
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = arr[i];

            // 向左扩展
            for (int j = i - 1; j >= 0 ; j--) {
                if(sum<arr[j])
                    sum += arr[j];
                else
                    break;
               // result[i] = Math.max(result[i], sum);
            }

            // 重置sum为当前位置的

            // 向右扩展
            for (int j = i + 1; j < n; j++) {
                if(sum<arr[j])
                    sum += arr[j];
                else
                    break;
                //result[i] = Math.max(result[i], sum);
            }

            result[i] = sum;
        }

        // 输出结果
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

