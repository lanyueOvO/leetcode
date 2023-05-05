package com.liovo;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @date 2023/4/14
 */
public class E06LeetCode42 {
    public static void main(String[] args) {
        int[] ints = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(ints));
    }

    public static int trap(int[] height) {
        int ans = 0;
        int len = height.length;
        if (len<3) return 0;
//        左右最大值
        int right_max_arr[] = new int[len];
        int left_max_arr[] = new int[len];

        left_max_arr[0] = height[0];
        right_max_arr[len-1] = height[len-1];
//      
        for (int i=1;i<len;i++){
            left_max_arr[i] = Math.max(left_max_arr[i-1],height[i]);
        }
//        
        for (int i = len-2; i >=0; i--) {
            right_max_arr[i] = Math.max(right_max_arr[i+1],height[i]);
        }
//
        for (int i = 0; i < len; i++) {
            ans += Math.min(left_max_arr[i], right_max_arr[i])-height[i];
        }
        return ans;
    }
}
