package com.liovo;

/**
 * leetcode 反向链表
 * @Date 2023/4/6 15:38
 */
public class ReverseList {
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

          @Override
          public String toString() {
              StringBuilder stringBuilder = new StringBuilder(64);
              stringBuilder.append("[");
              ListNode p = this;
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
    public ListNode reverse(ListNode listNode){
//        System.out.println(listNode);
        ListNode  old = listNode;
        ListNode curr = null;
        ListNode newList = null;
        while (old!=null){
//            System.out.println(curr);
            curr = new ListNode(old.val,curr);
//            curr = new ListNode(old.val,old.next);
            old = old.next;
        }
        return curr;
    }

    /**
     * 递归
     * @param listNode
     * @return
     */
    public ListNode reverse2(ListNode listNode){
        System.out.println("+++"+listNode.next);
        if (listNode.next == null) return listNode;
        ListNode reverse2 = reverse2(listNode.next);
//        System.out.println("---"+listNode.next.next);
        listNode.next.next = listNode;
        listNode.next = null;
        return reverse2;
    }

    /**
     *
     * [1,2,3,4,5]
     * [2,1,3,4,5]
     * [3,2,1,4,5]
     *  ......
     */

    public ListNode reverse3(ListNode o1){
        ListNode n1 = o1;
        ListNode o2 = o1.next;

        while (o2 != null){
            o1.next = o2.next;  //把2指向3
            o2.next = n1;  //o2链接到头部 （替换）
            n1 = o2; //n1 上位
            o2 = o1.next; //重新继续去指向下一个点
//            n1 = o2.next;
//            o2 = o1;
        }
        return n1;
    }
    public static void main(String[] args) {
        ListNode o5 = new ListNode(5,null);
        ListNode o4 = new ListNode(4,o5);
        ListNode o3 = new ListNode(3,o4);
        ListNode o2 = new ListNode(2,o3);
        ListNode o1 = new ListNode(1,o2);
//        System.out.println(o1);

        ListNode reverseList = new ReverseList().reverse3(o1);
        System.out.println(reverseList);
    }

}
