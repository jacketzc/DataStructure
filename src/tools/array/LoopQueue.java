package tools.array;

import tools.Queue;

/**
 * (并非直接使用Array类)
 * 循环队列，同时维护队首和队尾
 * front==tail视队列为空
 * (tail+1)/capacity==front视队列为满
 * 默认浪费一个空间并且不参与计数，capacity表达的是真实大小-1
 *
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {
    private E data[];
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    //    返回该队列的最大容量
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front)
            reSize(getCapacity() * 2);
        data[tail] = e;
//        System.out.println(toString());
        if (tail == data.length - 1)
            tail = 0;
        else
            tail++;
        size++;
    }

    @Override
    public E dequeue() {
        if (front == tail)
            throw new IllegalArgumentException("无法出队，队列为空！");
        E res = data[front];
        data[front] = null;
        if (front == data.length - 1)
            front = 0;
        else
            front++;
        size--;
        if (size == getCapacity() / 4 && size > 10)
            reSize(getCapacity() / 2);
        return res;
    }

    @Override
    public E getFront() {
        if (front == size)
            throw new IllegalArgumentException("队列为空，无法获取队首");
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public void reSize(int capacity) {
        if (capacity > data.length)
            System.out.println("队列已扩容，容量：" + capacity);
        else
            System.out.println("队列已缩容，容量：" + capacity);
        E[] es = (E[]) new Object[capacity + 1];
//        不管什么情况，都要把那个浪费掉的位置也填进去，所以复制长度为data.length而不是size
//        System.arraycopy(data,0,es,0,data.length);

//        事实上，不需要将数组完全复制，因为有值的部分是确定的
        for (int i = 0; i < size; i++)
            es[i] = data[(front + i) % data.length];
        front = 0;
        tail = size;
        data = es;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Queue : 容量：" + getCapacity() + " 大小：" + getSize() + " 数据：");
        builder.append("front-> ");
        for (int i = 0; i < size; i++) {
            builder.append(data[(front + i) % data.length]);
            if (i != size - 1) {
                builder.append(',');
            }
        }
        builder.append("<-tail");
        return builder.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> integerLoopQueue = new LoopQueue<>();
        for (int i = 10; i < 28; i++)
            integerLoopQueue.enqueue(i);
        integerLoopQueue.dequeue();
        integerLoopQueue.dequeue();
        integerLoopQueue.dequeue();
        integerLoopQueue.dequeue();
        System.out.println(integerLoopQueue);
    }
}
