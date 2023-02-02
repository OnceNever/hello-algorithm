package cn.seeyourface.hash.arr;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *     编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * 示例 1：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * <li>1^2 + 9^2 = 82
 * <li>8^2 + 2^2 = 68
 * <li>6^2 + 8^2 = 100
 * <li>1^2 + 0^2 + 0^2 = 1</li>
 * <p>
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 * <p>
 * 提示：
 * <li>1 <= n <= 231 - 1
 * </p>
 *
 * @author yangLei
 * @date 2023/2/2 11:05
 * @since 1.0.1
 */
public class Que_202 {

    public boolean isHappy(int n) {
        // 保存计算的结果，如果有重复内容说明会无限循环，需要跳出逻辑
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = sum(n);
        }
        return n == 1;
    }

    private int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

}
