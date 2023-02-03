package cn.seeyourface.hash.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *     给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * <li>nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * <li>nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * <li>nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * <li>不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * <li>注意，输出的顺序和三元组的顺序并不重要。</li>
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * <p>
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * <p>
 * 提示：
 * <li>3 <= nums.length <= 3000
 * <li>-105 <= nums[i] <= 105
 * </p>
 *
 * @author yangLei
 * @date 2023/2/2 17:31
 */
public class Que_15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                return res;

            // 去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum < 0) {
                    lo++;
                } else if (sum > 0) {
                    hi--;
                } else {
                    List<Integer> list = Arrays.asList(nums[i], nums[lo], nums[hi]);
                    res.add(list);
                    // 去重
                    while (lo < hi && nums[hi] == nums[hi - 1])
                        hi--;
                    while (lo < hi && nums[lo] == nums[lo + 1])
                        lo++;
                    hi--;
                    lo++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
