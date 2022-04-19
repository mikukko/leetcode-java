package io.github.mikukko;

public class Question201 {
    public static void main(String[] args) {

        System.out.println(new Question201().rangeBitwiseAnd(5, 7));
    }

    /*
     * 201. 数字范围按位与
     *
     * Brian Kernighan 算法: x & (x - 1) 的应用
     *
     * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
     *
     * 示例 1：
     *
     * 输入：left = 5, right = 7
     * 输出：4
     * 示例 2：
     *
     * 输入：left = 0, right = 0
     * 输出：0
     * 示例 3：
     *
     * 输入：left = 1, right = 2147483647
     * 输出：0
     */
    public int rangeBitwiseAnd(int left, int right) {

        //对所有数字执行按位与运算的结果是所有对应二进制字符串的公共前缀再用零补上后面的剩余位。
        //9:       0 0 0 0 1 0 0 1
        //10:      0 0 0 0 1 0 1 0
        //11:      0 0 0 0 1 0 1 1
        //12:      0 0 0 0 1 1 0 0
        //公共前缀：0 0 0 0 1

        //即求按位与的结果即是求公共前缀的值（后面每个数位置有为0的，按位与后的结果也为0）
        //其思想是，对于给定的范围 [m, n]（m < n），我们可以对数字 n 迭代地应用Brian Kernighan 算法，
        //清除最右边的 1，直到它小于或等于 m，此时非公共前缀部分的 1 均被消去。因此最后我们返回 n 即可。

        while (left < right) {
            right &= (right - 1);
        }

        return right;
    }
}
