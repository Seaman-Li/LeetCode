package Array;

public class LC0006_ZigzagConversion {

//    模拟 Z 字形排列
//    从上往下存入数组，到底部后向上折返，如此往复。
//    使用 StringBuilder[] rows 存储每一行的数据。
//    遍历字符串 s：
//    向下移动（row++）
//    到底后向上折返（row--）
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            rows[i] = new StringBuilder(); // 初始化每一行
        }

        int index = 0, direction = -1;// index 记录当前行，direction 控制方向
        for(char c : s.toCharArray()){
            rows[index].append(c);
            // 方向控制（到底时向上，最上时向下）
            if (index == 0 || index == numRows - 1)
                direction *= -1;
            index += direction;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows){
            res.append(row);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        LC0006_ZigzagConversion solution = new LC0006_ZigzagConversion();
        System.out.println(solution.convert(s, numRows));
    }
}
