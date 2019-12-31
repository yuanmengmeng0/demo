package duilie;/*
 * @author  yuan meng meng
 * @description:
 * @date 2019/12/30
 * */

import java.util.LinkedList;

public class MyStack<T> {
    private LinkedList<T> storage = new LinkedList<>();
    public synchronized void push(T e){
        storage.addFirst(e);
    }

    public T peek(){
        return storage.getFirst();
    }
    public void pop(){
        storage.removeFirst();
    }
    public boolean empty(){
        return storage.isEmpty();
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}
