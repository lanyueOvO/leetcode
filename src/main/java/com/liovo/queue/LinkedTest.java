package com.liovo.queue;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @date 2023/4/19
 */
public class LinkedTest {
    @Test
    public void offer(){
        LinkedListQueue<Object> listQueue = new LinkedListQueue<>();
        listQueue.offer(1);
        listQueue.offer(2);
        listQueue.offer(3);
        listQueue.offer(4);
        listQueue.offer(5);
//        listQueue.offer(7);
//        List.of() jdk 9之后的东西
        assertIterableEquals(List.of(1,2,3,4,5),listQueue);
//        for (Object o : listQueue) {
//            System.out.println(o);
//        }
    }
}
