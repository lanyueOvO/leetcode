package com.liovo;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 */
public class SunForTwoNumber {
    private static int target = 9;
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int index[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <nums.length - 1 ; j++) {
                if (nums[i] + nums[j] == target){
//                    System.out.println(i+"+++"+j);
                    index[1] = i;
                    index[0] = j;
                }
            }
        }
        System.out.println(Arrays.toString(index));
    }
}
