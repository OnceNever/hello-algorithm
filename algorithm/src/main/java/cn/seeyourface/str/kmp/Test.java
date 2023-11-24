package cn.seeyourface.str.kmp;

import cn.seeyourface.str.kmp.Kmp;

/**
 * <p></p>
 *
 * @author yangLei
 * @date 2023/11/24 17:33
 */
public class Test {

    public static void main(String[] args) {
        String pat = "ABABC";
        String txt = "bfjhavcjasbvsjdcAsjcbcavABABCsdhask";
        Kmp kmp = new Kmp(pat);
        System.out.println(kmp.search(txt));
        System.out.println(Kmp2.kmp(txt, pat));
    }
}
