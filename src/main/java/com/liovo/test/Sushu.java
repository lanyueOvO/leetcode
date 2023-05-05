package com.liovo.test;

import java.util.ArrayList;

/**
 * @date 2023/4/28
 */
public class Sushu {
    public static void main(String[] args) {
        int num1 = 101;
        int num2 = 201;
        int j;
//        存储素数
        ArrayList<Object> list = new ArrayList<>();
        for (int i = num1; i <= num2; i++) {
            for (j = 2; j < i; j++) {
                if (i%j==0) break;
            }
            if (i==j) list.add(i);
        }
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
