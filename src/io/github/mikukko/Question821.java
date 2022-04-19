package io.github.mikukko;

import java.util.ArrayList;
import java.util.Arrays;

public class Question821 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';

        System.out.println(Arrays.toString(new Question821().shortestToChar(s, c)));
    }


    /**
     * 821. 字符的最短距离
     * <p>
     * <p>
     * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
     * <p>
     * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
     * <p>
     * 两个下标i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
     */
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int index = s.indexOf(c);
        int nextIndex = index;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            //在该字符之前位置不变, 当有相同字符, 判断自该下标之后的字符下标, 取相对距离最短的
            if (s.charAt(i) == c) {
                index = i;
                nextIndex = s.indexOf(c, i + 1);
            }
            int abs = Math.min(Math.abs(index - i), Math.abs(nextIndex - i));
            ans[i] = abs;
        }
        return ans;
    }
}

