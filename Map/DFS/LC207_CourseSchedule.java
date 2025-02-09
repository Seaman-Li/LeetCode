package Map.DFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LC207_CourseSchedule {
    boolean[] visited;// 记录节点是否被遍历过
    boolean[] onPath;// 记录递归堆栈中的节点,表示当前节点在路径上
    boolean hasCycle = false;// 记录图中是否有环
    Stack<Integer> path = new Stack<>();  // 保存遍历路径
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            DFS(graph, i);// 遍历图中的所有节点
        }

        // 只要没有循环依赖可以完成所有课程
        return !hasCycle;
    }

    void DFS(List<Integer>[] graph, int s) {
        if(hasCycle){
            return;// 如果已经找到了环，也不用再遍历了
        }

        if(onPath[s]){
            // s 已经在递归路径上，说明成环了
            hasCycle = true;
            return;
        }

        if (visited[s]) {
            // 不用再重复遍历已遍历过的节点
            return;
        }

        // 前序代码位置
        visited[s] = true;
        onPath[s] = true;
        for (int i = 0; i < graph[s].size(); i++) {
            int v = graph[s].get(i);
            DFS(graph, v);
        }
        // 后序代码位置
        onPath[s] = false;//遍历完 s 的所有邻居后，onPath[s] = false（表示该节点遍历完成）
    }

    //buildGraph using adjacency list
    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] graph = new LinkedList[numCourses]; // 图中共有 numCourses 个节点
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int[] edge : prerequisites){
            int from = edge[1], to = edge[0];
            // 添加一条从 from 指向 to 的有向边
            // 边的方向是「被依赖」关系，即修完课程 from 才能修课程 to
            graph[from].add(to);
        }
        return graph;
    }

//    1、构建邻接表，和之前一样，边的方向表示「被依赖」关系。
//    2、构建一个 indegree 数组记录每个节点的入度，即 indegree[i] 记录节点 i 的入度。
//    3、对 BFS 队列进行初始化，将入度为 0 的节点首先装入队列。
//    4、开始执行 BFS 循环，不断弹出队列中的节点，减少相邻节点的入度，并将入度变为 0 的节点加入队列。
//    5、如果最终所有节点都被遍历过（count 等于节点数），则说明不存在环，反之则说明存在环。
    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        // build in-degree Array
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            indegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                // 节点 i 没有入度，即没有依赖的节点。可以作为拓扑排序的起点，加入队列
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            // 弹出节点 cur，并将它指向的节点的入度减一
            for(int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                indegree[next]--;
                if(indegree[next] == 0) {
                    // 如果入度变为 0，说明 next 依赖的节点都已被遍历
                    queue.add(next);
                }
            }
        }
        // 如果所有节点都被遍历过，说明不成环
        return count == numCourses;
    }

    public static void main(String[] args) {
        LC207_CourseSchedule solution = new LC207_CourseSchedule();
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}, {4, 3}, {5, 4}, {2, 5}};
//        solution.buildGraph(2, prerequisites);
        System.out.println(solution.canFinishBFS(6, prerequisites));
    }

}
