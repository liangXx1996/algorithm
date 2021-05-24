package com.kafka.demo.math;

import java.util.HashMap;
import java.util.Map;

public class mathSum {

    /**
     * 给定一个数字，从数组中找两个数字相加等于目标和，输出这两个数字
     */
    private static int[] sumA(int[] array, int sum) {
        int[] a = new int[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (a[i] + a[j] == sum) {
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return a;
    }

    private static int[] sumB(int[] array, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        //将所有数组转为map.key为值，value为下标
        for (int i : array) {
            map.put(array[i], i);
        }
        for (int i = 0; i < array.length; i++) {
            int sub = sum - array[i];
            if (map.containsKey(sub) && map.get(sub) != i) {
                return new int[]{i, map.get(sub)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] test =  {1,5,8,4,12,0,6,9,144,251,874,984,12,57,66,48,35,14,19};
         int sum = 13;
         sumA(test,sum);
         sumB(test,sum);
    }

}
