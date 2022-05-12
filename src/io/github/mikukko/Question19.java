package io.github.mikukko;

public class Question19 {


    /**
     * TODO
     * 19. 删除链表的倒数第 N 个结点
     *
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {


        return null;
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
