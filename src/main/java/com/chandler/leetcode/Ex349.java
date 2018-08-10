package com.chandler.leetcode;

import edu.princeton.cs.algs4.In;

import java.util.*;

/**
 * @author： chandler
 * @date： 2018-07-30
 * @version： V1.0
 * @description： 两个数组的交集
 * --------------------
 * 给定两个数组，写一个函数来计算它们的交集。
 * <p>
 * 例子:
 * <p>
 * 给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].
 * <p>
 * 提示:
 * <p>
 * 每个在结果中的元素必定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * --------------------
 */

public class Ex349 {
    /**
     * O(n)
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> ret = new HashSet<>();
        int[] comment;
        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                ret.add(nums2[i]);
            }
        }
        comment = new int[ret.size()];
        int i = 0;
        for (int num : ret) {
            comment[i++] = num;
        }

        return comment;
    }

    /**
     * O(nlogn)
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int[] comment;
        Arrays.sort(nums1);
        for (int num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        comment = new int[set.size()];
        int i = 0;
        for (int num : set) {
            comment[i++] = num;
        }
        return comment;
    }

    private boolean binarySearch(int[] nums2, int num) {
        int low = 0;
        int hight = nums2.length - 1;
        while (low < hight) {
            int mid = low + (hight - low) / 2;
            if (nums2[mid] == num) {
                return true;
            }
            if (nums2[mid] > num) {
                hight = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] com = new Ex349().intersection2(nums1, nums2);
        for (int s : com) {
            System.out.println(s);
        }
    }
}
