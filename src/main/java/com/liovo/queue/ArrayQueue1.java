package com.liovo.queue;

import java.util.Iterator;

/**
 * @date 2023/4/30
 * 环形数组实现
 * 1，建立头尾双指针
 * 2，当头尾双指针指向一个节点时表现为空数组
 * 3，末尾挖掉一个元素，当(tail+1)%%length==head 时则表现为满数组
 */
public class ArrayQueue1<E> implements Queue<E>,Iterable<E>{

    private E[] array;
    private int head;
    private int tail;

//    初始化数组（+1，代表挖空换一个）
    public ArrayQueue1(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }

//    新值
    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        array[tail] = value;
//        在尾部新值
        tail = (tail+1) % array.length;
        return true;
    }

//    移除
    @Override
    public E poll() {
        if (isEmpty()) return null;
        E val = array[head];
//        移除的元素为头指针指向元素，在移动头指针
        head = (head+1)%array.length;
        return val;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return head==tail;
    }

    @Override
    public boolean isFull() {
        return (tail+1)%array.length == head;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
