package com.liovo.array;

/**
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * @date 2023/4/15
 */
public class E06LeetCode88MergeArray {
    public static void main(String[] args) {
        int arr1[] = { 1,2,3,0,0,0 };
        int arr2[] = { 2,5,6 };
        System.arraycopy(arr2,0,arr1,3,arr2.length);
        for (int i : arr1) {
            System.out.println(i);
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {

    }
}
