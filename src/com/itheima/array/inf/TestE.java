package com.itheima.array.inf;

/**
 * @author zhai
 * @date 2024/1/19 3:45 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class TestE {

    public static void main(String[] args) {
        ListE<String> list = new ArrayListE<String>();
        //添加数据
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println("索引为4的元素:" + list.get(4));
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        //再添就要扩容了
        list.add("11");
        System.out.println("size=" + list.size() + "‐‐" + list);
        System.out.println("是否包含8:" + list.contains("8") + ",集合容器是否为空:" + list.isEmpty());
        list.add("12");
        list.add("13");
        list.add("14");
        list.add("15");
        //既要扩容，元素又要后移
        list.add(13, "141");
        System.out.println("size=" + list.size() + "‐‐" + list);
        String set = list.set(13, "142");
        System.out.println("set方法返回的值:" + set + "‐‐完成后的list:" + list);
        String remove = list.remove(13);
        System.out.println("remove方法返回的值:" + remove + "‐‐remove后的list:" + list);
        list.clear();
        System.out.println("clear之后:" + list);
    }
}
