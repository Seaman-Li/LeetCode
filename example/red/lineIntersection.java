package red;

import java.util.Scanner;

public class lineIntersection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] lines = new int[n][n];

        for (int i = 0; i < n; i++) {
            lines[i][0] = scanner.nextInt();
            lines[i][1] = scanner.nextInt();
        }

        int num = positiveIntersection(lines);

        System.out.println(num);

        scanner.close();

    }

    public static int positiveIntersection(int[][] lines) {
        int count = 0;

        for (int i = 0; i < lines.length; i++) {
            int k1 = lines[i][0];
            int b1 = lines[i][1];
            for (int j = i + 1; j < lines.length; j++) {
                int k2 = lines[j][0];
                int b2 = lines[j][1];

                if(k1 != k2){
                    double x = (double)(b2 - b1) / (k1 - k2);
                    if(x >= 0){
                        count = count + 1;
                    }
                }
            }
        }

        return count;
    }
}
