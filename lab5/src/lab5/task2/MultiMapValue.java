package lab5.task2;

import java.util.*;

public class MultiMapValue<K, V> {
    private final Map<K, List<V>> map;

    public MultiMapValue() {
        this.map = new HashMap<>();
    }

    public void add(K key, V value) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }

    public void addAll(K key, List<V> values) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).addAll(values);
    }

    public void addAll(MultiMapValue<K, V> otherMap) {
        for (K key : otherMap.map.keySet()) {
            addAll(key, otherMap.getValues(key));
        }
    }

    public V getFirst(K key) {
        List<V> values = map.get(key);
        if (values != null && !values.isEmpty())
            return values.getFirst();
        return null;
    }

    public List<V> getValues(K key) {
        if (map.isEmpty())
            //return new ArrayList<>();
            return Collections.emptyList();
        return map.get(key);
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public List<V> remove(K key) {
        return map.remove(key);
    }

    public int size() {
        int size = 0;
        for(List<V> listVal: map.values()){
            size += listVal.size();
        }
        return size;
    }

}
