package com.liovo;

import java.util.List;

/**
 * 234 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * @date 2023/4/13
 */
public class E06LeetCode234 {
    public static void main(String[] args) {
//        RemoveList.ListNode o6 = new RemoveList.ListNode(6,null);
        RemoveList.ListNode o5 = new RemoveList.ListNode(1,null);
        RemoveList.ListNode o4 = new RemoveList.ListNode(2,o5);
        RemoveList.ListNode o3 = new RemoveList.ListNode(3,o4);
        RemoveList.ListNode o2 = new RemoveList.ListNode(2,o3);
        RemoveList.ListNode o1 = new RemoveList.ListNode(1,o2);

        E06LeetCode234 e06LeetCode234 = new E06LeetCode234();
        System.out.println(e06LeetCode234.isPalindrome2(o1));
    }
//
    private boolean isPalindrome(RemoveList.ListNode head) {
        if (head == null || head.next == null) return true;
        int p = head.val;
        RemoveList.ListNode p2 = head;
        while (p2!=null && p2.next!=null ){
            p2 = p2.next;
            if (p2.next == null && p == p2.val){
                return true;
            }
        }
        return false;
    }
//    不是判断首尾节点，是首尾倒过来
    private boolean isPalindrome2(RemoveList.ListNode head){
        if (head == null || head.next == null) return true;
        /**
         * 步骤 1。找中间节点 2.反转 3.对比
         */
        RemoveList.ListNode p1 = head;
        RemoveList.ListNode p2 = head;
//        快慢指针 取中间
        while (p2 !=null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
//        反转
        RemoveList.ListNode re = null;
        while (p1!=null){
            re = new RemoveList.ListNode(p1.val,re);
            p1 = p1.next;
        }
        System.out.println("re: "+re);
//        对比
        while (re!=null){
//            只要找到不同的就能退了(有时候思想需要反转)
            if (re.val != head.val){
                return false;
            }
            re = re.next;
            head = head.next;
        }
        return true;
    }


}
