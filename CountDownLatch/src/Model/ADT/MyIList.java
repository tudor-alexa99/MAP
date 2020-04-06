package Model.ADT;

import java.util.List;

public interface MyIList <T>{
    int size();
    boolean add(T val);
    T get(int index);
    List<T> getAll();
}
