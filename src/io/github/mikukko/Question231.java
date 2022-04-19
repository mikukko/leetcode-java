package io.github.mikukko;

public class Question231 {

    /*
     * 231. 2 的幂
     *
     * Brian Kernighan 算法: x & (x - 1) 的应用
     *
     * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
     *
     * 如果存在一个整数 x 使得 n == 2的x次方 ，则认为 n 是 2 的幂次方。
     *
     */
    public boolean isPowerOfTwo(int n) {
        //如果n是2的幂次方，则在二进制表示中只含有一个1，此时用Brian Kernighan算法移除掉最右边的一个1看是否为0 即可判断
        return n > 0 && (n & (n - 1)) == 0;
    }
}
