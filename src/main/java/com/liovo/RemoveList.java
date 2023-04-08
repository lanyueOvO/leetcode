package com.liovo;

/**
 * leetCode 203,19
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
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
        RemoveList.ListNode o7 = new RemoveList.ListNode(7,null);
        RemoveList.ListNode o6 = new RemoveList.ListNode(6,null);
        RemoveList.ListNode o5 = new RemoveList.ListNode(5,o6);
        RemoveList.ListNode o4 = new RemoveList.ListNode(4,o5);
        RemoveList.ListNode o3 = new RemoveList.ListNode(3,o4);
        RemoveList.ListNode o2 = new RemoveList.ListNode(2,o3);
        RemoveList.ListNode o1 = new RemoveList.ListNode(1,o2);

//        RemoveList.ListNode o6 = new RemoveList.ListNode(7,null);
//        RemoveList.ListNode o5 = new RemoveList.ListNode(7,o6);
//        RemoveList.ListNode o4 = new RemoveList.ListNode(7,o5);
//        RemoveList.ListNode o3 = new RemoveList.ListNode(7,o4);
//        RemoveList.ListNode o2 = new RemoveList.ListNode(7,o3);
//        RemoveList.ListNode o1 = new RemoveList.ListNode(7,o2);
        RemoveList removeList = new RemoveList();
        new RemoveList().recursion(o1,2);
//        System.out.println(removeList.remove2(o1, 7));
    }


    //remove 1
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
    //remove 2
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
     * 递归反向拿到倒数值.删除头结点需要加哨兵
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
}
