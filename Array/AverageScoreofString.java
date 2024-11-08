package Array;

import java.util.*;

public class AverageScoreofString {

    // 定义选手类来存储选手编号及其最终评分和字母
    class Player {
        int id;
        double score;
        char letterScore;  // 对应的字母评分

        Player(int id, double score, char letterScore) {
            this.id = id;
            this.score = score;
            this.letterScore = letterScore;
        }
    }

    public static void main(String[] args) {
        AverageScoreofString main = new AverageScoreofString();  // 创建外部类实例
        Scanner sc = new Scanner(System.in);

        // 输入评委数量和选手数量
        int n = sc.nextInt(); // 评委数量
        int m = sc.nextInt(); // 选手数量

        // 输入评委对每个选手的评分串
        String[] ratings = new String[n];  // 存储每个评委的评分串
        for (int i = 0; i < n; i++) {
            ratings[i] = sc.next();  // 每个字符串长度为m，对应m个选手的评分
        }

        // 存储每个选手的评分
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int[] scores = new int[n];

            // 将每个评委对第i个选手的评分转为数字
            for (int j = 0; j < n; j++) {
                char ch = ratings[j].charAt(i);
                if (Character.isUpperCase(ch)) {
                    ch = Character.toLowerCase(ch);  // 将大写字母转为小写
                }
                scores[j] = 25 - (ch - 'a');  // 修改：将字母转为对应的数字评分 (a=25, z=0)
            }

            // 计算平均分，去掉最高分和最低分
            Arrays.sort(scores);  // 排序
            double sum = 0;
            for (int j = 1; j < n - 1; j++) {
                sum += scores[j];  // 去掉最高和最低
            }
            double avg = (sum / (n - 2));

            // 将平均分转换为字母评分
            char letterScore = (char) ('a' + (25 - (int)avg));  // 分数转字母(a最高,z最低)

            // 保存选手编号、平均分和字母评分
            players.add(main.new Player(i + 1, avg, letterScore));  // 使用外部类的实例创建Player对象
        }

        // 对选手按照分数降序排序，分数相同则按选手编号升序
        players.sort((a, b) -> {
            if (b.score == a.score) {
                return a.id - b.id; // 分数相同按编号升序
            } else {
                return Double.compare(b.score, a.score); // 分数降序
            }
        });

        // 输出排序后的选手编号
        for (Player player : players) {
            System.out.print(player.id + " ");
        }
        System.out.println();

        // 输出每个选手的字母评分
        for (Player player : players) {
            System.out.print(player.letterScore + " ");
        }
        System.out.println();
    }
}
