package cn.seeyourface.array.minLength;

/**
 * <p>
 *     给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 *
 *
 * <p>
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 *
 * <p>
 * 提示：
 * <li>1 <= target <= 109
 * <li>1 <= nums.length <= 105
 * <li>1 <= nums[i] <= 105
 * <p>
 *
 * <p>
 * 进阶：
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 * </p>
 *
 * @author yangLei
 * @date 2022/11/30 10:29
 */
public class Que_209 {

    /**
     * code by myself
     */
    static int minSubArrayLen(int target, int[] nums) {
        // 低位
        int lo = 0;
        // 高位
        int hi = 0;
        // 保存窗口数据的结果
        int res = nums[0];
        // 最小窗口长度
        int len = 0;
        while (lo <= hi) {
            if (res < target) {
                hi++;
                // 右指针到头了，窗口内的数据还是小与target，剩下没有比较的必要
                if (hi == nums.length)
                    return len;
                res += nums[hi];
            } else {
                if (len == 0)
                    len = hi - lo + 1;
                len = Math.min(len, (hi - lo) + 1);
                res -= nums[lo];
                lo++;
            }
        }
        return len;
    }

    static int minSubArrayLen2(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; ++j) {
            sum += nums[j];
            while (sum >= target) {
                len = Math.min(len, j - i + 1);
                sum -= nums[i++];
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen2(target, nums));
    }
}
