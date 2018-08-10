package com.chandler.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author： chandler
 * @date： 2018-08-01
 * @version： V1.0
 * @description： 前K个高频元素
 * --------------------
    给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

    例如，

    给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]。

    注意：

    你可以假设给定的 k 总是合理的，1 ≤ k ≤ 数组中不相同的元素的个数。
    你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。

 * --------------------
 */

public class Ex347 {

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );
        for(int key: map.keySet()){
            if(pq.size() < k) {
                pq.add(key);
            } else if(map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }

    private static void printList(List<Integer> nums){
        for(Integer num: nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new Ex347()).topKFrequent(nums, k));
    }
}








































