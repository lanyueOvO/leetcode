package com.liovo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Date 2023/3/29 22:35
 */
public class E06Fibonacci {
    /**
     * 斐波那契数列
     * @return
     */
    public static int fibonacci(int n){
        if (n==0) return 0;
        if (n==1) return 1;

        int x = fibonacci(n - 1);
        int y = fibonacci(n - 2);
        return x + y;
    }

    /**
     * 斐波那契数列改进版--记性数列
     * 思路：将计算过的f(n)存储进数组，下次需要n-1和n-2项数据时从数组中获取，
     * 然后不在重新计算
     * @param n
     * @return
     */

    public static long fibonacci2(int n){
        long[] cache = new long[n+1];  //创建数组（+1是因为对应斐波那契的n项，数组下标从0开始）
        Arrays.fill(cache,-1);   //初始化赋值
//        默认得到第0项和第1项
        cache[0] = 0;
        cache[1] = 1;
//        将n项和cache记忆数组
        return memoization(n,cache);
    }

    public static long memoization(int n,long[] cache){
//        ArrayList<Object> list = new ArrayList<>();
//        不等于-1说明数组中已经存在计算过的值了，直接用（取）
        if (cache[n] != -1) return cache[n];
//         开始遍历
        long x = memoization(n-1,cache);
        long y = memoization(n-2,cache);
        cache[n] = x+y; //x+y就是第n的值 （存）
//        此处return的值就是取的值
        return cache[n];
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("fff: "+fibonacci2(50));
//        Thread.sleep(1);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
//        System.out.println(System.getProperty("java.library.path"));
    }
}
