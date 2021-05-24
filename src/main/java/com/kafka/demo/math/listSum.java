package com.kafka.demo.math;

/**
 * 两个链表表示的数相加，这样就可以实现两个很⼤的数相加了，⽆需考虑数值 int ，float 的限制
 */
public class listSum {
    /**
     * eg Input:(2->4->3) + (1->4->7)
     * output 3->9->0
     * 243 + 147 = 390
     * 思想 由个位进行运算 ，循环列表，直至 两个列表都为null时计算完毕
     * 方法2：for循环两个链表
     */
    static class listArray {
        int val;
        listArray next;
        listArray(int x) {
            val = x;
        }
    }

    public static listArray twoNumberAdd(listArray a, listArray b) {
        //初始化节点头
        listArray dummyHead = new listArray(0);
        //链表a的头p->个位数字
        listArray p = a;
        //链表b的头p->个位数字
        listArray q = b;
        //从节点第一位开始运算 也就是个位数
        listArray curr = dummyHead;
        //进位，默认是0 不进位
        int carry = 0;
        while (p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            //判断是否要进位
            int sum = carry + x + y;
            //进位永远是1
            carry = sum / 10;
            //节点头移动判断
            curr.next = new listArray(sum % 10);
            //节点头更新
            curr = curr.next;
            if (p != null) {
                //下一位运算，替换值
                p = p.next;
            }
            if (q != null) {
                //下一位运算，替换值
                q = q.next;
            }
        }
        if (carry > 0){
            //更新链表
            curr.next = new listArray(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] a = {1,8,2};
        int[] b = {2,1,8};
    }

}
