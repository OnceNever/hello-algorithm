package cn.seeyourface.array;

import java.util.Arrays;

/**
 * <p>
 *     给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
 *     请你找出给定目标值在数组中的开始位置和结束位置。
 *     如果数组中不存在目标值 target，返回 [-1, -1]。
 *     你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * </p>
 *
 * <p>
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * </p>
 *
 * <p>
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * </p>
 *
 * <p>
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * </p>
 *
 * <p>
 * 提示：
 * <li>0 <= nums.length <= 105
 * <li>-109 <= nums[i] <= 109
 * <li>nums 是一个非递减数组
 * <li>-109 <= target <= 109
 * </p>
 *
 * @author yangLei
 * @date 2022/11/28 14:12
 */
public class Que_34 {

    static int[] searchRange(int[] nums, int target) {
        int leftBorder = searchLeftBorder(nums, target);
        int rightBorder = searchRightBorder(nums, target);
        if (leftBorder == -2 || rightBorder == -2)
            return new int[]{-1, -1};
        if (rightBorder - leftBorder > 1)
            return new int[]{leftBorder + 1, rightBorder - 1};
        return new int[]{-1, -1};
    }

    // 寻找最左边界 不包括target
    private static int searchLeftBorder(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int leftBorder = -2;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] >= target) {
                hi = mid - 1;
                leftBorder = hi;
            } else {
                lo = mid + 1;
            }
        }
        return leftBorder;
    }

    // 寻找最右边界 不包括target
    private static int searchRightBorder(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int rightBorder = -2;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] <= target) {
                lo = mid + 1;
                rightBorder = lo;
            } else {
                hi = mid - 1;
            }
        }
        return rightBorder;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2};
        int target = 3;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
