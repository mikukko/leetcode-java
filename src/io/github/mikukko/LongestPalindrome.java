package io.github.mikukko;

/**
 * @author Mikukko
 * @date 2021/3/11
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = longestPalindrome("aaaaa");
        System.out.println(s);
    }

    /**
     * 5. 最长回文子串
     * <p>
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * <p>
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * <p>
     * 中心扩散
     */
    public static String longestPalindrome(String s) {
        String res = "";
        //字符串长度等于1 和 等于2 单独判断
        if (s.length() == 1) {
            res = s;
        } else if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                res = s;
            } else {
                res = s.substring(0, 1);
            }
        } else {
            for (int i = 1; i < s.length(); i++) {
                int j = i - 1;
                int k = i + 1;
                if (j <= 0 && s.charAt(j) == s.charAt(i)) {
                    res = s.substring(j, i + 1);
                } else if (k <= s.length() - 1 && s.charAt(i) == s.charAt(k)) {
                    res = s.substring(i, k + 1);
                }
                while (j >= 0 && k <= s.length() - 1 && s.charAt(j) == s.charAt(k)) {
                    String substring = s.substring(j, k + 1);
                    res = res.length() > substring.length() ? res : substring;
                    j--;
                    k++;
                }
            }
        }

        return res;
    }
}
