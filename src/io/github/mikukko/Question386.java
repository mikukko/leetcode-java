package io.github.mikukko;

import java.util.ArrayList;
import java.util.List;

public class Question386 {


    /**
     * 386. 字典序排数
     * <p>
     * 深度优先搜索(DFS)
     * <p>
     * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
     * <p>
     * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 13
     * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
     * 示例 2：
     * <p>
     * 输入：n = 2
     * 输出：[1,2]
     */
    public List<Integer> lexicalOrder(int n) {

        ArrayList<Integer> list = new ArrayList<>();

        int number = 1;

        for (int i = 0; i < n; i++) {
            list.add(number);
            //深度优先, 在原数上尝试 number*10 一直到大于n 或  (number*10) % 10 = 9 或者 a + 1 > 停止
            //如果number % 10 = 9 或 number + 1 > n 说明末尾的数位已经搜索完成, 返回上一位, 即number = number / 10
            //然后继续判断number是否符合上述条件
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                    number++;
            }
        }

        return list;
    }
}
