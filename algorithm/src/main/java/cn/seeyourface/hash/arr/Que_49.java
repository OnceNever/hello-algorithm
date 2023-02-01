package cn.seeyourface.hash.arr;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 *     给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * <p>
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * <p>
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * <p>
 * 提示：
 * <li>1 <= strs.length <= 104
 * <li>0 <= strs[i].length <= 100
 * <li>strs[i] 仅包含小写字母
 * </p>
 *
 * @author yangLei
 * @date 2023/2/1 11:20
 * @since 1.0.1
 */
public class Que_49 {

    // 哈希表对排序后的字符串做hash
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            //String s = sortedStr(str);
            String s = encode(str);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s, list);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * method1 对字符串的字母进行排序 效率不高
     */
    private String sortedStr(String str) {
        return str.chars().mapToObj(a -> (char)a).sorted().map(Object::toString)
                .collect(Collectors.joining(""));
    }

    /**
     * method2 对字符串进行编码 效率高
     */
    private String encode(String str) {
        char[] count = new char[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return new String(count);
    }
}
