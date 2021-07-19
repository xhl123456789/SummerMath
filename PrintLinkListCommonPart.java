package SummerMath;

public class PrintLinkListCommonPart {
    //这里的公告部分是指两个链表里面所有相同的数
    public static void  printList(Node head1,Node head2){
        Node h1 = head1;
        Node h2 = head1;
        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                h1 = h1.next;
            }else if(h2.val < h1.val){
                h2 = h2.next;
            }else {
                System.out.print(h1.val+" ");
                h1 = h1.next;
                h2 = h2.next;
            }
        }
        System.out.println();
    }
}
class Node{
    public Node next;
    public int val;
    public  Node(int val){
        this.val = val;
    }
}
