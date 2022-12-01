package cn.seeyourface.array.minLength;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 *
 *
 * <p>
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 *
 * <p>
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * <p>
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 *
 * <p>
 * 提示：
 * <li>1 <= s.length, t.length <= 105
 * <li>s 和 t 由英文字母组成
 * <p>
 *
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 * </p>
 *
 * @author yangLei
 * @date 2022/11/30 10:34
 */
public class Que_76 {

    /**
     * 滑动窗口，使用一个哈希表保存字符串 t 出现的字母种类以及数量
     * 使用另一个哈希表保存窗口移动过程中出现的字符和数量（仅保存在t字符串中的字符数量）
     * 不断比较两个哈希表，符合条件时移动左指针，循环
     *
     * code by myself
     */
    static String minWindow(String s, String t) {
        int lo = 0;
        String res = "";
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        // 保存字符串 t 的字符类型和数量
        for (int i = 0; i < t.length(); ++i) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int hi = 0; hi < s.length(); ++hi) {
            char c = s.charAt(hi);
            if (t.indexOf(c) != -1) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            }
            // 校验两个哈希表的内容
            while (valueCheck(tMap, sMap)) {
                if ("".equals(res)) {
                    res = s.substring(lo, hi + 1);
                } else {
                    res = res.length() <= s.substring(lo, hi + 1).length() ? res : s.substring(lo, hi + 1);
                }
                char r = s.charAt(lo);
                if (t.indexOf(r) != -1) {
                    sMap.put(r, sMap.get(r) - 1);
                }
                lo++;
            }
        }
        return res;
    }

    /**
     * 判断sMap中是否包含tMap中所有的字符，并且数量达到要求
     */
    static boolean valueCheck(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {
        if (tMap.size() != sMap.size())
            return false;
        for (Map.Entry<Character, Integer> e : tMap.entrySet()) {
            Character key = e.getKey();
            if ((int)sMap.get(key) < e.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
