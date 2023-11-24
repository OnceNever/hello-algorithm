package cn.seeyourface.str.kmp;

/**
 * <p></p>
 *
 * @author yangLei
 * @date 2023/11/24 17:43
 */
public class Kmp2 {

    // Kmp算法
    public static int kmp(String s, String p) {
        int i = 0;
        int j = 0;
        int[] next = getNext(p);
        while (i < s.length() && j < p.length()) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                // 当j为-1时，要移动的是i，当然j也要归0
                i++;
                j++;
            } else {
                // i不需要回溯了
                // i = i - j + 1;
                j = next[j];
            }
        }
        if (j == p.length())
            return i - j;
        else
            return -1;
    }

    // 求出一个字符串的next数组
    private static int[] getNext(String p) {
        // 已知next[j] = k,利用递归的思想求出next[j+1]的值
        // 如果已知next[j] = k,如何求出next[j+1]呢?具体算法如下:
        // 1.如果p[j] = p[k], 则next[j+1] = next[k] + 1;
        // 2.如果p[j] != p[k], 则令k=next[k],如果此时p[j] = p[k],则next[j+1] = k+1,否则继续递归前缀索引k=next[k],而后重复此过程
        int[] next = new int[p.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < p.length() - 1) {
            if (k == -1 || p.charAt(j) == p.charAt(k)) {
                if (p.charAt(++j) == p.charAt(++k))
                    // 当两个字符相等时要跳过
                    next[j] = next[k];
                else
                    next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
