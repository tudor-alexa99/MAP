package Model.ADT;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LatchTable implements ILatchTable {
    private Integer freeLocation = 0;
    private Lock mutex = new ReentrantLock();

    private Map<Integer, Integer> latchTable = new ConcurrentHashMap<>();

    @Override
    public boolean isDefined(Integer key) {
        return this.latchTable.containsKey(key);
    }

    @Override
    public Integer getValue(Integer key) {
        return this.latchTable.get(key);
    }


    @Override
    public Map<Integer, Integer> getContent() {
        return this.latchTable;
    }



//    @Override
//    public Collection<Integer> values() {
//        return null;
//    }

    @Override
    public synchronized Integer getFreeLocation() {
        mutex.lock();

        Integer retLocation = this.freeLocation;
        this.freeLocation += 1;
        mutex.unlock();

        return retLocation;
    }

    @Override
    public void put(Integer location, Integer value) {
        this.latchTable.put(location, value);
    }
}
