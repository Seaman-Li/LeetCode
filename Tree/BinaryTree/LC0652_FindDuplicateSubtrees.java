package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//核心思路：
//序列化子树：
//对每个子树，生成唯一的字符串表示（序列化），用来判断两个子树是否相同。
//格式示例：对于节点值为 1 的子树，序列化结果为 1,2,#,#,3,#,#。

//哈希表记录子树出现次数：
//使用一个 Map<String, Integer> 存储子树序列化的字符串及其出现次数。
//当某个子树序列化第一次出现时，不加入结果。
//当某个子树序列化第二次出现时，将对应的根节点加入结果。

//深度优先搜索（DFS）：
//使用后序遍历（先处理左右子树，再处理当前节点）来序列化子树。
//遍历每个节点，序列化当前子树，记录出现次数。
public class LC0652_FindDuplicateSubtrees {
    private Map<String,Integer> subtreeMap = new HashMap<>();
    private List<BinaryTree.TreeNode> result = new ArrayList<>();

    public List<BinaryTree.TreeNode> findDuplicateSubtrees(BinaryTree.TreeNode root) {
        serialize(root);
        return result;
    }

    private String serialize(BinaryTree.TreeNode node) {
        if (node == null)
            return "#";// 空节点用 "#" 表示
        // 后序遍历：序列化左右子树，再序列化当前节点
        String left = serialize(node.left);
        String right = serialize(node.right);
        String subtree = node.val + "," + left + "," + right;
        // 记录序列化结果出现的次数
        subtreeMap.put(subtree,subtreeMap.getOrDefault(subtree, 0) + 1);
        // 如果子树序列化结果出现两次，加入结果
        if(subtreeMap.get(subtree)==2)
            result.add(node);

        return subtree;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,null,2,4,null,null,4,null,null,null};
        BinaryTree tree = new BinaryTree(nums);
        LC0652_FindDuplicateSubtrees sol = new LC0652_FindDuplicateSubtrees();
        sol.findDuplicateSubtrees(tree.root);
        for(BinaryTree.TreeNode node: sol.result){
           BinaryTree childTree = new BinaryTree();
           childTree.root = node;
           childTree.levelOrderTraversal(childTree.root);
           System.out.println();
        }
    }
}
