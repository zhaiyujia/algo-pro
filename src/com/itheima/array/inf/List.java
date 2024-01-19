package com.itheima.array.inf;

/**
 * @author zhai
 * @date 2024/1/19 3:05 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public interface List {


    /**
     * 返回容器中元素的个数 * @return
     */
    int size();

    /**
     * 判断容器是否为空 * @return
     */
    boolean isEmpty();

    /**
     * 查询元素在容器中的索引下标
     *
     * @param o 元素对象
     * @return 在容器中的下标 不存在则返回‐1
     */
    int indexOf(int o);

    /**
     * 判断容器是否包含某个特定的元素 * @param e
     *
     * @return
     */
    boolean contains(int e);

    /**
     * 将元素添加到容器结尾 * @param e 要添加的元素 * @return 是否添加成功
     */
    boolean add(int e);

    /**
     * 向指定位置添加元素，该位置及以后的元素后移 * @param index 位置下标
     *
     * @param element 元素对象
     */
    void add(int index, int element);

    /**
     * 用指定的元素替换指定位置的数据
     *
     * @param index
     * @param element
     * @return
     */

    int set(int index, int element);

    /**
     * 获取指定位置的元素
     *
     * @param index 索引下标
     * @return 该位置的元素
     */
    int get(int index);

    /**
     * 移除指定位置的元素
     *
     * @param index 索引下标
     * @return 被移除的元素
     */
    int remove(int index);

    /**
     * 清除容器中所有元素
     */
    void clear();

}
