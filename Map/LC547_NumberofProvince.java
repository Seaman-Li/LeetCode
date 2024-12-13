package Map;

import java.util.Stack;

public class LC547_NumberofProvince {
//    在无向图中，一个连通分量是图中的一个最大连通子图。
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {//从每个顶点出发找连通分量
            if (!visited[i]) {
                dfs(isConnected, visited, i);//调用 dfs 方法从城市 i 开始进行深度优先搜索，标记所有可以从城市 i 直接或间接到达的城市为已访问
                count++; // 如果城市 i 还没有被访问过，说明从这个城市出发可以探索一个新的连通分量
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        for (int j = 0; j < isConnected.length; j++) {//从city0开始探索当前city和其他城市是否相连
            if (isConnected[city][j] == 1 && !visited[j]) {//城市 city 和城市 j 直接相连，并且城市 j 尚未被访问
                visited[j] = true;
                System.out.println("visit city" + j);
                dfs(isConnected, visited, j);//开始探索城市 j：从城市 j 出发，递归地探索所有通过城市 j 可达的、尚未访问的其他城市。
            }
        }
    }

    //利用栈实现dfs,栈用来显式地保存那些即将被访问的节点，从而模拟递归调用堆栈的行为
    public int findCircleNum2(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        //遍历每个节点：对于图中的每个节点，如果该节点尚未被访问，将其视为新的连通分量的开始
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                while (!stack.isEmpty()) {
                    int current = stack.pop();
                    visited[current] = true;
                    for (int j = 0; j < isConnected.length; j++) {
                        if (isConnected[current][j] == 1 && !visited[j]) {
                            stack.push(j);
                            visited[j] = true; // Mark it visited when pushing to stack
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LC547_NumberofProvince sol = new LC547_NumberofProvince();
        int[][] isConnected = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(sol.findCircleNum(isConnected));
    }
}
