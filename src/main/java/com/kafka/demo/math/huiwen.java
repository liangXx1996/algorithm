package com.kafka.demo.math;

/**
 * 回文字符串并输出最长的回文字符串/或者长度
 */
public class huiwen {

    /**
     * 方法一: 从中折叠， 循环判断 从中折叠 前一位 和 后一位 是否 相等
     */
    private static boolean isPalindrome(String words) {
        for (int i = 0; i < words.length() / 2; i++) {
            if (words.charAt(i) != words.charAt(words.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static  String findBestLongWords(String words) {
        int w = words.length();
        int maxLong = 0;
        //需要一个初始化字符串来记录回文字符串
        String s = "";
        for (int i = 0; i < w; i++) {
            for (int j = i + 1; j <= w; j++) {
                String pd = words.substring(i,j);
                if (isPalindrome(pd) && pd.length() > maxLong){
                    maxLong = Math.max(maxLong, pd.length());
                    s = pd;
                }
            }
        }
        System.out.println(s);
        return s;
    }

    public static void main(String[] args) {
        String test = "afdigadnabbasbdaygfawdssaduhdgfdg";
        findBestLongWords(test);
    }


    /**
     *PAM 算法  / 马拉车算法  动态规划 来减少时间复杂度
     *  马拉车算法 本质是回文的对称性来进行匹配 而且 不用考虑 奇偶性，因为在每个字符串直接插入"#"并且在收尾左右插入字符串，这样保证字符串的长度永远是奇数
     *  好难，需要首先了解扩展中心算法
     */

//    private static

}
