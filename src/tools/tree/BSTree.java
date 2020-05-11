package tools.tree;


import tools.array.Array;
import tools.array.ArrayStack;

import java.util.function.Consumer;

/**
 * 二分搜索树，
 * 存放的数据要求有可比较性（实现comparable接口）
 * 自动忽略重复的元素
 *
 * @param <E>
 */
public class BSTree<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

    }

    private Node root;
    private int size;

    public BSTree() {
        root = null;
        size = 0;
    }

    //    添加节点
//    与下方的方法一起使用
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        }
        else
            add(root, e);
//        root=add(root, e);
//        size++;
    }

    //    此递归函数的意义是:
//    与传入的节点比较，如果条件允许则添加节点
//    个人写法，确保传入的节点不为空
    private void add(Node node, E e) {
        if (e.compareTo(node.e) < 0) {
            if (node.left == null) {
                size++;
                node.left = new Node(e);
            } else
                add(node.left, e);
        } else if (e.compareTo(node.e) > 0)
            if (node.right == null) {
                size++;
                node.right = new Node(e);
            } else
                add(node.right, e);
        else
//            throw new IllegalArgumentException("添加节点失败，相同节点已存在");
//            元素相同直接不添加即可
            return;
    }

//    改良版：将root节点统一，并且化简判断逻辑
//    递归逻辑：
//    往以指定节点的子树（包括自身）添加节点，并将该添加的节点返回上一级
//    简化的逻辑会增加时间复杂度：每次添加新元素时，都会将遍历过的节点重新赋值给上一级
    /*private Node add(Node node,E e){
//        如果传入的节点为空，则在此处建立新节点
        if (node==null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e)<0)
            node.left=add(node.left,e);
        else if (e.compareTo(node.e)>0)
            node.right=add(node.right,e);

        return node;
    }*/

    //    判断是否包含某个元素（搜索树）
    public boolean contains(E e) {
        return contains(root, e);
    }

    //    判断以该节点（包含）的子树是否包含某个元素
//    这是一棵二分搜索树，如果在可能方向搜索，结果是没有，那么就是没有
//    对于这种结构，不需要访问所有的节点便可以作出判断
    private boolean contains(Node node, E e) {
//        如果上级指示的范围是null，则表明不存在
        if (node == null)
            return false;

//        如果相等，直接返回存在
        if (node.e.equals(e))
            return true;
//        如果在范围在左子树，返回左子树是否包含
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
//        如果范围在右子树，返回右子树是否包含
            return contains(node.right, e);

    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BSTree: size=" + size + System.lineSeparator());
        traverse(root,builder);

        return builder.toString();
    }


    public void printTree() {

        System.out.print("BSTree: size=" + size + System.lineSeparator());
        traverse(root, 0);


        System.out.print(System.lineSeparator());
    }


//    中序遍历
    private void traverse(Node node, int step) {
        if (node == null)
            return;
//        打印左子树
        traverse(node.left, step+1);
        for (int i=0;i<step;i++)
            System.out.print('-');
        System.out.println(node.e);
//        打印右子树
        traverse(node.right, step+1);
    }
    private void traverse(Node node,StringBuilder builder) {
        if (node==null)
            return;

        traverse(node.left,builder);
        builder.append(node.e.toString()+' ');
        traverse(node.right,builder);
    }

//    先序遍历，不使用递归
    public void preOrder(){
        ArrayStack<Node> stack = new ArrayStack<>();
//        Node push=root;
        Node pop;
        stack.push(root);
        for (int i = 0; i < size; i++) {
            pop=stack.pop();
            System.out.println(pop.e);
            if (pop.right!=null)
                stack.push(pop.right);
            if(pop.left!=null)
                stack.push(pop.left);
        }
    }

//    层序遍历
    public void sequence(){
        Array<Node> array = new Array<>();
        array.addLast(root);
        while (array.getSize()!=0){
            Array<Node> step = new Array<>();
//            操作当前层（打印）
//            并且将下一层 的数据装填到另一个数组
            for (int i=0;i<array.getSize();i++) {
                System.out.print(array.get(i).e.toString()+' ');
                if (array.get(i).left!=null)
                    step.addLast(array.get(i).left);
                if (array.get(i).right!=null)
                    step.addLast(array.get(i).right);
            };
//            将array指向下一层数组
            array=step;
            System.out.println();

        }
    }
}
