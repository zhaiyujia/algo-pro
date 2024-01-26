package com.itheima.array.com.itheima.stack;

/**
 * @author zhai
 * @date 2024/1/26 4:19 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class LinkedListStack<E> {

    private int size = 0;

    private ListNode<E> head;

    /**
     * 返回栈中元素个数
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean empty() {
        return size == 0;
    }

    /**
     * 将元素压入栈
     *
     * @param item 被存入栈的元素 * @return
     */
    public E push(E item) {
        ListNode<E> node = new ListNode(item, head);
        head = node;
        size++;
        return item;
    }

    /**
     * 获取栈顶元素，但并不移除，如果栈空则返回null * @return
     */
    public E peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }

    /**
     * 移除栈顶元素并返回，如果栈为空则返回null
     *
     * @return
     */
    public E pop() {
        if (head == null) {
            return null;
        }
        ListNode<E> top = head;
        head = head.next;
        top.next = null;
        size--;
        return top.val;
    }

    static class ListNode<E> {
        private E val;
        private ListNode<E> next;

        public ListNode(E val, ListNode<E> next) {
            this.val = val;
            this.next = next;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode<E> curr = head;
        while (curr != null){
            sb.append(curr.val).append("->");
            curr = curr.next;
        }
        return sb.append("null").toString();
    }


}
