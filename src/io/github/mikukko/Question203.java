package io.github.mikukko;

public class Question203 {


    /**
     * 203. 移除链表元素
     * <p>
     * 给你一个链表的头节点 head 和一个整数 val ，
     * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     * <p>
     * <p>
     * 输入：head = [1,2,6,3,4,5,6], val = 6
     * 输出：[1,2,3,4,5]
     * <p>
     * 迭代/递归
     */
    public ListNode removeElements(ListNode head, int val) {
        //迭代法
        //创建哑节点 适用于头结点需要删除的情况
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode temp = node;

        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return node.next;
    }

    /**
     * 链表的定义具有递归的性质，因此链表题目常可以用递归的方法求解。
     * <p>
     * 对于给定的链表，首先对除了头节点 head 以外的节点进行删除操作，然后判断 head 的节点值是否等于给定的 val。
     * 如果 head 的节点值等于 val，则 head 需要被删除，因此删除操作后的头节点为 head.next；
     * 如果 head 的节点值不等于 val，则 head 保留，因此删除操作后的头节点还是 head。
     * 上述过程是一个递归的过程。
     */
    public ListNode removeElements2(ListNode head, int val) {
        //递归法
        if (head == null) {
            return null;
        }
        head.next = removeElements2(head.next, val);
        if (head.val == val) {
            head = head.next;
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
