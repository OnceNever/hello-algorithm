package cn.seeyourface.array.binarySearch;

/**
 * <p>
 *     给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * <p>
 *
 *
 * <p>
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 * <p>
 *
 * <p>
 * 提示：
 * <li>1 <= num <= 2^31 - 1
 * </p>
 *
 * @author yangLei
 * @date 2022/11/28 18:40
 */
public class Que_367 {

    static boolean isPerfectSquare (int num) {
        if (num == 0 || num == 1)
            return true;
        int lo = 0;
        int hi = num >> 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if ((long)mid * mid > num) {
                hi = mid - 1;
            } else if ((long)mid * mid < num) {
                lo = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }
}
