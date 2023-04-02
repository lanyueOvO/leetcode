package com.liovo;

import java.util.Arrays;

/**
 * @Date 2023/3/29 0:22
 */
public class E04BubbleSort {
    /**
     * 递归冒泡排序
     * @param a
     * @param j
     */
    public static void bubble(int[] a,int j){
        if (j==0) return;

        for (int i = 0; i < j; i++) {
            if (a[i]>a[i+1]) {
                int t = a[i];
                a[i] = a[i+1];
                a[i+1] = t;
            }
        }

        bubble(a,j-1);
    }

    public static void main(String[] args) {
        int[] ints = {2,1,6,3,9,7};
        bubble(ints,ints.length-1);
        System.out.println(Arrays.toString(ints));
    }
}
