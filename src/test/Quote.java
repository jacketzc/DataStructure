package test;

/**
 * 测试java传递引用时，传递的是一个引用的拷贝
 * 虽然两个引用指向同一个对象、可以操作同一个对象
 * 但是，将其中一个引用指向另一个对象的时候，另一个引用并不会受到影响
 * 
 */
public class Quote {
    private int i;

    public Quote(int t){
        this.i=t;
    }
    public Quote(){
        this(10);
    }

    public int getI() {
        return i;
    }
}
