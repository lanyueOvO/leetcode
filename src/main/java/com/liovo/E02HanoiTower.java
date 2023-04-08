package com.liovo;

import java.util.LinkedList;

/**
 *
 * 汉罗塔
 * @Date 2023/4/6 17:36
 */
public class E02HanoiTower {
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    static void init(int n){
        for (int i = n; i >=1; i--) {
            a.addLast(i);
        }
    }

    /**
     *
     * @param n 圆盘个数
     * @param a 源
     * @param b 借
     * @param c 目标
     */
    static void move(int n,
                     LinkedList<Integer> a,
                     LinkedList<Integer> b,
                     LinkedList<Integer> c){
        if (n == 0) return;
            move(n-1,a,c,b);
            c.addLast(a.removeLast());
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
            move(n-1,b,a,c);
    }

    public static void main(String[] args) {
        init(3);
        System.out.println(a);

        move(3,a,b,c);

    }
}
