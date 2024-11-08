import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    static int[] parent;
    static int[] size;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        parent = new int[n];
        size = new int[n];
    }

}
