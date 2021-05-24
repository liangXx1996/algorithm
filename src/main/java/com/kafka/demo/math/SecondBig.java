package com.kafka.demo.math;

public class SecondBig {

    public static int findSecondMax(int[] array){
        int max,max2;
        if (array.length < 2 ){
            return array[0];
        }
        max = max2 = 0;/* 未考虑负数，如果考虑,那么max,max2的初始值为 2.-31次 */
        for (int value : array) {
            if (value > max) {
                max2 = max;
                max = value;
            }
            if (value < max && value > max2) {
                max2 = value;
            }
        }
        System.out.println(max2);
        return max2;
    }

    public static void main(String[] args) {
        int[] test =  {1,5,8,4,12,0,6,9,144,251,874,984,12,57,66,48,35,14,19};
        findSecondMax(test);
    }
}
