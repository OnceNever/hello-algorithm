package cn.seeyourface.str.kmp;

/**
 * <p></p>
 *
 * @author yangLei
 * @date 2023/11/24 17:15
 */
public class Kmp {

    private final String pat;
    // dp数组的含义为：当前状态遇到什么字符需要跳转到的状态
    private final int[][] dp;

    public Kmp(String pat) {
        this.pat = pat;
        int m = pat.length();
        // ascII码的字符范围
        dp = new int[m][256];
        // 第1个字符为模式串的第一个字符状态才转为1
        dp[0][pat.charAt(0)] = 1;
        int x = 0;
        for (int j = 1; j < m; j++) {
            for (int c = 0; c < 256; c++) {
                if (c == pat.charAt(j))
                    // 满足字符状态加一
                    dp[j][c] = j + 1;
                else
                    // 不满足则跳转到之前的状态
                    dp[j][c] = dp[x][c];
            }
            x = dp[j][pat.charAt(j)];
        }
    }

    public int search(String txt) {
        int m = pat.length();
        int n = txt.length();
        int j = 0;
        for (int i = 0; i < n; i++) {
            j = dp[j][txt.charAt(i)];
            if (j == m)
                return i - m + 1;
        }
        return -1;
    }
}
