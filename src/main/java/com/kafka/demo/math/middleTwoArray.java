package com.kafka.demo.math;

import java.util.Arrays;

/**
 * 已知两个有序数组，找到两个数组合并后的中位数
 */
public class middleTwoArray {

    /**
     * 方法一：两个数组合并为一个新的数组并且在排序，在求中位数
     */

    private static long findMiddleNumber(int[] A, int[] B){
        int[] nums = new int[A.length + B.length];
        for (int i = 0; i < nums.length; i++){
            if (i < A.length){
                nums[i] = A[i];
            } else {
                nums[i] = B[i - A.length];
            }
        }
        //新数组排序
        Arrays.sort(nums);
        // 偶数
        if (nums.length % 2 == 0){
            return (nums[nums.length / 2 -1] + nums[nums.length / 2]) / 2;
        }else{
            return nums[(nums.length + 1) /2];
        }
    }

    public static void main(String[] args) {
        int[] A = {1,2,5,7,4,9};
        int[] B = {3,6,11,15,8};
        findMiddleNumber(A,B);
    }

}
