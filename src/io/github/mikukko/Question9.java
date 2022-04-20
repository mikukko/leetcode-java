package io.github.mikukko;

public class Question9 {

    /**
     * 9. 回文数
     *
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     *
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 例如，121 是回文，而 123 不是。
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        int n = 0;
        while (n <= s.length() / 2) {
            if (s.charAt(n) != s.charAt(s.length() - n - 1)) {
                return false;
            }
            n++;
        }
        return true;
    }
}
