package com.liovo.queue;

import java.util.Iterator;

/**
 * @date 2023/4/19
 */
public class LinkedListQueue<E> implements Queue<E>,Iterable<E> {
    public static class Node<E>{
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

    }
    Node<E> head = new Node<>(null,null);
    Node<E> tail = head;

//  形成环形
    public LinkedListQueue() {
        tail.next = head;
    }

    @Override
    public boolean offer(E value) {
//        指向head为环形
        Node<E> added = new Node<>(value, head);
        tail.next = added;
        tail = added;
        return false;
    }
    // 从队列头获取值，移除值。拿到值将前一个值指向拿到值的后一个值
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        Node<E> first = head.next;
//        进行删除
        head.next = first.next;
//        当只有一个值时
        if (first == tail) tail = head;
        return first.value;
    }
    // 从队列头获取值，不移除
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
//        头等于尾则空

        return head==tail;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    //    自定义迭代器
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
//          申明指针
            Node<E> p = head.next;
//          判断是否有下一个，条件：是否为环形
            @Override
            public boolean hasNext() {
                return p != head;
            }
//            获取下一个
            @Override
            public E next() {
                E value = p.value;
//             指针重新指向
                p = p.next;
                return value;
            }
        };
    }
}
