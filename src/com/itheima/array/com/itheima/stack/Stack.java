package com.itheima.array.com.itheima.stack;

import java.util.Arrays;

/**
 * @author zhai
 * @date 2024/1/25 6:36 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Stack<E> {


    Object[] elementData;

    int elementCount;

    public Stack(int capacity) {
        this.elementData = new Object[capacity];
    }

    public Stack() {
        this(10);
    }


    public int size() {
        return elementCount;
    }

    public boolean empty() {
        return elementCount == 0;
    }


    public E push(E item) {
        ensureCapacity(elementCount + 1);
        this.elementData[elementCount++] = item;
        return item;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > this.elementData.length) {
            grow(minCapacity);
        }

    }

    private void grow(int minCapacity) {
        int oldCapacity = this.elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (minCapacity > newCapacity) {
            newCapacity = minCapacity;
        }
        this.elementData = Arrays.copyOf(this.elementData, newCapacity);
    }


    public E peek() {
        int len = size();
        if (len == 0) {
            return null;
        }
        return elementAt(len - 1);
    }

    private E elementAt(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }

    public E pop() {
        E peek = peek();
        int len = size();
        removeElementAt(len - 1);
        return peek;
    }

    private void removeElementAt(int index) {
        rangeCheck(index);
        if (index < this.elementCount - 1) {
            System.arraycopy(this.elementData, index + 1, this.elementData, index, this.elementCount - 1);
        }
        elementCount--;
        elementData[elementCount] = null;
    }


    public void rangeCheck(int index) {
        if (index < 0 || index > elementCount) {
            throw new IndexOutOfBoundsException("index=" + index + ",elementCount=" + this.elementCount);
        }
    }


    public String toString() { //将栈中元素按照[1,2,3,4]形式打印
        StringBuilder stringBuilder = new StringBuilder("["); for (int i=0;i<this.elementCount;i++){
            stringBuilder.append(this.elementData[i]).append(",");
        }
        return stringBuilder.append("]").toString();
    }
}
