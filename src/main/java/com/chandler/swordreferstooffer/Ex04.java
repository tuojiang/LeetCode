package com.chandler.swordreferstooffer;

import java.util.ArrayList;

/**
 * @Date: 18-8-29
 * @version： V1.0
 * @Author: Chandler
 * @Description: 从尾到头打印链表
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Ex04 {
    ArrayList<Integer> array = new ArrayList<>();

    /**
     * 思路：递归
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return array;
        }
        printListFromTailToHead(listNode.next);
        array.add(listNode.val);
        return array;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
