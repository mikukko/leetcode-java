package io.github.mikukko;

/**
 * @author Mikukko
 * @date 2021/3/9
 */
public class AddTwoNumbers {
    /**
     * 输入：l1 = [2,4,3], l2 = [5,6,2]
     * 输出：[7,0,8]
     * 解释：342 + 265 = 607.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

            int sum = l1Val + l2Val + carry;

            //链表节点的指向需要看 是否为同一块内存区域
            //第一次 tail指向head，head指向新开辟的节点内存块
            //然后变更指向，tail.next(此时tail指向head，即head.next) 指向 新节点
            //第二次，tail再指向新节点，此时head.next 和 tail指向了同一块内存区域，即 tail指向了head.next
            //或者让tail指向tail.next, 变更游标位置，此时tail指向head.next
            //第三次，tail(此时是最初head的，head.next) 的next，即head.next.next 指向新节点，tail再指向tail.next，用以下次指向迭代

            ListNode sumCode = new ListNode(sum % 10);
            if (head == null) {
                tail = head = sumCode;
            } else {
                tail.next = sumCode;
                tail = tail.next;
            }

            carry = sum / 10;
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    /**
     * 另一种简化算法
     */
    public ListNode addTwo(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode cursor  = root;
        int temp = 0;
        while (l1 != null || l2 != null || temp != 0) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

            int sum = l1Val + l2Val + temp;
            temp = sum / 10;
            cursor.next = new ListNode(sum % 10);
            cursor = cursor.next;

        }
        return root.next;
    }




    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
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
