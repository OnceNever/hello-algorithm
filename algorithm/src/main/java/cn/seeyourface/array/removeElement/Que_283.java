package cn.seeyourface.array.removeElement;

import java.util.Arrays;

/**
 * <p>
 *     给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 *     请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * <p>
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 *
 * <p>
 * 提示:
 * <li>1 <= nums.length <= 104
 * <li>-231 <= nums[i] <= 231 - 1
 * <p>
 *
 * 进阶：你能尽量减少完成的操作次数吗？
 * </p>
 *
 * @author yangLei
 * @date 2022/11/29 11:52
 */
public class Que_283 {

    static void moveZeros(int[] nums) {
        int lo = 0, hi = 0;
        while (hi < nums.length - 1) {
            hi++;
            if (nums[hi] != 0 && nums[lo] == 0) {
                nums[lo] = nums[hi];
                nums[hi] = 0;
                lo++;
            } else if (nums[lo] != 0) {
                lo++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1};
        moveZeros(nums);
    }
}
