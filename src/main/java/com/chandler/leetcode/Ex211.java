package com.chandler.leetcode;

import java.util.TreeMap;

/**
 * @author： chandler
 * @date： 2018-08-02
 * @version： V1.0
 * @description： 添加与搜索单词 - 数据结构设计
 * --------------------
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * <p>
 * 示例:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 * <p>
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 * --------------------
 */

public class Ex211 {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }

    }

    public Node root;

    /**
     * Initialize your data structure here.
     */
    public Ex211() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(root, word, 0);

    }

    private boolean match(Node root, String word, int index) {
        if (index == word.length()) {
            return root.isWord;
        }
        char c = word.charAt(index);

        if (c != '.') {
            if (root.next.get(c) == null) {
                return false;
            }
            return match(root.next.get(c), word, index + 1);
        } else {
            for (char nextChar : root.next.keySet()) {
                if (match(root.next.get(nextChar), word, index + 1)) {
                    return true;
                }
            }

            return false;

        }
    }

    public static void main(String[] args) {
        Ex211 test = new Ex211();
        test.addWord("bad");
        test.addWord("dad");
        test.addWord("mad");
        System.out.println(test.search("pad"));
        System.out.println(test.search("bad"));
        System.out.println(test.search(".ad"));
        System.out.println(test.search("b.."));
    }
}
