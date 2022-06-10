package io.github.mikukko;

public class Question83 {


    /*
     * 83. 删除排序链表中的重复元素
     *
     * 给定一个已排序的链表的头 head ，删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表
     *
     * 输入：head = [1,1,2,3,3]
     * 输出：[1,2,3]
     *
     * 一次遍历
     * 由于给定的链表是排好序的，因此重复的元素在链表中出现的位置是连续的，因此我们只需要对链表进行一次遍历，就可以删除重复的元素。
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
