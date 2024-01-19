package com.itheima.array.inf;


/**
 * @author zhai
 * @date 2024/1/19 3:06 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class ArrayListE<E> implements ListE<E> {

    // 存储数据的数组
    private Object[] elementData;

    // 实际数据长度,代表容器中元素的个数
    private int size;

    // 默认初始容量
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayListE() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public ArrayListE(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("init error capacity=" + capacity);
        }
        this.elementData = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(E o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (this.elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (this.elementData[i].equals(o)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    @Override
    public boolean add(E e) {
        // check 容量
        ensureCapacity(size + 1);
        this.elementData[size++] = e;
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        // 大于当前容量进行扩容
        if (minCapacity > this.elementData.length) {
            // 扩容
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        // 老数组的长度
        int oldCapacity = this.elementData.length;
        // 扩容后的长度
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        // 如果扩容后的长度还是小于需要的长度，则容量直接使用最小需要的长度
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        // 数组拷贝
        copy(newCapacity);
    }

    private void copy(int newCapacity) {
        // 定义新的数组
        Object[] elementData = new Object[newCapacity];
        // copy 老数组元素到新的数组里面
        System.arraycopy(this.elementData, 0, elementData, 0, size);
        // 将数组指向新定义的数组
        this.elementData = elementData;
    }


    @Override
    public void add(int index, E element) {
        // 检查索引下标
        rangeCheck(index);
        ensureCapacity(size + 1);
        System.arraycopy(this.elementData, index, this.elementData, index + 1, size - index);
        this.elementData[index] = element;
        size++;
    }

    // 检查索引下标
    private void rangeCheck(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index out of bound index=" + index + ", size=" + size);
        }
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E oldValue = elementData(index);
        this.elementData[index] = element;
        return oldValue;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    E elementData(int index) {
        return (E) elementData[index];
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        // size = 6
        // [1,2,3,4,5,6]
        // [0,1,2,3,4,5]
        E oldValue = elementData(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(this.elementData, index + 1, this.elementData, index, numMoved);
        }
        this.elementData[--size] = null;
        return oldValue;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            this.elementData[i] = 0;
        }
        size = 0;
    }

    @Override
    public String toString() { //按照[1,2,3,5,6]的格式输出数组中的元素
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(this.elementData[i]).append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
