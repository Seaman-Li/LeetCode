package Tree.BinaryTree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//自定义二叉树类
public class BinaryTree {
    public TreeNode root;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 无参构造函数，创建一个空的二叉树
    public BinaryTree() {
        this.root = null;
    }

    // 构造二叉树方法
    public BinaryTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            this.root = null;
        } else {
            this.root = constructBinaryTree(values);
        }
    }

//    offer 方法功能：向队列的尾部添加一个元素。
//    poll 方法功能：移除并返回队列头部的元素。
//    peek 方法功能：返回队列头部的元素但不移除它。
    // 构造二叉树方法，原理同层序遍历
    private TreeNode constructBinaryTree(Integer[] values) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(values[0]);
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    // 前序遍历,dfs同理，输出顺序为根——左——右
    public void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
    // 前序遍历迭代法和中序遍历类似只是打印数据的位置不同
    public void preorderTraversalIteration(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {//循环终止条件：当前访问的节点为空且栈为空
            while (currentNode != null) {
                System.out.print(currentNode.val + " ");
                stack.push(currentNode);     // 把当前节点和左子树节点入栈
                currentNode = currentNode.left;  // 移至最左
            }
            //左子节点为空后再搜索当前节点的右子节点
            currentNode = stack.pop();       // 左子树访问完毕，访问节点
            currentNode = currentNode.right;     // 转向右子树
        }

    }

    // 中序遍历：输出顺序为：左——根——右
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    // 中序遍历迭代法
    public void inorderTraversalIteration(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {//循环终止条件：当前访问的节点为空且栈为空
            //这里会先将遍历到的左子节点入栈
            while (currentNode != null) {
                stack.push(currentNode);     // 把当前节点和左子树节点入栈
                currentNode = currentNode.left;  // 移至最左
            }
            //左子节点为空后先访问并输出当前节点再搜索当前节点的右子节点
            currentNode = stack.pop();       // 左子树访问完毕，访问节点
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.right;     // 转向右子树
        }
    }


    // 后序遍历：输出顺序为左——右——根
    public void postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }

    // 后序遍历迭代法
    public void postorderTraversalIteration(TreeNode root){
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null; // 用于记录上一次访问过的节点
        TreeNode currentNode = root;

        while (!stack.isEmpty() || currentNode != null) {
            //搜索左子树
            while (currentNode != null) {
                stack.push(currentNode); // 将节点推入栈
                currentNode = currentNode.left; // 移动到左子树
            }
            //取出最后一个左子树叶子节点
            currentNode = stack.pop();
            //这里如果没有右子树节点或者右子树节点已经访问过了就输出当前节点
            if(currentNode.right == null||currentNode.right == lastVisited){
                System.out.print(currentNode.val + " ");
                lastVisited = currentNode;
                currentNode = null;
            }else{
                stack.push(currentNode);
                currentNode = currentNode.right;
            }
        }
    }

    //   层序遍历，广度优先搜索bfs同理
    public void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            System.out.print(currentNode.val + " ");

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }
    }
    public void levelOrderTraversalWithNull(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if (currentNode == null) {
                // 如果当前节点为 null，输出 null 并继续
                System.out.print("null ");
                continue;
            }
            // 输出当前节点的值
            System.out.print(currentNode.val + " ");
            // 将当前节点的左右子节点加入队列
            queue.offer(currentNode.left);
            queue.offer(currentNode.right);
        }
    }


    //    根据节点的value查找节点,BFS,层序遍历搜索
    public TreeNode findNode(int value) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.val == value) {
                return current;
            }
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return null;
    }

}
