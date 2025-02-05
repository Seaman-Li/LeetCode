package LRU;

import java.util.HashMap;
import java.util.Map;
//Leetcode  146
public class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;// 最大容量
    private final Map<Integer, Node> map;
    private final Node head, tail;//head 和 tail 只是占位符，不存储数据。这样可以确保 addToHead() 和 removeNode() 代码更简洁，不需要处理 null。

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1); // 伪头节点
        tail = new Node(-1, -1); // 伪尾节点
        head.next = tail;
        tail.prev = head;
    }
//    在 O(1) 时间内找到 key 并返回 value。将 key 移动到链表头部（最近使用）。
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveToHead(node); // 将该数据提升为最近使用的
        return node.value;
    }
//若 key 已存在：更新 value，并将 key 移动到链表头部。
//若 key 不存在：
//    若 缓存未满，创建新节点并插入头部。
//    若 缓存已满，删除最久未使用的 key（链表尾部），再插入新 key。
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        }else {
            if (map.size() == capacity) {
                removeLRU();
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
        }
    }

//    先 删除 node，再 添加到头部。
    public void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
//    在 head 后插入 node，保持最近访问的数据在前面。(注意顺序：双向链表的插入先设置插入节点node的指针，再断开原来的)
    public void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
//    直接修改 prev 和 next 的指针，将 node 移除。
    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
//    找到 tail.prev（最久未使用的节点）。从链表中删除，并从 map 移除。
    public void removeLRU(){
        Node lruNode = tail.prev;
        removeNode(lruNode);
        map.remove(lruNode.key);
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 1
        cache.put(3, 3); // 淘汰 key=2
        System.out.println(cache.get(2)); // -1 (2 被淘汰)
        cache.put(4, 4); // 淘汰 key=1
        System.out.println(cache.get(1)); // -1 (1 被淘汰)
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4

    }
}
//LinkedList 不能 O(1) 删除指定节点
//LinkedList 底层是双向链表，但 没有提供 O(1) 时间删除指定节点 的方法。
//        LinkedList.remove(Object) 需要先搜索该节点（O(N)），然后才能删除。
//我们的 LRUCache 需要 O(1) 删除最近最少使用的节点，所以 必须使用 HashMap<Node> 来快速找到节点并删除。
//        2. LinkedList 不支持 O(1) 访问 Node
//LinkedList.get(int index) 需要 O(N) 时间，因为它是顺序查找。
//但是 LRUCache 需要 O(1) 获取 Node（通过 HashMap 存储 key → Node）。
//所以不能直接用 LinkedList。
//        3. LinkedList 不能轻松调整节点位置
//LinkedList 不能 O(1) 直接移动节点到头部（需要先 remove 再 addFirst）。
//自定义 Node 结构 允许我们直接调整 prev/next 指针，不需要搜索，效率更高。
//        4. LinkedList 不能 O(1) 删除尾部元素
//LinkedList.removeLast() 也是 O(1)，但如果 removeLast() 需要先找到 Node，就会变成 O(N)。
//在 LRUCache 里，尾部元素（最久未使用）必须 O(1) 删除，所以我们用 伪头尾 head/tail 指针 实现。