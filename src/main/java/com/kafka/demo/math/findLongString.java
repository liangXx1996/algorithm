package com.kafka.demo.math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定⼀个字符串，找到没有重复字符的最⻓⼦串，返回它的⻓度
 */
public class findLongString {

    /**
     * 思路1：简单粗暴 两个循环穷举所有⼦串，然后再⽤⼀个函数判断该⼦串中有没有重复的字符
     * set 天然不重复
     */

    private static int lengthOfSubstring(String  s){
        int suffice = 0;
        for (int i = 0; i < s.length();i++){
            for (int j = i + 1; j <= s.length(); j++){
                if (repeat(s,i,j)){
                    suffice = Math.max(suffice, j - i);
                }
            }
        }

        System.out.println(suffice);
        return 0;
    }
    private static boolean repeat(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for(int i = start; i < end; i++){
            Character charAt = s.charAt(i);
            if (set.contains(charAt)){
                return false;
            }
            set.add(charAt);
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "abcdabcdeffrights";
        lengthOfSubstring(a);
        method3(a);
    }

    /**
     * 思路2 滑动窗口算法 -> 优化思想： 比如 string[0,8) 之前没有重复，按照思路1 接下来就要判断 string[0,9)有没有重复，而此时又多了一次string[0,8)无效循环
     * 那我 我们只需要判断string[9] 是否在string[0,8)中即可，不在的话，就表明 str[0,9) 中没有重复的字符。 如果在的后，那么后续的string[0,xx)也不用再判断了，
     * 那么从String[1,xx)在开始判断
     *
     */


    private static int method2(String s){
        Set<Character> set = new HashSet<>();
        int suffice = 0;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()){
            //此时进行判断 j 是否在 string[i] 中
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                suffice = Math.max(suffice , j - i);
            }else {
                //i=0++放弃，从一开始继续
                set.remove(s.charAt(i++));
            }
        }
        return suffice;
    }

    /**
     * 思路3  将set 转用 map存储，此时可以直接不考虑之前不满足的情况，而无需 在让i++ ，j++ 正在进行循环判断
     */
    private static int method3(String s){
        //k-> 字符串  v-> 下标
        Map<Character, Integer> map = new HashMap<>();
        int suffice = 0;
        for (int j = 0, i = 0; j < s.length(); j++){
            //判断map是否包含后一位的下标value ->不包含的话，map 继续 put(k,v)  包含的话，对map的 key 进行 value 替换，并且对i 进行 跳跃到j的后一位，j之前100%是重复，所以直接不考虑
            if (map.containsKey(s.charAt(j))){
                 i = Math.max(map.get(s.charAt(j)), i);
            }
            suffice = Math.max(suffice, j - i +1);
            // j + 1 代表 stirng 下标 i 移动的位置 即 i 跳跃 直接不考虑 j 前方的所有字符串
            map.put(s.charAt(j),j + 1);
        }
        return suffice;
    }

}
