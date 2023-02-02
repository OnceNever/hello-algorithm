package cn.seeyourface.hash.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * <p>
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * <p>
 * 解释：
 * 两个元组如下：
 * <li>1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * <li>2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * <p>
 * 示例 2：
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 * <p>
 * 提示：
 * <li>n == nums1.length
 * <li>n == nums2.length
 * <li>n == nums3.length
 * <li>n == nums4.length
 * <li>1 <= n <= 200
 * <li>-2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28
 * </p>
 *
 * @author yangLei
 * @date 2023/2/2 14:47
 */
public class Que_454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        // key为nums1,nums2元素之和，value为两元素之和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer n1 : nums1) {
            for (Integer n2 : nums2) {
                int key = n1 + n2;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        for (Integer n3 : nums3) {
            for (Integer n4 : nums4) {
                int key = n3 + n4;
                if (map.containsKey(-key)) {
                    res += map.get(-key);
                }
            }
        }
        return res;
    }
}
