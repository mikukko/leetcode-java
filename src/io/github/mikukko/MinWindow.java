package io.github.mikukko;

/**
 * @author Mikukko
 * @date 2021/3/10
 */
public class MinWindow {
    public static void main(String[] args) {

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
        int left = 0, right = 0;
        int max = 0;
        int count = t.length();
        for (int i = 0; ; ) {
            if (left == count - 1) {
                break;
            }
            if (count <= 0) {
                max = Math.max(max, right - left + 1);
                left += 1;
                count = t.length();
            }
            String s1 = String.valueOf(s.charAt(i));

            if (t.contains(s1)) {
                t = t.replaceAll(s1, "");
            }
            right += 1;
        }

        return "";
    }
}
