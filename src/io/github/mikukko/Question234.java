package io.github.mikukko;

import java.util.Stack;

public class Question234 {


    /**
     * 234. 回文链表
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     * <p>
     * 输入：head = [1,2,2,1]
     * 输出：true
     * <p>
     * 输入：head = [1,2]
     * 输出：false
     */
    public boolean isPalindrome(ListNode head) {
        //先遍历链表，求出链表长度len，将前len/2个值入栈stack中，如果len是奇数要跳过一个值，
        //将后len/2个值和stack弹出的值比较，如果有一个值不相同，直接返回false
        int len = 0;
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        temp = head;
        for (int i = 0; i < len / 2; i++) {
            stack.push(temp.val);
            temp = temp.next;
        }
        if (len % 2 != 0) {
            temp = temp.next;
        }
        while (temp != null) {
            if (temp.val != stack.pop()) return false;
            temp = temp.next;
        }
        return true;
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
