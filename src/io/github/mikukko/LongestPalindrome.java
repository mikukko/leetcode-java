package io.github.mikukko;

/**
 * @author Mikukko
 * @date 2021/3/11
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = longestPalindrome3("bb");
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
     * 动态规划  中心扩散
     */
    public static String longestPalindrome(String s) {
        //暴力解法 O(N^3)
        int length = s.length();
        if (length < 2) {
            return s;
        }

        char[] charArray = s.toCharArray();
        int maxLen = 1;
        //指针记录上次最长回文串时 i的位置
        int begin = 0;
        //注意i和j的临界值，i最大为倒数第二个字符下标(length-2)，j:（i+1）为最后一个字符下标(length-1)
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (j - i + 1 > maxLen && valid(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    /**
     * 验证是否为回文串的算法，S[left, right]
     */
    public static boolean valid(char[] charArray, int left, int right) {
        while (left < right) {
            //左边界和右边界同时缩进，abcba ，判断去掉两个a后同时向中心缩进，判断子串是否相等，全部相等后即为回文串
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

    /**
     * 动态规划 + 填表法
     * 时间复杂度 O(N^2)
     * <p>
     * 状态转移方程：dp[i][j] = (S[i] == S[j]) and (dp[i+1][j-1])
     */
    public static String longestPalindrome2(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int maxLen = 1;
        //指针记录上次最长回文串时 i的位置
        int begin = 0;

        char[] charArray = s.toCharArray();

        boolean[][] dp = new boolean[length][length];
        //将对角线单个字符的回文状态设为true
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        //重点 循环方向 保证偏左下角元素的状态优先计算出来，右上角的状态要参考左下角的状态
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else if (j - i < 3) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }

                //如果当前状态为回文子串，并且回文子串长度更长
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }

            }
        }

        return s.substring(begin, begin + maxLen);

    }

    /**
     * 中心扩散 O(N^2)
     */
    public static String longestPalindrome3(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }

        int maxLen = 0;
        int start = 0, end = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < length; i++) {
            //如果回文中心为一个字符
            int len1 = getLength(charArray, i, i);
            //如果回文中心为两个字符
            int len2 = getLength(charArray, i, i + 1);

            maxLen = Math.max(len1, len2);
            //如果最大回文串长度更新，则通过当前回文串长度和i的值计算出此时要截取的start和end的值
            if (maxLen > end - start) {
                end = i + maxLen / 2;
                start = end + 1 - maxLen;
            }
        }
        return s.substring(start, end + 1);

    }

    public static int getLength(char[] charArray, int left, int right) {
        while (left > -1 && right < charArray.length && charArray[left] == charArray[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }


}
