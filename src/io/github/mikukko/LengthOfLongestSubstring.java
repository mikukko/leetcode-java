package io.github.mikukko;

import java.util.HashMap;

/**
 * 滑动窗口题目
 *
 * 3. 无重复字符的最长子串
 * 30. 串联所有单词的子串
 * 76. 最小覆盖子串
 * 159. 至多包含两个不同字符的最长子串
 * 209. 长度最小的子数组
 * 239. 滑动窗口最大值
 * 567. 字符串的排列
 * 632. 最小区间
 * 727. 最小窗口子序列
 *
 * @author Mikukko
 * @date 2021/3/10
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring length = new LengthOfLongestSubstring();

        System.out.println(length.lengthOfLongestSubstring("cdd"));
        System.out.println(length.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(length.lengthOfLongestSubstring("pwwkew"));
        System.out.println(length.lengthOfLongestSubstring(""));
        System.out.println(length.lengthOfLongestSubstring(" "));
        System.out.println(length.lengthOfLongestSubstring("abb"));
        System.out.println(length.lengthOfLongestSubstring("abba"));
        System.out.println(length.lengthOfLongestSubstring("dvdf"));
    }

    /**
     * 滑动窗口
     * <p>
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 0123
     * 输入: s = "abcabcbb"  "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        //左侧窗口边界
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //如果窗口中包含重复元素，将左侧窗口边界移动到上个字符出现位置+1处, 并且窗口往后移动之后不再往前移动，因此取窗口边界下标最大值
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            //如有重复元素，覆盖重复元素下标
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
    
}
