package com.liovo.fort;

import org.junit.Test;

/**
 * @date 2023/5/5
 */
public class DoubleFor {
    /**
     *  s   k   l
     *  0---0---0
     *  0---0---1
     *  0---0---2
     *  1---1---0
     *  2---1---1
     *  3---1---2
     *  5---2---0
     *  7---2---1
     *  9---2---2
     *
     *  先内后外，一层外进去把内层循环完再一层外进去循环完内层，以此内推
     *  9
     */
    @Test
    public void test1(){
        int i,j;
        int sum = 0;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                sum = sum+k;
                System.out.println(sum+"---"+k+"---"+l);
            }
        }
        System.out.println(sum);
    }

    /**
     *
     * 0---0---0
     * 0---0---1
     * 0---0---2
     * 1---1---1
     * 2---1---2
     * 4---2---2
     * 4
     * 同理，但是因为外层k值赋值给内层l，所以内层循环次数会递减
     */
    @Test
    public void test2(){
        int i,j;
        int sum = 0;
        for (int k = 0; k < 3; k++) {
            for (int l = k; l < 3; l++) {
                sum = sum+k;
                System.out.println(sum+"---"+k+"---"+l);
            }
        }
        System.out.println(sum);
    }

    /**
     *
     * 1---1---0
     * 3---2---0
     * 5---2---1
     * 5
     * 当条件满足时才进入内层循环
     */
    @Test
    public void test3(){
        int i,j;
        int sum = 0;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < k; l++) {
                sum = sum+k;
                System.out.println(sum+"---"+k+"---"+l);
            }
        }
        System.out.println(sum);
    }

    public void test4(){

    }
}
