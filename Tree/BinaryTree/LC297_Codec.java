package Tree.BinaryTree;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC297_Codec {

//    序列化
//    使用 前序遍历（先根节点，再左子树，最后右子树）将二叉树转化为字符串：
//    遇到非空节点时，添加节点值。
//    遇到 null 节点时，添加 "null"。
//    每个节点用分隔符（如逗号 ,）隔开。
    public String serialize(BinaryTree.TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(BinaryTree.TreeNode node, StringBuilder sb) {
        if(node == null){
            sb.append("null").append(",");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

//    反序列化
//    通过前序遍历的顺序，递归地重建二叉树：
//    使用一个指针指向当前节点。
//    遇到 "null" 时，返回 null 节点。
//    遇到非空值时，创建一个节点并递归构造其左右子树。
    public BinaryTree.TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        return deserializeHelper(queue);
    }

    private BinaryTree.TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();
        if(val.equals("null")){
            return null;
        }
        BinaryTree.TreeNode node = new BinaryTree.TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }

    public static void main(String[] args) {
        LC297_Codec codec = new LC297_Codec();
        String s ="1,2,null,null,3,4,null,null,5,null,null,";
        BinaryTree tree = new BinaryTree(codec.deserialize(s)) ;
        tree.preorderTraversal(tree.root);
        System.out.println();
        System.out.println(codec.serialize(tree.root));
    }

}
