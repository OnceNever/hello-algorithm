package cn.seeyourface.array.removeElement;

/**
 * <p>
 *     给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 *
 *
 * <p>
 * 示例 1：
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * <p>
 * 示例 2：
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * <p>
 * 示例 3：
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 * <p>
 *
 * <p>
 * 提示：
 * <li>1 <= s.length, t.length <= 200
 * <li>s 和 t 只含有小写字母以及字符 '#'
 * <p>
 *
 * <p>
 * 进阶：
 * 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 * </p>
 *
 * @author yangLei
 * @date 2022/11/29 14:12
 */
public class Que_844 {

    // 方法一 start
    static boolean replaceStr(String str1, String str2) {
        return backspace(str1).equals(backspace(str2));
    }

    static String backspace(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '#') {
                count++;
                continue;
            }
            if (count != 0) {
                count--;
                continue;
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    // 方法一 end

    // 进阶 双指针 start
    static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipI = 0;
        int skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipI++;
                    i--;
                } else if (skipI > 0) {
                    skipI--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                // 字符不一致
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                // 一个字符串已经遍历完，一个没有遍历完
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
    // 进阶 双指针 end

    public static void main(String[] args) {
        System.out.println(backspaceCompare("xywrrmp", "xywrrmu#p"));
    }
}
