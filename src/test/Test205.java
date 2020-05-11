package test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */



public class Test205 {
    public ListNode removeElements(ListNode head, int val) {
//        对头部单独考察，确保头部没有匹配值
//        也可以采用虚拟头结点，这样就不需要单独考虑头部
//        此方案并没有考虑内存回收
        while (head!=null&&head.val==val){
            head=head.next;
        }
        ListNode node=head;
        while (node!=null&&node.next!=null){
            if (node.next.val==val)
                node.next=node.next.next;
            else
                node=node.next;
        }
        return head;
    }

//    另一种解决删除链表中数据的解决方案，使用递归
//    这个递归方法的语义为：删除以head作为头结点中的val元素，并返回头结点
    public ListNode removeNodes(ListNode head,int val){
//        终结方法
        if (head==null)
            return null;
//        原子问题part2：删除head.next作为头结点中的val元素，并返回头结点
        head.next = removeNodes(head.next, val);
//        原子问题part1：查看当前头结点是否符合要求
//        if (head.val == val) {
//            return head.next;
//        } else {
//
//            return head;
//        }
//        上方的判断语句可以简写为下面的话
        return head.val==val?head.next:head;

//        return removeNodes(head.next,val);
    }
}
