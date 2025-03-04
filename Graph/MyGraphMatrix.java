package Graph;
import java.util.*;

public class MyGraphMatrix {
    private int[][] adjmatrix;
    private int numVertices;

    public MyGraphMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjmatrix = new int[numVertices][numVertices];
    }
    // 添加边
    public void addEdge(int v1, int v2) {
        adjmatrix[v1][v2] = 1;
        adjmatrix[v2][v1] = 1;//无向图
    }
    // 打印邻接矩阵
    public void printMatrix() {
        for(int[] row : adjmatrix) {
            for(int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    // 深度优先搜索（递归）
    public void dfsRecursive(int start) {
        boolean[] visited = new boolean[numVertices];
        System.out.println("DFS DP.Recursive " + start);
        dfsRecursiveHelper(start, visited);
        System.out.println();
    }

    private void dfsRecursiveHelper(int node, boolean[] visited) {
        visited[node] = true;
        System.out.println((node) + " ");
        for(int i = 0; i < numVertices; i++) {
            if(adjmatrix[node][i] == 1 && !visited[i]) {
                dfsRecursiveHelper(i, visited);
            }
        }
    }

    private void dfsIterative(int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[numVertices];

        stack.push(start);
        System.out.println("DFS Iterative " + start);
        while(!stack.isEmpty()) {
            int node = stack.pop();
            if(!visited[node]) {
                visited[node] = true;
                System.out.println((node) + " ");
            }
            for(int i = numVertices - 1; i >= 0; i--) {
                if(adjmatrix[node][i] == 1 && !visited[i]) {
                    stack.push(i);
                }
            }
        }
        System.out.println();
    }

    // 广度优先搜索
    public void bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[numVertices];

        queue.add(start);
        visited[start] = true;

        System.out.println("BFS:");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print((node) + " "); // 输出节点编号

            for (int i = 0; i < numVertices; i++) {
                if (adjmatrix[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyGraphMatrix graph = new MyGraphMatrix(7);
        // 构建图
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        // 打印邻接矩阵
        System.out.println("Adjacency Matrix:");
        graph.printMatrix();

        // 执行 DFS 和 BFS
        graph.dfsRecursive(0);
        graph.dfsIterative(0);
        graph.bfs(0);
    }
}
