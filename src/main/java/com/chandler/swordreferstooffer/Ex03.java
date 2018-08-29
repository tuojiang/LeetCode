package com.chandler.swordreferstooffer;

/**
 * @Date: 18-8-29
 * @version： V1.0
 * @Author: Chandler
 * @Description: 替换字符串
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Ex03 {
    /**
     * 暴力解法,使用Java自带APIreplaceAll
     *
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        String newStr = str.toString();
        return newStr.replaceAll(" ", "%20");
    }

    /**
     * 不使用自带API,拼接字符
     * @param str
     * @return
     */
    public String replaceSpaceBetter(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuffer newStr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            } else {
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("We ").append("Are Happy");
        System.out.println(new Ex03().replaceSpaceBetter(stringBuffer));
    }
}
