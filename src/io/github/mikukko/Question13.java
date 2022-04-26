package io.github.mikukko;

import java.util.HashMap;

public class Question13 {
    //匿名内部类的声明方式
    //第一层括弧实际是定义了一个匿名内部类 (Anonymous Inner Class)，
    //第二层括弧实际上是一个实例初始化块 (instance initializer block)，这个块在内部匿名类构造时被执行。
     HashMap<Character, Integer> map = new HashMap<Character, Integer>(){{
         put('I', 1);
         put('V', 5);
         put('X', 10);
         put('L', 50);
         put('C', 100);
         put('D', 500);
         put('M', 1000);
    }};

    public static void main(String[] args) {

        String s = "MCMXCIV";

        System.out.println(new Question13().romanToInt(s));
    }

    /*
     * 13. 罗马数字转整数
     *
     * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。
     * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。
     * 这个特殊的规则只适用于以下六种情况：
     *
     * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
     * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
     * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
     * 给定一个罗马数字，将其转换成整数。
     */
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer cValue = map.get(c);
            if (i + 1 < s.length()) {
                char next = s.charAt(i + 1);
                //如果c小于了next的值, 则减去c的值, 否则加上c的值
                Integer nextValue = map.get(next);
                if (cValue < nextValue) {
                    sum -= cValue;
                } else {
                    sum += cValue;
                }
            } else {
                sum += cValue;
            }
        }
        return sum;
    }
}
