package Map.DFS;

import java.util.*;

public class LC841_KeysandRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(3, 0, 1),
                Arrays.asList(2),
                Arrays.asList(0)
        );

        System.out.println(canVisitAllRoomsDFS(rooms));
        System.out.println(canVisitAllRoomsBFS(rooms));
    }


    public static boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);//先访问0号房

        while (!stack.isEmpty()) {
            //迭代rooms(0)~rooms(n)
            int currentRoom = stack.pop();
            System.out.println("Currently in room: " + currentRoom);
            for (int key : rooms.get(currentRoom)) {//迭代rooms(n)内的key
                if (!visited[key]) {
                    System.out.println("find key: " + key);
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }
        //这里还有没访问的就输出false
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    public static boolean canVisitAllRoomsBFS(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();
            System.out.println("Currently in room: " + currentRoom);
            List<Integer> keys = rooms.get(currentRoom);
            for (int i = 0; i < keys.size(); i++) {
                int key = keys.get(i);
                if (!visited[key]) {
                    System.out.println("find key: " + key);
                    visited[key] = true;
                    queue.offer(key);
                }
            }
        }
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

}
