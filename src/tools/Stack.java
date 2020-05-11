package tools;

public interface Stack<E> {
    int getSize();
    boolean isEmpty();
//    堆栈
    void push(E e);

    //    出栈
    E pop();
//    查看栈顶
    E peek();
}
