package cn.seeyourface.array.binarySearch;

/**
 * <p>
 *     给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 *
 *
 * <p>
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * <p>
 *
 * <p>
 * 提示：
 * 0 <= x <= 2^31 - 1
 * </p>
 *
 * @author yangLei
 * @date 2022/11/28 16:07
 */
public class Que_69 {

    static int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int lo = 0;
        int hi = (x >> 1);
        int res = 0;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if ((long)mid * mid > x) {
                hi = mid - 1;
            } else {
                res = mid;
                lo = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.printf(mySqrt(4) + "");
    }
}
