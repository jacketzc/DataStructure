package tools.list;


/**
 * 链表，维护head与size
 * 使用虚拟头结点
 * 链表表明放弃对索引的需要，部分功能实际不会被使用到
 *
 * @param <E>
 */
public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        //        看起来的意思：创建一个节点，赋予节点数据，并且给出下一个节点的位置
//        实际上的意思：创建一个节点，赋予节点数据，并且将上一个节点作为此节点的next
//        “反向链表”
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

        @Override
        public String toString() {
            return e.toString();
        }
    }

    //    虚拟头节点，不赋值
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next=head;
//        head=node;

//        此行代码相当于上面的三行代码
//        head = new Node(e, head);
//        size++;
        add(0, e);
    }

    //    在指定位置插入节点（节点从0开始计算）
//    此方法并不常用
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("中间插入失败！插入的位置<0或者>=Size");

//        if (index==0)
//            addFirst(e);

        Node prev = dummyHead;
//        因为虚拟头结点的原因，开始的位置是-1，而不是0
        for (int i = -1; i < index - 1; i++)
            prev = prev.next;
//        Node node = new Node(e);
//        node.next=prev.next;
//        prev.next = node;

        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addLast(E e) {
//        Node prev=head;
//        for (int i=0;i<size;i++)
//            prev=prev.next;
//        prev.next = new Node(e);
//        size++;

        add(size, e);
    }

    private Node getNode(int index) {
        Node res = dummyHead;
        for (int i = -1; i < index; i++)
            res = res.next;
        return res;
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("获取失败！指引的位置<0或者>=Size");
        return getNode(index).e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void update(int index, E e) {
        Node node = getNode(index);
        node.e = e;
    }

    public boolean contains(E e) {
        Node res = dummyHead;
        for (int i = -1; i < size; i++) {
            if (res.next.e.equals(e))
                return true;
        }
        return false;
    }

    public E delNode(int index){
        if (index<0||index>=size)
            throw new IllegalArgumentException("删除失败，索引<0或者>=size");
        Node prev = getNode(index - 1);
        E res=prev.next.e;
        prev.next=prev.next.next;
        size--;
        return res;
    }
    public E delFirst(){
        return  delNode(0);
    }
    public E delLast(){
        return delNode(size-1);
    }

    public StringBuilder easyPrint(){
        StringBuilder strBuilder = new StringBuilder();
        Node node = dummyHead.next;
        while (node != null) {
            strBuilder.append(node.e);
            strBuilder.append("->");
            node = node.next;
        }

        strBuilder.append("null");
        return strBuilder;
    }


    @Override
    public String toString() {

        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append("LinkedList: size ="+getSize()+"head-> ");

        strBuilder.append(easyPrint());

        return strBuilder.toString();
    }
}
