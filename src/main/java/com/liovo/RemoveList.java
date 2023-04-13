package com.liovo;

/**
 * leetCode 203,19,83
 * 203 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 *
 * 19 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 83 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表
 *
 * 82 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * @Date 2023/4/6 23:50
 */
public class RemoveList {
    static class ListNode {
        int val;
        RemoveList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, RemoveList.ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("[");
            RemoveList.ListNode p = this;
            while (p!=null){
                stringBuilder.append(p.val);
                if (p.next != null){
                    stringBuilder.append(",");
                }

                p = p .next;
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

    }

    public static void main(String[] args) {
        RemoveList.ListNode o7 = new RemoveList.ListNode(8,null);
        RemoveList.ListNode o6 = new RemoveList.ListNode(7,o7);
        RemoveList.ListNode o5 = new RemoveList.ListNode(6,o6);
        RemoveList.ListNode o4 = new RemoveList.ListNode(5,o5);
        RemoveList.ListNode o3 = new RemoveList.ListNode(1,o4);
        RemoveList.ListNode o2 = new RemoveList.ListNode(1,o3);
        RemoveList.ListNode o1 = new RemoveList.ListNode(1,o2);

//        RemoveList.ListNode o6 = new RemoveList.ListNode(7,null);
//        RemoveList.ListNode o5 = new RemoveList.ListNode(7,o6);
//        RemoveList.ListNode o4 = new RemoveList.ListNode(7,o5);
//        RemoveList.ListNode o3 = new RemoveList.ListNode(7,o4);
//        RemoveList.ListNode o2 = new RemoveList.ListNode(7,o3);
//        RemoveList.ListNode o1 = new RemoveList.ListNode(7,o2);
        RemoveList removeList = new RemoveList();
        System.out.println(removeList.deleteDuplicatesAll(o1));
//        System.out.println(removeList.deleteDuplicates2(o1));
//        new RemoveList().recursion(o1,2);
//        System.out.println(removeList.remove2(o1, 7));
    }

    //remove 1 (203)
    private ListNode remove(ListNode head,int val) {
//        System.out.println(val);
        ListNode old = head;
        ListNode n1 = null;
        while (old != null){
//            System.out.println(old.val);
            if (old.val == val) {
//                System.out.println("---"+old.val);

                old = old.next;
            }
            if (old!=null){
                n1 = new ListNode(old.val,n1);
                old = old.next;
            }
        }

        while (n1 != null){
            old = new ListNode(n1.val,old);
            n1 = n1.next;
        }

        return old;
    }

    /**
     * 主要思路两个指针 直接p1.next = p2.next
     * @param head
     * @param val
     * @return
     */
    //remove 2 (203)
    private ListNode remove2(ListNode head,int val) {
//        设初始值
        ListNode s = new ListNode(-1,head); //哨兵值
        ListNode p1 = s;
        ListNode p2 = s.next;
        while (p2!=null){
            if (p2.val == val){
//                删除，p2后平移
                p1.next = p2.next;
                p2 = p2.next;
            }else {
//                直接平移
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return s.next;
    }

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * nn:递归反向拿到倒数值.删除头结点需要加哨兵
     */
    private int recursion(ListNode p,int val) {
        if (p == null) {
            return 0;
        }
//        System.out.println("----"+p.val);
//        递归拿到倒数列表
        int nth = recursion(p.next, val);

        if (nth == val){
            //假如 p=3 p.next=4 p.next.next=5
            p.next = p.next.next;
        }
//        System.out.println(p.val + " " +nth);
        return nth+1;
    }

    /**
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表
     * 1 2 2 3 4 5 6
     */
    public ListNode deleteDuplicates(ListNode head){
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s.next;
        if (head==null || head.next == null) return head;
        while (p1.next!=null){
            if (p1.val == p1.next.val){
                p1.next = p1.next.next;
            }else {
                p1 = p1.next;
            }
//            System.out.println(p1+" --ppp-- "+p1.val);
//            System.out.println(s+" --sss-- "+s.val);
        }
        return s.next;
    }
    //递归版
    public ListNode deleteDuplicates2(ListNode head){
        if (head==null || head.next == null) return head;
        if (head.val == head.next.val){
            return deleteDuplicates(head.next);
        }else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    /**
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     * 1 1 1 2 3
     */
    public ListNode deleteDuplicatesAll(ListNode head){
        if (head == null || head.next==null) return head;
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
//        ListNode p2 = p1.next;  //直接赋值会空指针
//        ListNode p3 = p2.next;
        ListNode p2,p3;
        while ((p2=p1.next)!=null&&(p3=p2.next)!=null){

            if (p2.val == p3.val){
                System.out.println("--"+p1+"+++"+p2);
                while ((p3=p3.next)!=null&&p2.val == p3.val){

                }
                p1.next = p3;
            }else {
                p1 = p1.next;
//                p2 = p2.next;
            }

        }
        return s.next;
    }
    //递归
    public ListNode deleteDuplicatesAll2(ListNode head){
        if (head==null || head.next == null) return head;

        if (head.val == head.next.val){
//            新定义指针，此处一直找到不重复的值
            ListNode x = head.next.next;
//            一直循环找
            while (x!=null && x.val == head.val){
                x = x.next;
            }
            return deleteDuplicatesAll2(x);
        }else {
            head.next = deleteDuplicatesAll2(head.next);
            return head;
        }
    }
}
