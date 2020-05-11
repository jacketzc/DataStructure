package tools.list;

import tools.Stack;

/**
 * 链表实现的栈
 * 头部操作的时间复杂度为O(1)，尾部操作为O(n)
 *
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack(){
        list=new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.getSize()==0;
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.delFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append("LinkedListStack: top->");

        strBuilder.append(list.easyPrint());

        return strBuilder.toString();

    }
}
