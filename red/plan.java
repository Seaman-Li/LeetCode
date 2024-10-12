package red;

import java.util.Scanner;

public class plan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int mul = 1;
        int num = 0;

        for (int i = 0; i < n; i++) {
            mul *= arr[i];
            if(mul % x == 0){
                num ++;
                if(i+1<n){
                    mul = arr[i];
                }else{
                    mul = 1;
                }
            }
        }
        if(mul % x != 0){
            num++;
        }
        System.out.println(num);
        sc.close();
    }

}
