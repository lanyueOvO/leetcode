package com.liovo.kmp;

/**
 * @date 2023/5/5
 *
 * 字符串算法之暴力匹配
 * 源 aabaabaaf
 * 串 aabaaf
 */
public class AllMatch {
    public static void main(String[] args) {
        String a = "aabaabaaf";
        String b = "aabaaf";

        int al = a.length();
        int bl = b.length();
//        System.out.println(al+bl);
//        定义双指针
        int i = 0,j = 0;
//        结束条件：下标到达不能到达位置
        while (i<al&&j<bl){
            if (a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }else {
                i=i-j+1;
                j=0;
            }
        }
//        条件模式串能加满的时候则为匹配成功,i-j为匹配的起始下标
        if (j==bl) System.out.println(i-j);
    }
}
