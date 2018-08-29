package com.chandler.leetcode;


import java.util.*;

/**
 * @author： chandler
 * @date： 2018-07-30
 * @version： V1.0
 * @description： 两个数组的交集 II
 * --------------------
 * 给定两个数组，写一个方法来计算它们的交集。
 * <p>
 * 例如:
 * 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 * <p>
 * 注意：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 跟进:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 * --------------------
 */

public class Ex350 {
    public int[] intersect(int[] nums1, int[] nums2) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int num : nums2){
            if (map.containsKey(num)){
                integers.add(num);
                map.put(num,map.get(num)-1);
                if (map.get(num)==0){
                    map.remove(num);
                }
            }
        }
        int[] ret = new int[integers.size()];
        int m = 0;
        for (int num : integers) {
            ret[m++] = num;
        }
        return ret;
    }

    /**
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersectSort(int[] nums1, int[] nums2) {
        int[] ret;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        ret = new int[list.size()];
        int m = 0;
        for (int num : list) {
            ret[m++] = num;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] com = new Ex350().intersect(nums1, nums2);
        for (int s : com) {
            System.out.println(s);
        }
    }
}
