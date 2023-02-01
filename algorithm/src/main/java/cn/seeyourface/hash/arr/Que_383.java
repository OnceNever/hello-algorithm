package cn.seeyourface.hash.arr;

import java.util.Arrays;

/**
 * <p>
 *     给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * <p>
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * <p>
 * 提示：
 * <li>1 <= ransomNote.length, magazine.length <= 105
 * <li>ransomNote 和 magazine 由小写英文字母组成
 * </p>
 *
 * @author yangLei
 * @date 2023/2/1 14:43
 */
public class Que_383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] records = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            records[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            records[ransomNote.charAt(i) - 'a']--;
        }
        return Arrays.stream(records).noneMatch(re -> re < 0);
    }
}
