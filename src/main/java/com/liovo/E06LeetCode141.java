package com.liovo;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 直接双指针大法暴力破解
 * @date 2023/4/15
 */
public class E06LeetCode141 {

    public static void main(String[] args) {
        RemoveList.ListNode o7 = new RemoveList.ListNode(7,null);
        RemoveList.ListNode o6 = new RemoveList.ListNode(6,o7);
        RemoveList.ListNode o5 = new RemoveList.ListNode(5,o6);
        RemoveList.ListNode o4 = new RemoveList.ListNode(4,o5);
        RemoveList.ListNode o3 = new RemoveList.ListNode(3,o4);
        RemoveList.ListNode o2 = new RemoveList.ListNode(2,o3);
        RemoveList.ListNode o1 = new RemoveList.ListNode(1,o2);


//        o7.next = o1;
        System.out.println(hasCycle(o1));
    }
    public static boolean hasCycle(RemoveList.ListNode head) {
        RemoveList.ListNode p1 = head;
        RemoveList.ListNode p2 = head;
        while (p2!=null && p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1.val == p2.val){
                return true;
            }
        }
        return false;
    }
}
