package io.github.mikukko;

/**
 * @author Mikukko
 * @date 2021/3/11
 */
public class Question4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double v = new Question4().findMedianSortedArrays(nums1, nums2);
        System.out.println(v);
    }


    /**
     * 4. 寻找两个正序数组的中位数
     * <p>
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     * 请你找出并返回这两个正序数组的 中位数 。
     * <p>
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //数组按序合并  归并排序 O(m+n)
        //同时遍历nums1 和 nums2，如果nums1[i]的值小于nums2[j]的值，将nums1[i]的值存到total[k]中
        //然后i++，k++，反之则存nums2[j]的值，j++，k++
        //当nums1的元素转移完毕，则只转移剩余的nums2的元素
        //反之转移nums1的元素
        int[] total;
        int n1Len = nums1.length;
        int n2Len = nums2.length;
        int len = n1Len + n2Len;
        total = new int[len];
        double res;
        int n1 = 0;
        int n2 = 0;
        int index = 0;
        while (n1 < n1Len || n2 < n2Len) {
            if (n1 < n1Len && n2 < n2Len) {
                if (nums1[n1] < nums2[n2]) {
                    total[index++] = nums1[n1++];
                } else {
                    total[index++] = nums2[n2++];
                }
            } else if (n1 == n1Len) {
                total[index++] = nums2[n2++];
            } else {
                total[index++] = nums1[n1++];
            }
        }

        if (len % 2 == 0) {
            double sum = (total[len / 2] + total[len / 2 - 1]);
            res = sum / 2;
        } else {
            res = total[len / 2];
        }

        return res;
    }
}
