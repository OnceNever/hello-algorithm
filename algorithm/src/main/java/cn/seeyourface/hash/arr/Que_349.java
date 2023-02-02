package cn.seeyourface.hash.arr;

import java.util.*;

/**
 * <p>
 *     给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 * <p>
 * 提示：
 * <li>1 <= nums1.length, nums2.length <= 1000
 * <li>0 <= nums1[i], nums2[i] <= 1000
 * </p>
 *
 * @author yangLei
 * @date 2023/2/2 9:51
 */
public class Que_349 {

    // method1 散列表
    public int[] intersection(int[] nums1, int[] nums2) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int j : nums1) {
            map.putIfAbsent(j, 1);
        }
        for (int j : nums2) {
            if (map.containsKey(j)) {
                map.put(j, 2);
            }
        }
        map.entrySet().removeIf(next -> next.getValue() == 1);
        return map.keySet().stream().mapToInt(Integer::intValue).toArray();
    }

    // method2 数组 set
    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];
        Set<Integer> result = new HashSet<>();
        int[] nums = new int[1000];
        for (int j : nums1) {
            nums[j] = 1;
        }
        for(int i : nums2) {
            if (nums[i] == 1)
                result.add(i);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
    }
}
