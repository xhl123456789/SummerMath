package SummerMath;

import java.util.Stack;

public class JudgeLinkListHuiWen {
    //判断一个链表是否是会问结构
    //所谓回文结构就是正着读跟反着读是一样的
    //最简单的方法是用栈
    public static boolean judgeHuiWen(Node head){
        if(head == null){
            return false;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while(cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            if(stack.pop().val == cur.val){
                cur = cur.next;
            }else {
                return false;
            }
        }
        return true;
    }
    //第二种方法是用两个指针 如果链表的结点个数是偶数个直接指向前一个
    //我的思想是这样的，慢指针后面的入栈
    public static boolean judgeHuiWen2(Node head){
        Stack<Node> stack = new Stack<>();
        Node fast = head;
        Node slow = head;
        boolean help = false; // true 为偶数个
        while(fast.next != null &&fast.next.next != null){  //只要后面这一个可能会跑NullPointException
            fast = fast.next.next;//一次走两步
            slow = slow.next;
        }
        if(fast.next == null){
            help = true;  //偶数个
        }
        //此时的慢指针已经指向中间，但是奇数个跟偶数个怎么判断？
        while(slow!=null){
            if(help){
                slow = slow.next;
            }
            stack.push(slow);
            slow = slow.next;
        }
        while(!stack.isEmpty()){
            if(head.val == stack.pop().val){
                head = head.next;
            }else {
                return false;
            }
        }
        return true;
    }
    /**
     *    第三种方法改链表结构，不需要额外的空间
     *    快慢指针遍历，找到中点，中点指向NULL,中点后面的方向，两边同时向中间遍历并进行比较
     */

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        System.out.println(judgeHuiWen2(head));
    }
}
