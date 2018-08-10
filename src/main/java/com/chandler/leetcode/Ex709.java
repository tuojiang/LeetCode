package com.chandler.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： chandler
 * @date： 2018-07-31
 * @version： V1.0
 * @description： 转换成小写字母
 * --------------------
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: "Hello"
 * 输出: "hello"
 * 示例 2：
 * <p>
 * 输入: "here"
 * 输出: "here"
 * 示例 3：
 * <p>
 * 输入: "LOVELY"
 * 输出: "lovely"
 * --------------------
 */

public class Ex709 {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ('A' < chars[i] && chars[i] < 'Z') {
                chars[i] = (char) (chars[i]-'A'+'a');
            }
        }
         return new String(chars);
    }

    public static void main(String[] args) {
        String str = "HELlo";
        System.out.println(new Ex709().toLowerCase(str));
    }
}





















