package Map.Bipartite;

import java.util.LinkedList;
import java.util.Queue;

public class LC785_IsBipartite {
    private boolean BipartiteStatus = true;// 记录图是否符合二分图性质
    private boolean[] color;// 记录图中节点的颜色，false 和 true 代表两种不同颜色
    private boolean[] visited;// 记录图中节点是否被访问过
    // 主函数，输入邻接表，判断是否是二分图
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];
        // 因为图不一定是联通的，可能存在多个子图
        // 所以要把每个节点都作为起点进行一次遍历
        // 如果发现任何一个子图不是二分图，整幅图都不算二分图
        for (int v = 0; v < n; v++) {
            if(!visited[v]) {
                dfs(graph, v);
            }
        }
        return BipartiteStatus;
    }

    // DFS 遍历框架
    void dfs(int[][] graph, int v){
        // 如果已经确定不是二分图了，就不用浪费时间再递归遍历了
        if(!BipartiteStatus)
            return;
        //标记为已访问
        visited[v] = true;

        for(int w : graph[v]){
            if(!visited[w]){
                // 相邻节点 w 没有被访问过，那么应该给节点 w 涂上和节点 v 不同的颜色
                color[w] = !color[v];
                // 继续向深处遍历 w
                dfs(graph, w);
            }else{
                // 相邻节点 w 已经被访问过，根据 v 和 w 的颜色判断是否是二分图
                if(color[v] == color[w]){// 若相同，则此图不是二分图
                    BipartiteStatus = false;
                }
            }
        }
    }

    public boolean isBipartiteBFS(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];
        for (int v = 0; v < n; v++) {
            if(!visited[v]) {
                BFS(graph, v);
            }
        }
        return BipartiteStatus;
    }

    void BFS(int[][] graph, int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty() && BipartiteStatus){
            int v = queue.poll();
            for(int w : graph[v]){
                if(!visited[w]){
                    color[w] = !color[v];
                    visited[w] = true;
                    queue.add(w);
                }else{
                    if(color[v] == color[w]){
                        BipartiteStatus = false;
                        return;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,3},{0,2},{1,3},{0,2}};
        LC785_IsBipartite solution = new LC785_IsBipartite();
        System.out.println(solution.isBipartiteBFS(graph));
    }
}
