package com.liovo;

/**
 * leetcode 21 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 23 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * @date 2023/4/11
 */
public class E06LeetCode21 {
    public static void main(String[] args) {
        RemoveList.ListNode o5 = new RemoveList.ListNode(10,null);
        RemoveList.ListNode o4 = new RemoveList.ListNode(9,o5);
        RemoveList.ListNode o3 = new RemoveList.ListNode(8,o4);
        RemoveList.ListNode o2 = new RemoveList.ListNode(3,o3);
        RemoveList.ListNode o1 = new RemoveList.ListNode(1,o2);

        RemoveList.ListNode n3 = new RemoveList.ListNode(4,null);
        RemoveList.ListNode n2 = new RemoveList.ListNode(2,n3);
        RemoveList.ListNode n1 = new RemoveList.ListNode(1,n2);

        RemoveList.ListNode x3 = new RemoveList.ListNode(11,null);
        RemoveList.ListNode x2 = new RemoveList.ListNode(7,x3);
        RemoveList.ListNode x1 = new RemoveList.ListNode(6,x2);
        E06LeetCode21 e06LeetCode21 = new E06LeetCode21();
        RemoveList.ListNode[] lists = {o1,n1,x1};
        System.out.println(e06LeetCode21.mergeTwoLists(o1, n1));
//        e06LeetCode21.mergeKLists(lists);
    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 1 3 8 9 10
     * 1 2 4
     * @param list1
     * @param list2
     * @return
     */
    public RemoveList.ListNode mergeTwoLists(RemoveList.ListNode list1, RemoveList.ListNode list2) {
        if (list1==null && list2==null) return null;
        RemoveList.ListNode s = new RemoveList.ListNode(0,list1);
        RemoveList.ListNode p1 = list1;
        RemoveList.ListNode p2 = list2;
        RemoveList.ListNode p = s;
        System.out.println(p2);
        while (p1!=null && p2!=null){
            if (p1.val <= p2.val){
                p.next = p1;  //谁小链接谁
                p1 = p1.next;
                //                p2不用移动
            }else { //大了就链接另一个
                p.next = p2;
                p2 = p2.next;
                //                p1不用移动
            }
            p = p.next;
            System.out.println(p);
        }
        if (p1 != null) p.next = p1;

        if (p2 != null) p.next = p2;

        return s.next;
    }

    /**
     *给你一个链表数组，每个链表都已经按升序排列。
     *请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * @param lists
     * @return
     */
    public RemoveList.ListNode mergeKLists(RemoveList.ListNode[] lists) {
//        System.out.println(lists);
        if (lists.length == 0) return null;

        return spit(lists,0,lists.length);
    }
//    i j左右边界
    private RemoveList.ListNode spit(RemoveList.ListNode[] lists,int i,int j){
        //数组内只有一个链表时
        if (i==j) return lists[i];  // j也行
        int m = (i+j)>>>1;
        RemoveList.ListNode left = spit(lists, i, m);
        RemoveList.ListNode right = spit(lists, m + 1, j);
        return mergeTwoLists(left,right);
    }
}
