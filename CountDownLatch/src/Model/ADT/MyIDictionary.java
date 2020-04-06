package Model.ADT;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MyIDictionary<K, V>{
    boolean isDefined(K key);
    void update(K key, V value);
    V getValue(K key);
    V remove(K key);
    Map<K, V> getContent();
    Collection<V> values();
    Set<K> keySet();
//    List<String> getAllStrings();
}
