package Model.ADT;

import java.util.Stack;

public interface MyIStack<T> {
//    int size();
    boolean isEmpty();
    T pop();
    void push(T val);
    Stack<T> getElems();
}
