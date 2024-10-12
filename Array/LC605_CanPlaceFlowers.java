package Array;

public class LC605_CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowers = new int[]{1,0,0,0,1};
        int n = 2;
        System.out.println(canPlaceFlowers(flowers, n));
    }

//检查连续的三个零：连续的三个 0 表示可以在中间种一朵花。如果是花坛的边缘，即开始或结束处，只需要两个连续的 0（因为边缘没有相邻的位置）。
//遍历数组：从左到右遍历数组，根据上述规则检查可以种花的位置。
//更新数组状态：每当判断一个位置可以种花时，将该位置从 0 更新为 1，并减少 n 的计数。
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                if (prev == 0 && next == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }

}
