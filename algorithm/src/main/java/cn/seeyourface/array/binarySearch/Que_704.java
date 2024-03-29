package cn.seeyourface.array.binarySearch;

/**
 * <p>
 *   给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，
 *   写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 *   示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * 提示：
 * <p>
 * 你可以假设 nums中的所有元素是不重复的。
 * n将在[1, 10000]之间。
 * nums的每个元素都将在[-9999, 9999]之间。
 *
 * </p>
 *
 * @author yangLei
 * @date 2022/11/28 9:41
 */
public class Que_704 {

    /**
     * 区间左闭右闭的写法 []
     */
    static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 区间左闭右开的写法 [) 三个地方不同
     */
    static int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // diff
        while (left < right) { // diff
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // diff
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 0;
        int res = search(nums, target);
        System.out.println(res);
    }
}
