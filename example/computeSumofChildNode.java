package example;

import java.util.*;

public class computeSumofChildNode {
    static class TreeNode {
        int value;
        List<TreeNode> children = new ArrayList<>();

        TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 有效节点数
        int[] sequence = new int[2 * n]; // 包含空节点的完整层序序列

        for (int i = 0; i < 2 * n; i++) {
            sequence[i] = scanner.nextInt();
        }

        TreeNode root = null;
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;

        if (sequence[index] != -1) {
            root = new TreeNode(sequence[index]);
            queue.add(root);
            index++;
        }

        // 使用队列构建树
        while (!queue.isEmpty() && index < 2 * n) {
            TreeNode current = queue.poll();

            // 继续添加子节点直到遇到-1
            while (index < 2 * n && sequence[index] != -1) {
                TreeNode child = new TreeNode(sequence[index]);
                current.children.add(child);
                queue.add(child);
                index++;
            }
            // 跳过-1标记
            index++;
        }

        // 计算每个节点的子树和
        computeSubtreeSums(root);

        // 输出层序遍历的结果，包括-1
        queue.add(root);
        index = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.value + " ");
            for (TreeNode child : node.children) {
                queue.add(child);
            }

            // 检查原始序列来确定是否需要输出-1
            if (index + 1 < 2 * n && sequence[index + 1] == -1) {
                System.out.print("-1 ");
                index++;
            }
            index++;
        }
        scanner.close();
    }

    private static int computeSubtreeSums(TreeNode node) {
        if (node == null) return 0;

        int total = node.value;
        for (TreeNode child : node.children) {
            total += computeSubtreeSums(child);
        }
        node.value = total;
        return total;
    }
}

