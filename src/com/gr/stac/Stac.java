package com.gr.stac;

public class Stac {
    private int maxSize;
    private int[] arr;
    private int top = -1;

    public Stac(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean full() {
        return top == maxSize - 1;
    }

    public boolean empty() {
        return top == -1;
    }

    public void push(int value) {
        if (full()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        arr[top] = value;
    }

    public int pop() {
        if (empty()) {
            throw new RuntimeException("空栈！");
        }
        int value = arr[top];
        top--;
        return value;
    }
    public int japop(){
        if (empty()) {
            throw new RuntimeException("空栈！");
        }
        int value = arr[top];
        return value;
    }
    public void show(){
        if (empty()){
            throw new RuntimeException("空栈");
        }
        for (int i = top ;i>=0;i--){
            System.out.println(arr[i]);
        }
    }
}
