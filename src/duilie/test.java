package duilie;

public class test{
    public static void main(String[] args)  {
        ArrayQueue queue = new ArrayQueue(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.show();
        System.out.println("取出的值:"+queue.get());
        System.out.println("取出的值:"+queue.get());
        System.out.println("取出的值:"+queue.get());
        System.out.println("取出的值:"+queue.get());
        queue.show();
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.show();
    }
}
class ArrayQueue {
    private Object[] arr;
    private int sta;
    private int las;
    private int maxSize;
    public ArrayQueue(int Size){
        this.maxSize = Size+1;
        arr = new Object[maxSize];
    }
    private boolean full(){
        return (las+1)%maxSize==sta;
    }
    private boolean empty(){
        return las == sta;
    }
    public void add(Object a){
        if (full()){
            System.out.println("队列已满");
            return;
        }
        arr[las] = a;
        las++;
        las = las%maxSize;
    }
    public Object get(){
        if (empty()){
            System.out.println("队列是空的");
            return null;
        }
        Object value = arr[sta];
        sta++;
        sta = sta%maxSize;
        return value;
    }
    public void show(){
        if (empty()) {
            System.out.println("队列是空的");
        }
        for (int i = sta;i<sta+(maxSize-sta+las)%maxSize;i++){
            System.out.printf("arr[%d] %d",i%maxSize,arr[i%maxSize]);
            System.out.printf(" ");
        }
        System.out.println();
    }
}
