import org.junit.Test;
import test.Sum;
import test.Test20;
import tools.Queue;
import tools.Stack;
import tools.array.*;
import tools.list.LinkedList;
import tools.list.LinkedListStack;
import tools.list.LinkedQueue;
import tools.tree.BSTree;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        Array<Integer> array = new Array(20);
        for(int i=0;i<10;i++){
            array.addLast(i);
        }
//        System.out.println(array.remove(3));
        array.addLast(4);
//        array.removeAllElement(4);
        array.removeAllElement(4);
        System.out.println(array);
//        System.out.println(array.find(4));
//        System.out.println(array);
    }
    @Test
    public void test1(){
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 25; i++) {
            array.addLast(i);
        }
        System.out.println(array);
    }
    @Test
    public void test2(){
        Array<Integer> array = new Array<>();
        for (int i=0;i<=10;i++)
            array.addLast(i);
        for(int i=0;i<7;i++)
            array.removeLast();
        System.out.println(array);
    }
    @Test
    public void test3(){
        Stack<Integer> stack = new LinkedListStack<>();
        for (int i=0;i<5;i++)
            stack.push(i);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
    @Test
    public void test4(){
        Test20 test20 = new Test20();
        System.out.println(test20.judge("[{}]({}[][](({}}{{{})"));
    }
    public static double judgeQueue(Queue<Integer> queue, int testLength) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < testLength; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i=0;i<testLength;i++)
            queue.dequeue();

        long endTime = System.nanoTime();

        return (endTime-startTime)/1000000000.0;
    }

    @Test
    public void test5(){
        int testLength=100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double res1 = judgeQueue(arrayQueue, testLength);
        System.out.println("ArrayQueue: "+res1+"s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double res2 = judgeQueue(loopQueue, testLength);
        System.out.println("LoopQueue: "+res2+"s");
    }

    @Test
    public void test6(){
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0;i<10;i++)
            list.addFirst(i);
        System.out.println(list);

        list.add(5,1000);
        System.out.println(list);

        list.delFirst();
        System.out.println(list);
        list.delNode(2);
        System.out.println(list);
    }

    @Test
    public void test7(){
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        for (int i=0;i<10;i++)
            linkedQueue.enqueue(i);
        linkedQueue.dequeue();
        System.out.println(linkedQueue);
    }

    @Test
    public void test8(){
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        System.out.println(Sum.sum(arr));
    }

    @Test
    public void test9(){
        BSTree<Integer> bsTree = new BSTree<>();
        bsTree.add(5);
//        bsTree.printTree();
        bsTree.add(3);
//        bsTree.printTree();
        bsTree.add(2);
        bsTree.add(4);
        bsTree.add(7);
        bsTree.add(9);
        bsTree.add(10);
        bsTree.add(11);
        bsTree.add(12);
        bsTree.add(12);
        bsTree.add(13);
        bsTree.add(14);
        bsTree.add(6);
        bsTree.add(8);
//        System.out.println(bsTree);
//        bsTree.preOrder();
//        System.out.println(bsTree.contains(8));
        bsTree.sequence();
    }
}
