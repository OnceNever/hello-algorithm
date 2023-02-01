package cn.seeyourface.hash.arr;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *     给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * 示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * <p>
 * 提示:
 * <li>1 <= s.length, p.length <= 3 * 104
 * <li>s 和 p 仅包含小写字母
 * </p>
 *
 * @author yangLei
 * @date 2023/2/1 14:55
 */
public class Que_438 {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        String encodeP = encode(p);
        int l = p.length();
        for (int i = 0; i <= s.length() - l; i++) {
            int tail = i + l;
            if (!p.contains(String.valueOf(s.charAt(tail - 1)))) {
                i = tail - 1;
                continue;
            }
            String subStr = s.substring(i, tail);
            if (Objects.equals(encodeP, encode(subStr)))
                list.add(i);
        }
        return list;
    }

    private static String encode(String str) {
        char[] chars = new char[26];
        for (int i = 0; i < str.length(); i++) {
            chars[str.charAt(i) - 'a']++;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p).toString());
    }
}
