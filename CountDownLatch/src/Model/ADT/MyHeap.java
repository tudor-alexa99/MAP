package Model.ADT;



import Model.Values.Value;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MyHeap<K, V> implements MyIHeap<Integer, Value> {
    private Map<Integer, Value> heap;
    private int nextFree;

    public MyHeap() { this.heap = new HashMap<Integer, Value>(); this.nextFree = 1;}

    @Override
    public Value getValue(Integer key) {
        return this.heap.get(key);
    }

    @Override
    public boolean isDefined(Integer key) {
        return this.heap.containsKey(key);
    }

    @Override
    public Value remove(Integer key) {
        return this.heap.remove(key);
    }

    @Override
    public void update(Integer key, Value value) {
        this.heap.put(key, value);
        nextFree += 1;
    }
    @Override
    public Integer add(Value value){
        this.heap.put(nextFree, value);
        nextFree += 1;
        return nextFree - 1;
    }
    @Override
    public Map<Integer, Value> getContent(){
        return this.heap;
    }
    @Override
    public void setContent(Map<Integer, Value> _heap) {
        this.heap = _heap;
    }


    @Override
    public Collection<Value> values() {
        return heap.values();
    }

    @Override
    public String toString() {
        return "[ " + this.heap.toString() + "]";
    }
    //    public Integer getNextFree() { return this.nextFree; }
}
