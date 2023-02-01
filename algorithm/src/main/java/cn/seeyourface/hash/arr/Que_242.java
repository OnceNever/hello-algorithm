package cn.seeyourface.hash.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 提示:
 * <li>1 <= s.length, t.length <= 5 * 104
 * <li>s 和 t 仅包含小写字母
 * <p>
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author yangLei
 * @date 2023/2/1 10:31
 */
public class Que_242 {

    // method1 哈希表
    public boolean isAnagram(String s, String t) {
        final Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            if (!map.containsKey(key))
                return false;
            map.put(key, map.get(key) - 1);
            // 减到0将key移除
            if (map.get(key) == 0)
                map.remove(key);
        }
        // 最终是否为空
        return map.isEmpty();
    }

    // method2 使用数组记录字符出现的数量
    public boolean isAnagram2(String s, String t) {
        int[] records = new int[26];

        for (int i = 0; i < s.length(); i++) {
            records[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++){
            records[t.charAt(i) - 'a']--;
        }

        // 判断数组中的元素是否都为0
        for (int record : records) {
            if (record != 0)
                return false;
        }
        return true;
    }

}
