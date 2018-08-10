package com.chandler.leetcode;

import java.util.List;
import java.util.Stack;

/**
 * @author： chandler
 * @date： 2018-07-23
 * @version： V1.0
 * @description： 用栈实现队列
 * --------------------

    push(x) -- 将一个元素放入队列的尾部。
    pop() -- 从队列首部移除元素。
    peek() -- 返回队列首部的元素。
    empty() -- 返回队列是否为空。
    示例:

    MyQueue queue = new MyQueue();

    queue.push(1);
    queue.push(2);
    queue.peek();  // 返回 1
    queue.pop();   // 返回 1
    queue.empty(); // 返回 false
    说明:

    你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
    你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
    假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * --------------------
 */

public class Ex232<T> {

    public  Stack<Integer> stack;
    public  Stack<Integer> curStack;

    public Ex232(){
        stack = new Stack<>();
        curStack = new Stack<>();
    }
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return curStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (curStack.isEmpty()) {
            while (!stack.isEmpty()) {
                curStack.push(stack.pop());
            }
        }

        return curStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty()&&curStack.isEmpty();
    }
    public static void main(String[] args) {
        Ex232 queue = new Ex232();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(5);
//        queue.peek();  // 返回 1
        System.out.println(queue.peek());
//        queue.pop();   // 返回 1
        System.out.println(queue.pop());
        queue.empty();
    }
}
