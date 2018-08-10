package com.chandler.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： chandler
 * @date： 2018-07-31
 * @version： V1.0
 * @description： 宝石与石头
 * --------------------
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 * <p>
 * S 和 J 最多含有50个字母。
 * J 中的字符不重复。
 * --------------------
 */

public class Ex771 {
    public int numJewelsInStones(String J, String S) {
        List tag = new ArrayList();
        int ret = 0;
        for (int i = 0; i < J.length(); i++) {
            char ch = J.charAt(i);
            tag.add(ch);
        }
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (tag.contains(ch)) {
                ret++;
            }
        }
        return ret;
    }
    public int numJewelsInStones2(String J,String S){
        return S.replaceAll("[^"+J+"]","").length();
    }

    public static void main(String[] args) {
        String J = "aA";
//        String J = "z";
        String S = "aAAbbbb";
//        String S = "ZZ";
        System.out.println(new Ex771().numJewelsInStones2(J,S));
    }

}









































