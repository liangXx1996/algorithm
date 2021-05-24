package com.kafka.demo.math;

/**
 * 输入它的整数，输出它的倒置
 * eg i:123 o:321 ; -123 -321  250 52
 */
public class eight {

    /**
     * 首先要判断是否溢出 -2&31 ~ 2&31 - 1  或者使用 long
     */

    private static int invert(int num){
        long result = 0;
        while (num != 0){
            //取余
            int top = num % 10;
            //每次缩小10倍
            num = num / 10;
            //倒置为第一位
            result = result * 10 + top;
        }
        //判断是否溢出
        if ( result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        System.out.println((int) result);
        return (int) result;
    }

    public static void main(String[] args) {
        int a = 1215487;
        invert(a);
    }
}
