package cn.seeyourface.array;

/**
 * <p>
 *     给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 *
 *
 * <p>
 *     示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * <p>
 *     示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 *     示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 *
 * 提示:
 * <p>
 * <li>1 <= nums.length <= 104
 * <li>-104 <= nums[i] <= 104
 * <li>nums 为 无重复元素 的 升序 排列数组
 * <li>-104 <= target <= 104
 * </p>
 *
 * @author yangLei
 * @date 2022/11/28 11:02
 */
public class Que_35 {

    static int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 4;
        System.out.println(searchInsert(nums, target));
    }
}
