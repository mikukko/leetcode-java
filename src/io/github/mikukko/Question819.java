package io.github.mikukko;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Question819 {

    public static void main(String[] args) {

        String s = "Bob. hIt, baLl";
        String[] ban = {"bob", "hit"};
        System.out.println(new Question819().mostCommonWord(s, ban));
    }


    /**
     * 819. 最常见的单词
     * <p>
     * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
     * <p>
     * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
     * <p>
     * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.isEmpty()) {
            return "";
        }

        Map<String, Integer> map = new HashMap<>();
        //此处可以用isLetter()方法区分是否字母
        paragraph = paragraph.replaceAll("[!,?';.]", " ");

        String[] strings = paragraph.split(" ");

        List<String> banList = Arrays.asList(banned);
        for (String string : strings) {
            if (Objects.equals(string, "")) {
                continue;
            }
            string = string.toLowerCase();
            if (banList.contains(string)) {
                continue;
            }
            map.put(string, map.getOrDefault(string, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(((o1, o2) -> (o2.getValue()) - o1.getValue()));

        return list.get(0).getKey();
    }
}
