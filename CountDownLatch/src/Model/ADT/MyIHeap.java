package Model.ADT;

import java.util.Collection;
import java.util.Map;

public interface MyIHeap<K, V> {
    boolean isDefined(K key);
    void update(K key, V value);
    Integer add(V value);
    V getValue(K key);
    V remove(K key);
    Map<K, V> getContent();
    void setContent(Map<K,V> h);
    Collection<V> values();
}
