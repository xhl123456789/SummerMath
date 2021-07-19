package SummerMath;

import java.util.Stack;

public class GetMinStack {
    //实现一个特殊的栈，在实现栈的基本功能上，额外实现获取栈中的最小元素的功能
    //操作时间复杂度都是O（1），可以实现现成得到栈。

    //直接用两个栈
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public GetMinStack(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int value){
        stack1.push(value);
        if(stack2.isEmpty()){
            stack2.push(value);
        }else if(value > stack2.peek()){
            stack2.push(stack2.peek());
        }else {
            stack2.push(value);
        }
    }
    public int pop(){
        if(stack1.isEmpty()){
            throw new RuntimeException("stack empty");
        }
        stack2.pop();
        return stack1.pop();
    }
    public int getMin(){
        return stack2.peek();
    }
}
