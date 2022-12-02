package cn.seeyourface.array.spiralMatrix;

/**
 * <p>
 *     给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 *
 *
 * <p>
 * 示例 1：
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * <p>
 * 示例 2：
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * <p>
 * 示例 3：
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 * <p>
 *
 * <p>
 * 提示：
 * <li>1 <= s.length <= 104
 * <li>s 包含英文大小写字母、数字和空格 ' '
 * <li>s 中 至少存在一个 单词
 * <p>
 *
 * 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。
 * </p>
 *
 * @author yangLei
 * @date 2022/12/1 19:22
 */
public class Que_151 {

    // 先将这个字符串翻转，再翻转每一个单词，就能得到预期结果
    // String在java中是不可变数据类型
    static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String reverse = reverse(s);
        String[] split = reverse.split(" ");
        for(int i = 0; i <= split.length - 1; ++i ) {
            sb.append(reverse(split[i]));
            if (i < split.length - 1)
                sb.append(" ");
        }
        return sb.toString();
    }

    // 翻转一个字符串
    static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            // 不打印头尾空格
            if (str.charAt(i) == ' ' && (sb.length() == 0 || i == 0))
                continue;
            // 不连续打印多个空格
            if (sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ' && str.charAt(i) == ' ')
                continue;
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }
}
