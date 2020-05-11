package tools.list;

import tools.Queue;

/**
 * (并非直接使用LinkedList)
 * 链表实现的队列
 * 新增一个域记录尾部的位置，此位置作为队列的front，链表的头部作为队列的尾部
 * //因为是单向链表，所以head处元素添加和删除都是O(1)，而尾部即使添加记录，但是删除操作仍然是O(n)
 *
 * @param <E>
 */
public class LinkedQueue<E> implements Queue<E> {

    private class Node {

        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }

    private Node front;
    private Node tail;
    private int size;

    public LinkedQueue() {
        tail = null;
        front = null;
        size = 0;
    }

    //    看上去是尾进头出，但用起来就是一端进，一端出
    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            front = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("出队失败，该队列为空");
        Node res = front;
        front = front.next;
        res.next = null;

//        如果出队后队列为空，则需要再维护一下队尾
        if (front == null)
            tail = null;

        size--;
        return res.e;
    }

    @Override
    public E getFront() {
        return front.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LinkedQueue : size="+getSize()+" tail<-");
        Node node = front;
        while (node != null) {
            builder.append(node.e);
            builder.append("<-");
            node = node.next;
        }
        builder.append("front");
        return builder.toString();
    }
}
