package com.liovo;

/**
 * 模拟单向链表
 * @Date 2023/3/3 21:16
 */

public class SinglyLinkedList {
    private Node head = null;

    private Node findLast(){
        if (head == null){  //空链表
            return null;
        }
        Node p;
        for(p = head;p.next !=null; p=p.next){
        }                                           //此for循环查找链表最后一个元素
        return p;
    }

    public void addLast(int value){
        Node last = findLast();
        //if null ....
        last.next = new Node(value,null);
    }

}
class Node{
    int value;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
