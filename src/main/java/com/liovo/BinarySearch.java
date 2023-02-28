package com.liovo;

public class BinarySearch {
    /**
     * 二分查找
     * 利用二分查找查有序数组下标
     */
    public static int binarySearchBasic(int[] nums,int target){
        if (nums != null && nums.length>0) {
            for (int i=0;i<nums.length-1;i--){
                for (int j = nums.length-1; j <nums.length+1 ; j++) {
                    if (i>=j) return -1; //如果没查到直接返回-1
                    int m = (i+j)>>1; //向下取整
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

//    改进版1
    public static int binarySearchBasic2(int[] nums,int target){
        int i = 0 , j= nums.length-1; //设置指针和初始值
        while (i<=j){
            int m = (i+j)>>1;
            if (target<nums[m]){  //若目标在左边
                j = m - 1;
            }else if (target> nums[m]){
                i = m + 1;
            }else {
                return m;
            }
        }
        return -1;
    }

//    改进版2
    public static int binarySearchBasic3(int[] nums,int target){
        int i = 0 , j = nums.length;
        while (1<j-i){
            int m = (j+i)>>1;
            if (target<nums[i]){
                j=m;
            }else {
                i=m;
            }
        }
        if (nums[i] == target){
            return i;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime();
        int[] nums = {7,13,21,30,38,44,52,54,90,91,92,93,94,95,96,97,98};
        System.out.println("now:"+binarySearchBasic(nums,91));
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
    }
}
