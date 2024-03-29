package io.github.mikukko;

public class Question237 {


    /**
     * 237. 删除链表中的节点
     * <p>
     * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点head ，只能直接访问 要被删除的节点 。
     * <p>
     * 题目数据保证需要删除的节点 不是末尾节点 。
     * <p>
     * 输入：head = [4,5,1,9], node = 5
     * 输出：[4,1,9]
     * 解释：指定链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9
     */
    public void deleteNode(ListNode node) {
        //把要删除的节点 转为它指向的下一个节点 让两个节点成为一个相同的节点
        //先把当前节点修改为下一个节点, 再删除下一个节点
        //既然不能先删除自己，那就把自己整容成儿子，再假装自己就是儿子来养活孙子
        node.val = node.next.val;
        node.next = node.next.next;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
