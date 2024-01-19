package com.itheima.array.inf;


/**
 * @author zhai
 * @date 2024/1/19 3:06 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class ArrayList implements List {

    // 存储数据的数组
    private int[] elementData;

    // 实际数据长度,代表容器中元素的个数
    private int size;

    // 默认初始容量
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this.elementData = new int[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("init error capacity=" + capacity);
        }
        this.elementData = new int[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        // 元素个数为0
        return size == 0;
    }

    @Override
    public int indexOf(int o) {
        for (int i = 0; i < size; i++) {
            if (this.elementData[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(int e) {
        return indexOf(e) > -1;
    }

    @Override
    public boolean add(int e) {
        // check 容量
        ensureCapacity(size + 1);
        // 赋值
        this.elementData[size++] = e;
        // 返回结果
        return true;
    }

    // 确保容量可以存储
    private void ensureCapacity(int minCapacity) {
        int currentCapacity = this.elementData.length;
        // 大于当前容量进行扩容
        if (minCapacity > this.elementData.length) {
            // 进行1.5倍的扩容

            // 扩容
            grow(minCapacity);
        }
    }

    // 增长容量
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
        int[] elementData = new int[newCapacity];
        // copy 老数组元素到新的数组里面
        System.arraycopy(this.elementData, 0, elementData, 0, size);
        // 将数组指向新定义的数组
        this.elementData = elementData;
    }

    @Override
    public void add(int index, int element) {
        // 检查索引下标
        rangeCheck(index);
        // 保证容量
        ensureCapacity(size + 1);
        // 移动数组
        // size = 6
        // [1,2,3,4,5,6]
        // [0,1,2,3,4,5]
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
    public int set(int index, int element) {
        rangeCheck(index);
        int oldValue = this.elementData[index];
        this.elementData[index] = element;
        return this.elementData[index];
    }

    @Override
    public int get(int index) {
        rangeCheck(index);
        return this.elementData[index];
    }

    @Override
    public int remove(int index) {
        rangeCheck(index);
        // size = 6
        // [1,2,3,4,5,6]
        // [0,1,2,3,4,5]
        int oldValue = this.elementData[index];
        System.arraycopy(this.elementData, index + 1, this.elementData, index, size - index - 1);
        this.elementData[size - 1] = 0;
        size--;
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
