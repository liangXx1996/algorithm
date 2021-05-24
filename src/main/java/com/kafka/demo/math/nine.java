package com.kafka.demo.math;

/**
 * 判断是不是回文数，负数不是回文数
 * eg 121 tue  -121 false  10 false 101 ture
 */
public class nine {

    /**
     * 思路一
     * int 转 string 然后判断 是不是回文串
     */

    private boolean huiwen(int num){
        //首先判断int 是否 为负数  超过范围 自动false
        if (num < 0){
            return false;
        }
        String number = String.valueOf(num);
        for (int i = 0; i < number.length() / 2; i++) {
            if (number.charAt(i) != number.charAt(number.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 思路二
     * 假设存在这么⼀个数，倒置后是超出 int 范围的，并且它是回⽂数字
     * int 最⼤为 2147483647
     * 有没有可能是最⾼位⼤于 2 导致的溢出，⽐如最⾼位是 3 ，因为是回⽂串，所以最低位是 3 ，这就将导致
     * 转置前最⾼位也会是 3 ，所以不可能是这种情况
     * 有没有可能是第 2 ⾼位⼤于 1 导致的溢出，此时保持最⾼位不变，假如第 2 ⾼位是 2，因为是回⽂串，所
     * 以个位是 2，⼗位是 2 ，同样的会导致倒置前超出了 int 的最⼤值，所以也不可能是这种情况
     * 同理，第 3 ⾼位，第 4，第 5，直线左边的都是上述的情况，所以不可能是前边的位数过⼤
     * 为了保证这个数是溢出的，前边 5 位必须固定不变了，因为它是回⽂串，所以直线后的灰⾊数字就⼀定是 4
     * ⽽此时不管后边的数字取多少，都不可能是溢出的了
     */
    private boolean huiwenTwo(int num){
        if (num < 0){
            return false;
        }
        long result = 0;
        //倒置num
        while (num != 0){
            //取余
            int top = num % 10;
            //每次缩小10倍
            num = num / 10;
            //倒置为第一位
            result = result * 10 + top;
        }
        //判断 num 与 倒置 是否一致
        return num == result;
    }


}
