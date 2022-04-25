package io.github.mikukko;

public class Question11 {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Question11().maxArea(height));
    }

    /*
     * 11. 盛最多水的容器
     *
     * 双指针
     *
     * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
     *
     * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
     *
     * 返回容器可以储存的最大水量。
     *
     * 说明：你不能倾斜容器。
     *
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
     *
     */
    public int maxArea(int[] height) {
        //针对 (x, num[x]), (y, num[y])
        //满足 max((y - x) * min(num[x], num[y]))
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int max = 0;
        //左右指针指向边界两边
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            //左指针右移一位或右指针左移一位
            //最大面积 = 两个指针指向的数字中较小值 ∗ 指针之间的距离
            //底都减小了1 要保证面积尽量大, 需要保证移动后的较小值尽量高, 即移动高度相对较小的那一边, 留下相对较高的边
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return max;
    }
}
