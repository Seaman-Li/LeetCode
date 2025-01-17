package Map.Backtracking;

//回溯法
//定义：回溯法是一种试探性算法，尝试所有可能的解，探索解空间的每一种情况。如果某种尝试无法得到有效结果，则回溯到上一步，继续尝试其他可能。
//特点：
//探索目标：回溯法通常用于 求解组合问题，例如全排列、子集、路径搜索等。
//递归与撤销操作：
//类似于 DFS 的递归，但回溯法有明确的“撤销”操作，返回上一步状态以尝试其他选择。
//适用场景：
//全排列问题。
//组合问题。
//分割问题（如本题的 IP 地址恢复）。

import java.util.ArrayList;
import java.util.List;

public class LC093_RestoreIP {

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 0 || s.length() > 12)// 剪枝：IP 地址长度必须在 4 到 12 之间
            return res;
        backtrack(res, s, 0, new ArrayList<>());
        return res;
    }

    private static void backtrack(List<String> result, String s, int start, List<String> current){
        // 如果当前组合已分成四段
        if (current.size() == 4) {
            // 检查是否用完所有字符
            if (start == s.length()) {//检查是否已经分割完字符串，意味着回溯到达了叶子节点。如果分割完成，将结果保存到最终答案中。
                result.add(String.join(".", current));//用string.join把4个片段连起来，形成完整的 IP 地址格式
            }
            return;
        }
        // 尝试分割长度为 1 到 3 的每一段
        for(int len = 1; len <= 3; len++){
            if(start + len > s.length()) // 剪枝：剩余长度不足
                break;
            String segment = s.substring(start, start + len);
            if(isValid(segment)){
                current.add(segment);// 选择当前段
                backtrack(result, s, start + len, current);// 递归处理下一段
                current.remove(current.size() - 1);// 回溯，撤销选择
            }
        }
    }

    // 判断字符串是否是合法的 IP 段 （当长度>1时每段不能以0开头，每段范围 0 <= IP <= 255 ）
    private static boolean isValid(String segment){
        if(segment.length()>1 && segment.charAt(0)=='0') return false;
        int val = Integer.parseInt(segment);
        return val >= 0 && val <= 255;
    }

    public static void main(String[] args) {
        String ip =  "25525511135";
        System.out.println(restoreIpAddresses(ip));
    }
}
