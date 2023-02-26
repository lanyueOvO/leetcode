package com.liovo;

public class BinarySearch {
    /**
     * 二分查找
     * 利用二分查找查有序数组下标
     */
    public static int binarySearchBasic(int[] nums,int target){
        if (nums != null && nums.length>0) {
            for (int i=0;i<nums.length-1;i++){
                for (int j = nums.length-1; j <nums.length ; j++) {
                    if (i>j) return -1; //如果没查到直接返回-1
                    int m = (int) Math.floor((i+j)/2); //向下取整
                    System.out.println(m);
                    if (nums[m]>target){
                        j=m-1;
                    }else if (nums[m]<target){
                        i=m+1;
                    }else {
                        return m;
                    }
                }
            }
            return target;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {7,13,21,30,38,44,52,54};
        System.out.println("now:"+binarySearchBasic(nums,52));
    }
}
