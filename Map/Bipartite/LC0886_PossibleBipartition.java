package Map.Bipartite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC0886_PossibleBipartition {
    private boolean BipartiteStatus = true;// 记录图是否符合二分图性质
    private boolean[] color;// 记录图中节点的颜色，false 和 true 代表两种不同颜色
    private boolean[] visited;// 记录图中节点是否被访问过

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = buildGraph(n,dislikes);
        color = new boolean[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                dfs(i,graph);
            }
        }
        return BipartiteStatus;
    }

    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        // 图节点编号为 1...n
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : dislikes) {
            int v = edge[1];
            int w = edge[0];
            // 「无向图」相当于「双向图」
            // v -> w
            graph[v].add(w);
            // w -> v
            graph[w].add(v);
        }
        return graph;
    }

    void dfs(int v, List<Integer>[] graph) {
        if (!BipartiteStatus) {
            return;
        }
        visited[v] = true;
        for (int w : graph[v]) {
            if (!visited[w]) {
                color[w] = !color[v];
                dfs(w, graph);
            }else{
                if (color[w] == color[v]) {
                    BipartiteStatus = false;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] dislikes = new int[][]{{1,2},{1,3},{2,4}};
        LC0886_PossibleBipartition sol = new LC0886_PossibleBipartition();
        System.out.println(sol.possibleBipartition(4, dislikes));
    }


}
