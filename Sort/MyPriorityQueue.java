package Sort;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class MyPriorityQueue<T> {
    private T[] heap;
    private int size;
    private final Comparator<? super T> comparator;
//? super T 表示 Comparator 的泛型可以是 T 或 T 的任何父类，这被称为 泛型的下界（Lower Bounded Wildcard）。这样可以 兼容更广泛的 Comparator 类型，使得 MyPriorityQueue<T> 可以接受 T 的子类 以及 父类的 Comparator 进行比较。
//compare(a, b) 方法：返回负值：a 在 b 前面（优先级更高 a<b）。返回 0：a 和 b 视为相等。返回正值：a 在 b 后面（优先级更低 a>b）。
//Comparator.naturalOrder()	最小堆	元素按升序出队
//Comparator.reverseOrder()	最大堆	元素按降序出队
//(a, b) -> a.length() - b.length()	按字符串长度升序	短字符串优先出队
//(a, b) -> b.length() - a.length()	按字符串长度降序	长字符串优先出队


// ❌ 编译错误 heap = new T[capacity];Java 不允许 new T[]，因为 T 只是编译时的占位符，在 运行时被擦除
//new Object[capacity] 允许,强制转换 (T[]) new Object[capacity] 欺骗编译器，但可能会导致运行时类型安全问题。这行注解 抑制 Java 编译器对 未检查类型转换（Unchecked Cast）的警告。
    @SuppressWarnings("unchecked")
    public MyPriorityQueue(int capacity, Comparator<? super T> comparator) {
        heap = (T[]) new Object[capacity];// 创建泛型数组
        size = 0;
        this.comparator = comparator;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    // 父节点的索引
    public int parent(int node){
        return (node - 1) / 2;
    }
    // 左子节点的索引
    public int left(int node){
        return node * 2 + 1;
    }
    // 右子节点的索引
    public int right(int node){
        return node * 2 + 2;
    }

    public void swap(int i, int j){
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // 查，返回堆顶元素，时间复杂度 O(1)
    public T peek(){
        if(isEmpty())
            throw new NoSuchElementException("Priority queue underflow");
        return heap[0];
    }

    // 增，向堆中插入一个元素，时间复杂度 O(logN)
    public void push(T x){
        if(size == heap.length){// 扩容
            resize(2 * heap.length);
        }
        heap[size] = x;// 把新元素追加到最后
        swim(size); // 然后上浮到正确位置
        size++;
    }


    // 删，删除堆顶元素，时间复杂度 O(logN)
    public T pop(){
        if(isEmpty())
            throw new NoSuchElementException("Priority queue underflow");
        T res = heap[0];
        // 把堆底元素放到堆顶
        swap(0, size - 1);
        heap[size - 1] = null;// 避免对象游离
        size--;
        sink(0);// 然后把交换后的队尾元素下沉到正确位置
        // 缩容
        if((size > 0) && (size == heap.length / 4)){//Java ArrayList 采用相同的缩容策略，当元素个数小于总容量的 1/4 时，数组大小减半。
            resize(heap.length/2);
        }
        return res;
    }


    // 下沉操作，时间复杂度是树高 O(logN) ,将小的值下称
    public void sink(int node){
        while(left(node) < size || right(node) < size){
            // 比较自己和左右子节点，看看谁最小
            int min = node;
            if(left(node) < size && comparator.compare(heap[left(node)], heap[min]) < 0){ //heap[left(node)]<heap[min]
                min = left(node);
            }
            if(right(node) < size && comparator.compare(heap[right(node)], heap[min]) < 0){//heap[right(node)]<heap[min]
                min = right(node);
            }
            if(node == min){
                break;
            }
            // 如果左右子节点中有比自己小的，就交换
            swap(node, min);
            node = min;//将最小值的索引赋值给node在之后的循环中继续寻找最小值
        }
    }

    // 上浮操作，时间复杂度是树高 O(logN) ， 将大的值上浮
    private void swim(int node){
        while (node > 0 && comparator.compare(heap[parent(node)], heap[node]) > 0){ // heap[parent(node)] > heap[node])
            swap(node, parent(node));
            node = parent(node);
        }
    }

    // 调整堆的大小,create a new tempHeap using the capacity parameter, and then assign the value in heap to tempHeap, using the tempHeap as the new heap
    @SuppressWarnings("unchecked")
    public void resize(int capacity){
        assert capacity > size;//assert 条件表达式 : 错误消息;如果 capacity <= size，程序会抛出 AssertionError，提示缩容错误。
        T[] temp = (T[]) new Object[capacity];
        for(int i = 0; i < size; i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }


    public static void main(String[] args) {
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>(3, Comparator.naturalOrder());
        pq.push(3);
        pq.push(1);
        pq.push(4);
        pq.push(1);
        pq.push(5);
        pq.push(9);
        // 1 1 3 4 5 9
        while (!pq.isEmpty()) {
            System.out.println(pq.pop());
        }
    }
}
