package SummerMath;

public class NetherLandFlagLinkList {
    //关于链表的荷兰国旗问题，主要是用到三个链表.，大于，等于，小于
    public static Node netherLandFlag(Node head,int num){
        Node moreHead = null;
        Node moreCur = null;
        Node equaHead= null;
        Node equalCur = null ;
        Node lessHead= null;
        Node lessCur = null;
        Node cur = head;
        while(cur != null){
            if(cur.val > num){
                if(moreHead == null){
                    moreHead = new Node(cur.val);
                    moreCur = moreHead;
                }else {
                    moreCur.next = new Node(cur.val);
                    moreCur = moreCur.next;
                }
            }else if(cur.val < num){
                if(lessHead == null){
                   lessHead = new Node(cur.val);
                   lessCur = lessHead;
                }else {
                    lessCur.next = new Node(cur.val);
                    lessCur = lessCur.next;
                }
            }else {
                if(equaHead == null){
                    equaHead = new Node(cur.val);
                    equalCur = equaHead;
                }else {
                    equalCur.next = new Node(cur.val);
                    equalCur = equalCur.next;
                }
            }
            cur = cur.next;
        }
        //合并三个链表
        lessCur.next = equaHead;
        equalCur.next = moreHead;

        return lessHead;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
       printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = netherLandFlag(head1, 5);
        printLinkedList(head1);

    }
}
