package Map.DFS;

import java.util.*;

public class LC210_CourseScheduleII {
    boolean[] visited;// 记录节点是否被遍历过
    boolean[] onPath;// 记录递归堆栈中的节点,表示当前节点在路径上
    boolean hasCycle = false;// 记录图中是否有环
    List<Integer> postorder = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        //遍历图
        for(int i = 0; i < numCourses; i++){
            DFS(graph, i);
        }
        if(hasCycle){
            return new int[]{};
        }
        Collections.reverse(postorder);
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            res[i] = postorder.get(i);
        }
        return res;

    }

    void DFS(List<Integer>[] graph, int s){
        if (onPath[s]) {
            // 发现环
            hasCycle = true;
        }
        if (visited[s] || hasCycle) {
            return;
        }

        onPath[s] = true;
        visited[s] = true;
        for (int v : graph[s]) {
            DFS(graph, v);
        }
        // 后序遍历位置
        onPath[s] = false;
        postorder.add(s);
    }


    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph[from].add(to);
        }
        return graph;
    }

    public int[] findOrderBFS(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        int[] indegree = new int[numCourses];
        for(int[] edge: prerequisites){
            int from = edge[1], to = edge[0];
            indegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int[] res = new int[numCourses];// 记录拓扑排序结果
        int count = 0;// 记录遍历节点的顺序（索引）
        while(!queue.isEmpty()){
            int cur = queue.poll();
            // 弹出节点的顺序即为拓扑排序结果
            res[count] = cur;
            count++;
            for(int next : graph[cur]){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.add(next);
                }
            }
        }
        if(count != numCourses){
            return new int[]{};// 存在环，拓扑排序不存在
        }
        return res;
    }

    public static void main(String[] args) {
        LC210_CourseScheduleII sol = new LC210_CourseScheduleII();
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}, {4, 3}, {5, 4}};
        int[] res = sol.findOrderBFS(6, prerequisites);
        for(int course : res){
            System.out.println(course);
        }

    }
}
