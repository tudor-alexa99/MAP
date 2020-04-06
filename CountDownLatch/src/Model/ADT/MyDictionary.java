package Model.ADT;

import Model.Values.Value;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

public class MyDictionary<K, V> implements MyIDictionary<K, V>{
    private Hashtable<K, V> dict;

    public MyDictionary() {this.dict = new Hashtable<K, V>();}

    @Override
    public boolean isDefined(K key) {
        return this.dict.containsKey(key);
    }

    @Override
    public void update(K key, V value) {
        this.dict.put(key, value);
    }

    @Override
    public V getValue(K key) {
        return this.dict.get(key);
    }

    @Override
    public String toString() {
        return this.dict.toString();
    }

    @Override
    public V remove(K key) {
        return this.dict.remove(key);
    }

    @Override
    public Collection<V> values(){
        return this.dict.values();
    }

    @Override
    public Map<K, V> getContent() {
        return this.dict;
    }

    @Override
    public Set<K> keySet() { return this.dict.keySet(); }

//    @Override
//    public List<String> getAllStrings() {
//        List<String> outList = this.values().stream(Object::toString).collect(Collectors::toList);
//    }
}
