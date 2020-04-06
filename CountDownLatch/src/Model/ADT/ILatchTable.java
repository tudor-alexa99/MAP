package Model.ADT;

import java.util.Collection;
import java.util.Map;

public interface ILatchTable {
    boolean isDefined(Integer key);
    Integer getValue(Integer key);
    Integer getFreeLocation();
    Map<Integer, Integer> getContent();
//    Collection<Integer> values();
    void put(Integer location, Integer value);
}
