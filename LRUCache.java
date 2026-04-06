import java.util.*;

class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        return map.get(key);
    }

    // public void put(int key, int value) {
    //     if (map.containsKey(key)) {
    //         map.put(key, value);
    //     } else {
    //         if (map.size() == capacity) {
    //             int firstKey = map.keySet().iterator().next();
    //             map.remove(firstKey);
    //         }
    //         map.put(key, value);
    //     }    
    // }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 2);
        cache.put(5, 2);
      
        System.out.println(cache.get(3)); 
        System.out.println(cache.get(4));
        System.out.println(cache.get(5)); 

    }
}