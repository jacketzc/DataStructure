package tools.array;

import java.util.Objects;


/**
 * 可扩容数组
 * Array类本身就是一个数组
 * 如果Array为空，那么会弹出异常
 *
 * @param <E>
 */
public class Array<E> {
    private E[] data;
    //  size为数组中第一个没有元素的位置
    private int size;

    /**
     * @param capacity 希望的初始容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
//        data=new E[10];
        this(10);
    }

    //  获取数组中的元素个数
    public int getSize() {
        return size;
    }

    //  获取数组长度
    public int getCapacity() {
        return data.length;
    }

    //  判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //  往数组末尾添加参数
    public void addLast(E e) {
        add(size, e);
    }

    //  往数组头添加参数
    public void addFirst(E e) {
        add(0, e);
    }

    //  往数组中插入元素，index表示要插入的下标
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index需要>0并且<index");
        if (size == data.length)
            reSize(2 * data.length);
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //  获取该索引处的值
    public E get(int index) {
        if (index == size)
            throw new IllegalArgumentException("数组为空，无法取值");
        if (index < 0 || index > size)
            throw new IllegalArgumentException("索引小于0或者超过size");
        return data[index];
    }

    //  重新设置该索引处的值
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("索引小于0或者超过size");
        data[index] = e;
    }

    //  查询是否包含
    public boolean contains(E e) {
        for (int i = 0; i <= size; i++) {
            if (e == data[i])
                return true;
        }
        return false;
    }

    //  查询索引(第一个)，如果找不到，返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (e == data[i])
                return i;
        }
        return -1;
    }

    /*public E test(E e){
        E i=0;
        E index=find(e);
        while (index!=-1){
            i++;
            remove(index);
            find(e);
        }
        return i;
    }*/
//  删除元素(根据索引)
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("索引小于0或者超过size");
        E ret = data[index];
        for (int i = index; i < size - 1; i++)
            data[i] = data[i + 1];
        size--;
        data[size] = null;//去除loitering对象
//        当容器中元素个数不足容器大小的四分之一时，触发缩容，缩为原来的一半
//        为了避免频繁地缩容，设置缩容的临界值为10
        if (size < data.length / 4 && data.length > 10)
            reSize(data.length / 2);
        return ret;
    }

    //  删除第一个
    public E removeFirst() {
        return remove(0);
    }

    //  删除最后一个
    public E removeLast() {
        return remove(size - 1);
    }

    //  删除某个元素(所有)
    public void removeAllElement(E e) {
        int index = find(e);
        while (index != -1) {
            System.out.println(toString());
            remove(index);
            index = find(e);
        }
    }

    //  删除某个元素（第一个）
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    //  扩容数组的方法
    private void reSize(int capacity) {
        if (capacity < data.length)
            System.out.println("容器已被缩小，容量：" + capacity);
        else
            System.out.println("容器已被扩大，容量：" + capacity);
        E[] rs = (E[]) new Object[capacity];
        System.arraycopy(data, 0, rs, 0, size);
        data = rs;

    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("tools.array.Array:size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != (size - 1))
                res.append(',');
        }
        res.append(']');
        return res.toString();
    }
}

