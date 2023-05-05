package com.liovo.queue;

/**
 * 自定义队列接口
 */
public interface Queue<E> {
//    像尾部插入
    boolean offer(E value);
//    从队列头获取值，并移除
    E poll();
//    从队列头获取值，不移除
    E peek();
//    检查空
    boolean isEmpty();

    boolean isFull();
}
