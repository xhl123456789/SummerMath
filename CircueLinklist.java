package SummerMath;

import java.util.HashMap;

public class CircueLinklist {
    /**题目：在本题中单链表可能有环也有可能无环。给定两个单链表的头结点head1和head2这两个链表可能
     * 相交也可能不相交。请实现一个函数，如果两个链表相交，请返回相交的第一个结点，不相交返回Null即可。
     * 如果链表一的长度为N，链表二的长度为M时间复杂度O（N+M），额外空间复杂度O（1）
     *
     *判断两个链表是否相交:
     * 1,首先判断有环无环，两种方法(1)用额外空间hashmap(2)第二种放法快慢指针
     * 2,判断两个链表是否相交.分三种情况
     * (1)一个有环一个无环  //这种情况不可能相交，因为无环的最后一个节点指针域为null不可能在里面存在的
     * (2)两个有环   相交点在环外：入环之前的差值        相交点在环上：看在一个环里面能否找到第二个链表的入环结点，找到就相交，找不到就是没交
     * （3）两个无环  直接用链表长度减，然后走差值个结点就是相交的结点
     */

    //判断链表有环无环，利用hashmap？有一个方法containsKey
    public static boolean IsCircueLinkList(Node head){
        if(head == null){
            return false;
        }
        Node cur = head.next;
        HashMap<Node,Integer> hashMap = new HashMap();
        hashMap.put(head,head.val);
        while(cur != null){
            if(hashMap.containsKey(cur)){
                return true;
            }
            hashMap.put(cur,cur.val);
            cur = cur.next;
        }
        return false;
    }
    //第二种判断方法，快慢指针
    /**
     * 两个指针，一个一次走一步，一个一次走两部，如果有环，那么两个指针会相遇
     * 相遇之后，快指针回到原点，两个一起走一次一步，然后会在环点相遇
     */
    public static Node IsCircueLinkList2(Node head) {
        if(head.next == null || head == null || head.next.next == null){
            return null;
        }
        Node fast = head.next.next;
        Node slow = head.next;
        while(slow != fast){   //第一次循环找到相同的结点
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while(fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        Node node = fast; //相交的环点ssss
        return node;
    }

    public static Node IsChangde(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        //首先判断两个链表有环无环
        //首先判断两个链表有环无环
        Node node1 = IsCircueLinkList2(head1);
        Node node2 = IsCircueLinkList2(head2);
        if((node1==null && node2!=null) || (node2==null && node1!=null)){ //一个有环一个无环
            return null;
        }else if(node1 == null && node2 == null){ //两个都是无环的
            return bothNoCir(head1,head2);
        }else { //两个都是有环
            return BothCir(head1,head2,node1,node2);
        }
    }
    /** 两个链表都无环
     * 由于它们的最后一个结点的指针域为null，所以我们需要获取两个链表的长度一减就可以知道相交结点在哪里了
     */
    public static Node bothNoCir(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node cur = head1;
        int num = 0;
        while(cur !=null){
            num++;
            cur = cur.next;
        }
        cur = head2;
        while(cur !=null){
            num--;
            cur = cur.next;
        }
        if(num == 0){
            cur = head1;
        }else if(num > 0){
            cur = head1;
            while(num >= 0){
                cur = cur.next;
                num--;
            }
        }else {
            cur = head2;
            num = Math.abs(num);
            while(num >= 0){
                cur = cur.next;
                num--;
            }
        }
        return cur;
    }
    /**
     * 又要分三种情况，
     * (1)两个都有环但是都没有相交
     * (2)在入环前就相交
     * (3)在环上分两个支出来
     */
    public static Node BothCir(Node head1,Node head2,Node loop1,Node loop2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        //首先判断loop1和loop2相等就是第二种情况
        if(loop1 == loop2){
            int n = 0;
            while(cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while(cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }
            if(n == 0){
                return head1;
            }else if(n > 0){
                cur1 = head1;
                while(n >= 0){
                    cur1 = cur1.next;
                    n--;
                }
            }else {
                 cur1 = head2;
                n = Math.abs(n);
                while(n >= 0){
                    cur1 = cur1.next;
                    n--;
                }
            }
            return cur1;
        }else{ //没有相等的结点就有可能是第一种情况，或者第三种情况
            //如果有相交的话其中一个链表的环肯定包含第二个链表的入环结点
            cur1 = loop1;
            while(cur1 != loop2){
                cur1 = cur1.next;
            }
            if(cur1 == loop2)
                return cur1;
            else
                return null;
        }
    }
    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(IsChangde(head1, head2).val);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(IsChangde(head1, head2).val);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(IsChangde(head1, head2).val);

    }
}