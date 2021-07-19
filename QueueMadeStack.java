package SummerMath;

import com.sun.org.apache.xpath.internal.operations.Bool;
import sun.misc.Queue;

import java.util.Enumeration;

public class QueueMadeStack {
    //用队列实现一个栈的功能
    //直接用两个队列实现一个栈，直接把第一个队列的最后一个数保留下来其余的全部放到另一个队列
    //然后取出或查看后又放回去
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public QueueMadeStack(){
        this.queue1 = new Queue<>();
        this.queue2 = new Queue<>();
    }
    public int getQueueLen(Queue queue){
        int count = 0;
        Enumeration er = null;
        synchronized (this)
        {
            er = queue.elements();

            while (er.hasMoreElements())
            {
                count++;
            }
        }
        return count;
    }
    public void push(int value){
      queue1.enqueue(value);
    }
    public int pop() throws InterruptedException {
        if(queue1.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        while(getQueueLen(queue1) > 1) {
            queue2.enqueue(queue1.dequeue());
        }
        int res = queue1.dequeue();
        while(getQueueLen(queue2) >= 0) {
            queue1.enqueue(queue2.dequeue());
        }
        return res;
    }
    public int peek() throws InterruptedException {
        if(queue1.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        while(getQueueLen(queue1) > 1) {
            queue2.enqueue(queue1.dequeue());
        }
        int res = queue1.dequeue();
        queue2.enqueue(res);
        while(getQueueLen(queue2) >= 0) {
            queue1.enqueue(queue2.dequeue());
        }
        return res;

    }

}
