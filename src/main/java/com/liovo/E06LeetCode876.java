package com.liovo;

/**
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 * @date 2023/4/13
 */
public class E06LeetCode876 {
    public static void main(String[] args) {
        RemoveList.ListNode o6 = new RemoveList.ListNode(6,null);
        RemoveList.ListNode o5 = new RemoveList.ListNode(5,o6);
        RemoveList.ListNode o4 = new RemoveList.ListNode(4,o5);
        RemoveList.ListNode o3 = new RemoveList.ListNode(3,o4);
        RemoveList.ListNode o2 = new RemoveList.ListNode(2,o3);
        RemoveList.ListNode o1 = new RemoveList.ListNode(1,o2);

        E06LeetCode876 leetCode876 = new E06LeetCode876();
        System.out.println(leetCode876.middleNode(o1));
    }

    /**
     *  直观法： 直接加数组遍历
     *  快慢指针法 p1每走一步，p2走两步
     * @param head
     * @return
     */
    private RemoveList.ListNode middleNode(RemoveList.ListNode head) {
        if (head == null || head.next == null) return head;
        RemoveList.ListNode p1 = head;
        RemoveList.ListNode p2 = head;
        while (p2 != null && p2 != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

}
