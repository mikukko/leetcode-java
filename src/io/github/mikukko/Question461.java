package io.github.mikukko;

public class Question461 {

    /**
     * 461. 汉明距离
     *
     * Brian Kernighan 算法: x & (x - 1) 的应用
     *
     * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
     *
     * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
     *
     *
     * 示例 1：
     *
     * 输入：x = 1, y = 4
     * 输出：2
     * 解释：
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     * 上面的箭头指出了对应二进制位不同的位置。
     * 示例 2：
     *
     * 输入：x = 3, y = 1
     * 输出：1
     *
     */
    public int hammingDistance(int x, int y) {
        //先进行异或操作 相同为0 不同为1, 获得不同位置的1的数量即为结果
        int s = x ^ y ;
        int count = 0;
        //Brian Kernighan 算法: x & (x - 1) 会将二进制下的x最右边一个1变为0
        while(s > 0) {
            s &= (s - 1);
            count++;
        }
        return count;
    }
}
