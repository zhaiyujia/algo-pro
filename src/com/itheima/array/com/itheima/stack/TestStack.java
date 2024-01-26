package com.itheima.array.com.itheima.stack;

/**
 * @author zhai
 * @date 2024/1/25 6:36 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class TestStack {

    public static void main(String[] args) {
        Stack stack = new Stack();
        //元素入栈
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        System.out.println("栈中元素个数:" + stack.size() + ",栈是否为空:" + stack.empty());
        System.out.println("打印输出栈:" + stack);
        System.out.println("栈顶元素为:" + stack.peek());
        System.out.println("元素出栈" + stack.pop());
        System.out.println("打印输出栈" + stack);
    }

}
