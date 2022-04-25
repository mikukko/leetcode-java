package io.github.mikukko;

public class Question14 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new Question14().longestCommonPrefix(strs));
    }

    /*
     * 14. 最长公共前缀
     *
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1：
     *
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     *
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     *
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str = strs[0];
        //纵向扫描 比较每个字符串的每列下标字符是否相同, 如相同继续比较下一列, 如不相同返回其上次相同列子字符串
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            for (String si : strs) {
                if (si.length() < i + 1 || si.charAt(i) != charAt) {
                    return str.substring(0, i);
                }
            }
        }

        return str;
    }
}
