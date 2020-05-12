package tools.array;

import tools.Queue;

/**
 * 队列，只关心队首的数据
 *
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array(capacity);
    }

    public ArrayQueue() {
        array = new Array();
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }
//    出队
    @Override
    public E dequeue() {
        return array.removeFirst();
    }
//    获取队首元素
    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ArrayQueue : 容量：" + getCapacity() + " 大小：" + getSize() + " 数据：");
        builder.append("top-> ");
        for (int i = 0; i < array.getSize(); i++) {
            builder.append(array.get(i));
            if (i != array.getSize() - 1) {
                builder.append(',');
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 8; i++)
            queue.enqueue(i);
        queue.dequeue();
        System.out.println(queue);
    }
}
