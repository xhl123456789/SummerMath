package SummerMath;

public class ArrayQueue {
    //用数组实现一个队列
    private int size = 0;
    private int[] arr;
    private int head = 0;
    private int rail = 0;

    public ArrayQueue(int initsize){
        this.arr = new int[initsize];
    }
    public ArrayQueue(){
        this.arr = new int[10];
    }

    public void push(int value){
        if(size  == arr.length -1){
            throw new RuntimeException("queue full");
        }
        arr[rail] = value;
        if(rail + 1 == arr.length){
            rail = 0;
        }
        size++;
    }
    public int pop(){
        if(size == 0){
            throw new RuntimeException("queue empty");
        }
        size--;
        int res = arr[head];
        if(head+1 == arr.length){
            head = 0;
        }
        return res;
    }
    public int peek(){
        if(size == 0){
            throw new RuntimeException("queue empty");
        }
        return arr[head];
    }

}
