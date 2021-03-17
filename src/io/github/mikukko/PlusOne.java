package io.github.mikukko;

/**
 * @author chens
 * @date 2021/3/17
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9};
        digits = new PlusOne().plusOne(digits);
        for (int digit : digits) {
            System.out.println(digit);
        }
    }

    /**
     * 66. 加一
     * <p>
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     * 输入：digits = [1,2,3]
     * 输出：[1,2,4]
     * 解释：输入数组表示数字 123。
     */
    public int[] plusOne(int[] digits) {

        //从最后一位，表示个位的数字开始计算
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                int plusOne = digits[i] + 1;
                carry = plusOne / 10;
                digits[i] = plusOne % 10;
            } else {
                int plus = digits[i] + carry;
                digits[i] = plus % 10;
                carry = plus / 10;
            }

        }
        //如果最后需要进位，则其余位全为0
        if (carry == 1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
