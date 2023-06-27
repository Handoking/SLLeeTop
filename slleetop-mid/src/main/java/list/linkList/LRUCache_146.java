package list.linkList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @program: SLLeeTop
 * @description: LRU缓存机制
 * @url:/Users/shileilei/Desktop/未命名文件夹2/leetcode/editor/cn/[146]LRU 缓存.java
 * @author: shileilei
 * @date: 2023-06-26 10:45
 **/
public class LRUCache_146 {

    private Integer capacity;

    private HashMap<Integer, Integer> cacheMap;

    private LinkedList<Integer> linkedList = new LinkedList<>();

    public LRUCache_146(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (Objects.nonNull(cacheMap.get(key))){
            linkedList.remove(Integer.valueOf(key));
            linkedList.addFirst(key);
            return cacheMap.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)){
            linkedList.remove(Integer.valueOf(key));
        } else if (cacheMap.size()== capacity) {
            int lastKey = linkedList.getLast();
            cacheMap.remove(lastKey);
            linkedList.removeLast();
        }
        cacheMap.put(key, value);
        linkedList.addFirst(key);
    }

    public static void main(String[] args) {
        LRUCache_146 lruCache =  new LRUCache_146(2);
        lruCache.put(1,0);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println("");
    }
}
