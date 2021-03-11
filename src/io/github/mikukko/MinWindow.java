package io.github.mikukko;

import java.util.HashMap;

/**
 * @author Mikukko
 * @date 2021/3/10
 */
public class MinWindow {
    HashMap<Character, Integer> sMap = new HashMap<>();
    HashMap<Character, Integer> tMap = new HashMap<>();

    public static void main(String[] args) {
        String s = "ADOBECODEBANCABCDD";
        String t = "ABC";
        new MinWindow().minWindow(s, t);

        //System.out.println();
    }

    /**
     * 滑动窗口
     * <p>
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
     * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * <p>
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     */
    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int length = s.length();
        String sub = "";

        while (right < length) {
            //构建滑动窗口
            right++;

            sub = s.substring(left, right);
            for (int i = 0; i < sub.length(); i++) {
                if (sMap.containsKey(sub.charAt(i))) {
                    sMap.put(sub.charAt(i), sMap.get(s.charAt(i)) + 1);
                } else {
                    sMap.put(sub.charAt(i), 0);
                }
            }
            //如果窗口中的元素包含t中的所有元素, 使用哈希表来判断是否包含字符

        }

        return sub;
    }
}