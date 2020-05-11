package tools.array;

import tools.Stack;

/**
 * 基于Array实现的栈，支持自动扩容
 * 使用该实现类表明栈中元素不可见，只能访问尾部
 *
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;

    //  确定容量的栈
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    //  默认容量的栈（10）
    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Stack : 容量：" + getCapacity() + " 大小：" + getSize() + " 数据：");
//        builder.append("['");
        for (int i = 0; i < array.getSize(); i++) {
            builder.append(array.get(i));
            if (i != array.getSize() - 1) {
                builder.append(',');
            }
        }
        builder.append(" <-top");

        return builder.toString();
    }
}
