package cn.seeyourface.array.removeElement;

import java.util.Arrays;

/**
 * <p>
 *     给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 *
 *
 * <p>
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * <p>
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 *
 * <p>
 * 提示：
 * <li>1 <= nums.length <= 104
 * <li>-104 <= nums[i] <= 104
 * <li>nums 已按 非递减顺序 排序
 * <p>
 *
 * <p>
 * 进阶：
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 * </p>
 *
 * @author yangLei
 * @date 2022/11/29 14:12
 */
public class Que_977 {

    /**
     * 双指针，指向首尾，看作是两个从大到小的数组（取绝对值），比较并不断往新数组尾部放
     */
    static int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int lo = 0, hi = length - 1;
        int[] res = new int[length];
        length = length - 1;
        while (length >= 0) {
            if (abs(nums[lo]) > abs(nums[hi])) {
                res[length--] = nums[lo] * nums[lo];
                lo++;
            } else {
                res[length--] = nums[hi] * nums[hi];
                hi--;
            }
        }
        return res;
    }

    /**
     * 求绝对值
     */
    static int abs(int num) {
        int i = num >> 31;
        return (( num ^ i) - i);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,-1,0,1,3,4,6};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}
