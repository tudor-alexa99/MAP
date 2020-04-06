package Model.ADT;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> implements MyIList<T> {
    private List<T> list;
    public MyList() {
        this.list = new ArrayList<T>();
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean add(T val) {
        return this.list.add(val);
    }

    @Override
    public T get(int index) {
        return this.list.get(index);
    }

    @Override
    public String toString() {
        return this.list.toString();
    }

    @Override
    public List<T> getAll() {
        return this.list;
    }
}
