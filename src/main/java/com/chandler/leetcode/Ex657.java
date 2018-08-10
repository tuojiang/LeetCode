package com.chandler.leetcode;

import edu.princeton.cs.algs4.Stack;

/**
 * @author： chandler
 * @date： 2018-08-01
 * @version： V1.0
 * @description： 判断路线成圈
 * --------------------
 * 初始位置 (0, 0) 处有一个机器人。给出它的一系列动作，判断这个机器人的移动路线是否形成一个圆圈，换言之就是判断它是否会移回到原来的位置。
 * <p>
 * 移动顺序由一个字符串表示。每一个动作都是由一个字符来表示的。机器人有效的动作有 R（右），L（左），U（上）和 D（下）。输出应为 true 或 false，表示机器人移动路线是否成圈。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "UD"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "LL"
 * 输出: false
 * --------------------
 */

public class Ex657 {
    public static void main(String[] args) {
        System.out.println(new Ex657().judgeCircle("DD"));
    }

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'R') {
                x++;
            } else if (ch == 'L') {
                x--;
            } else if (ch == 'U') {
                y++;
            } else if (ch == 'D') {
                y--;
            }
        }
        return x == 0 && y == 0;
    }
}
/*时间复杂度：O（N）O（N），其中NN是移动的长度。 我们遍历字符串。

空间复杂度：O（1）O（1）。 在Java中，我们的字符数组是O（N）O（N）。*/











































