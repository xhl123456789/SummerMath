package SummerMath;

//用数组实现一个栈
public class ArrayStack {
    private int size;
    private int[] arr;
    private int t;

    public ArrayStack(int size){
        this.size = size;
        arr = new int[size];
        t = 0;
    }
    public ArrayStack(){
        this.size = 10;
        arr = new int[size];
        t = 0;
    }
    public void push(int value){
        if(t >= size){
            throw new RuntimeException("stack full");
        }
        arr[t++] = value;
    }
    public int pop(){
        if(t < 0){
            throw new RuntimeException("stack empty");
        }
        return arr[t--];
    }
}
