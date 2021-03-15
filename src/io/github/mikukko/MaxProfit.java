package io.github.mikukko;

/**
 * @author chens
 * @date 2021/3/15
 */
public class MaxProfit {


    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * <p>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * <p>
     * 贪心算法
     */
    public int maxProfit(int[] prices) {

        int total = 0;
        int i = 0;
        while (i < prices.length) {
            //股票下跌情况，如果一直下跌就一直找
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            //找到股票下跌的最小值
            int min = prices[i];
            //判断股票后续是否有涨，找到股票上涨的最大值
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            //找到股票上涨后的最大值,进行抛售
            total += prices[i] - min;
            i++;
        }
        return total;
    }


    public int maxProfit2(int[] prices) {
        int total = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            //只要明天的值比今天大，就把差值累加一下（题目没有限制当天出售就不能再买了，即可以出售完之后当天再次购买）
            if (prices[i + 1] > prices[i]) {
                total += prices[i + 1] - prices[i];
            }
        }
        return total;
    }

}
