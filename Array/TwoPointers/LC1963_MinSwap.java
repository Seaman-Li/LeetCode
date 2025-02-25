package Array.TwoPointers;

public class LC1963_MinSwap {

//    maxImbalance 代表 ) 过多的情况，我们要把这些 ) 交换到正确的位置。
//    每次交换可以让两个 ) 归位，所以答案是 maxImbalance / 2（向上取整）。
//    例如：
//            )))((( 需要 2 次交换变成 (()())。
//            )))(((( 需要 2 次交换变成 ((()))。
    public int minSwaps(String s) {
        int left = 0, right = 0;
        int balance = 0;// 记录左括号和右括号的差值
        int maxImbalance  = 0;// 记录最大的不平衡程度
        for(char ch : s.toCharArray()){
            if(ch == '['){
                balance++;
                left++;
            }else{
                balance--;
                right++;
            }
            maxImbalance  = Math.min(maxImbalance , balance); // 计算最少交换次数
        }
        if(left != right){
            return -1;
        }else{
            return (Math.abs(maxImbalance ) + 1)/2;
        }
    }

    public static void main(String[] args) {

        LC1963_MinSwap solution = new LC1963_MinSwap();
        System.out.println(solution.minSwaps("][]["));
    }
}
