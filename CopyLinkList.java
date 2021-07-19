package SummerMath;

import java.util.HashMap;

public class CopyLinkList {
    //链表的深度拷贝，意思是这里并不是简单的单向链表，除了有个next指针域以外还有一个random指针域，指向其它的结点，随机的
    //第一种方法，用哈希表,遍历链表
    public static RandomNode CopyList(RandomNode head){
        if(head == null){
            return null;
        }
        HashMap<RandomNode,RandomNode> map = new HashMap<>();
        RandomNode cur = head;
        while(cur != null){   //遍历链表，创建新的结点放进map中
            map.put(cur,new RandomNode(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next); //新节点的next 等于 原链表的next对应的的新节点
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }
    //第二种实现方式，不用hashmap
    /**
     * 把拷贝的结点挂在原来结点的后面,然后根据原链表的随机结点连好random
     * 然后在进行分割
     */
    public static RandomNode CopyList2(RandomNode head){
        if(head == null){
            return  null;
        }
        RandomNode cur = head;
        RandomNode next;
        while(cur != null){ //第一次循环把新建的结点挂在原结点的后面
            next = cur.next;
            cur.next = new RandomNode(cur.val);
            cur.next.next = next;
            cur = next;
        }
        //第二次循环，拷贝Random
        cur = head;
        while(cur != null){
            if(cur.rand != null){
                cur.next.rand = cur.rand.next;
            }else{
                cur.next.rand = null;
            }
            cur = cur.next.next;
        }
        //然后进行分割
        cur = head;
        RandomNode newHead = cur.next;
        RandomNode newCur = newHead;
        while(newCur.next.next != null){
            //cur = cur.next.next;
            newCur.next = newCur.next.next;
            newCur = newCur.next.next;
        }
        newCur.next = null;
        return  newHead;
    }

    public static void printRandLinkedList(RandomNode head) {
        RandomNode cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RandomNode head = null;
        RandomNode res1 = null;
        RandomNode res2 = null;
        printRandLinkedList(head);
        res1 = CopyList(head);
        printRandLinkedList(res1);
        res2 = CopyList2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new RandomNode(1);
        head.next = new RandomNode(2);
        head.next.next = new RandomNode(3);
        head.next.next.next = new RandomNode(4);
        head.next.next.next.next = new RandomNode(5);
        head.next.next.next.next.next = new RandomNode(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = CopyList(head);
        printRandLinkedList(res1);
        res2 = CopyList2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }

}
class RandomNode{
    public int val;
    public RandomNode next;
    public RandomNode rand;

    public RandomNode(int val){
        this.val = val;
    }
}