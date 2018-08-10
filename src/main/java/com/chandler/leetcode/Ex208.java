package com.chandler.leetcode;

import java.util.TreeMap;

/**
 * @author： chandler
 * @date： 2018-08-02
 * @version： V1.0
 * @description： 字典树
 * --------------------
 * <p>
 * --------------------
 */

public class Ex208 {

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
    public int size;

    public Ex208() {
        size = 0;
        root = new Node();
    }

    /**
     * 获得Trie中存储的单词数量
     *
     * @return
     */
    public int getSize() {
        return size;
    }


    /**
     * 向Trie中添加一个新的单词word
     *
     * @param word
     */
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.next.get(ch) == null) {
                cur.next.put(ch, new Node());
            }
            cur = cur.next.get(ch);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询单词word是否在Trie中
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.next.get(ch) == null) {
                return false;
            }
            cur = cur.next.get(ch);
        }
        return cur.isWord;
    }

    /**
     * 查询是否在Trie中有单词以prefix为前缀
     *
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (cur.next.get(ch) == null) {
                return false;
            }
            cur = cur.next.get(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        Ex208 trie = new Ex208();

        trie.insert("apple");
        System.out.println(trie.search("apple"));// 返回 true
        System.out.println(trie.search("app"));// 返回 false
        System.out.println(trie.startsWith("app"));// 返回 true
        System.out.println();
        trie.insert("app");
        System.out.println(trie.search("app"));// 返回 true
    }
}
