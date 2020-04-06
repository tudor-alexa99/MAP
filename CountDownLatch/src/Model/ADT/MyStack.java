package Model.ADT;
import java.util.Stack;

public class MyStack<T> implements MyIStack<T>{
    private Stack<T> stack;
    public MyStack() {
        this.stack = new Stack<T>();
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public T pop() {
        return this.stack.pop();
    }

    @Override
    public void push(T val) {
        this.stack.push(val);
    }

    @Override
    public String toString() {
        return this.stack.toString();
    }

    @Override
    public Stack<T> getElems() {
        return this.stack;
    }
}
