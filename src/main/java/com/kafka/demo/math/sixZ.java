package com.kafka.demo.math;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，按照竖着的Z方式排列字符
 */
public class sixZ {
    /**
     * 按照写Z的过程 正常循环写，然后便利到两端的话就改变方向
     * numRows 为input s为input
     */

    private static String Z(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }
        //rows 指需要build的行数
        List<StringBuilder> rows = new ArrayList<>();
        //避免最后出现越界->取较小值
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        //代表当前方向
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            //行数拼接字符串
            rows.get(curRow).append(c);
            //转向
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            //控制方向 1 向下 -1 向上
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder builder = new StringBuilder();
        for (StringBuilder row : rows) {
            builder.append(row);
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "sdertfdvsads";
        Z(s,5);
        zTwo(s,5);
    }

    /**
     * 思路二 查找规律 周期性为 2 * numRows -2 ,然后在开启重复相同路径
     * 第一行的规律就是 下标 0
     * 第二行的规律就是  下标1 第二个下标就是下一个周期的0下标 - 当前下标 eg  第二行  下标1，下标(2 * numRows -2 ) - 1
     * 第三行的规律就是 下标2 第二个下标就是下一个周期的0下标 - 当前下标 eg  第二行  下标1，下标(2 * numRows -2 ) - 2
     * 一次类推 ，而且 2 * numRows -2 。length 为一个周期，下个周期循环 之前的规律，只需要在 下个规律的周期下标 + 2 * numRows -2即可
     */

    private static String zTwo(String s, int numRows){
        if (numRows == 1){
            return s;
        }

        StringBuilder builder = new StringBuilder();
        int size = s.length();
        int guilv = 2 * numRows - 2;
        //i 代表 第几行 从第一行下标0开始计算，第一行全部完毕 第二行
        for (int i = 0; i < numRows; i++){
            //每次增加一个周期
            for (int j = 0; j + i < size; j += guilv){
                builder.append(s.charAt( j + i));
                //不等于0行和最后一行
                if (i != 0 && i != numRows -1 && j + guilv - i < size){
                    builder.append(s.charAt(j + guilv - i));
                }
            }
        }
        return builder.toString();
    }

}
