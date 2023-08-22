/**
 * @program: SLLeeTop
 * @description: 缓存
 * @author: shileilei
 * @date: 2023-08-22 19:45
 **/
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class Cache {
    private Map<String, Object> cacheMap;
    private ReentrantLock lock;
    private int maxSize;

    public Cache(int maxSize) {
        this.maxSize = maxSize;
        cacheMap = new LinkedHashMap<String, Object>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
                return size() > maxSize;
            }
        };
        lock = new ReentrantLock();
    }

    public Object get(String key) {
        lock.lock();
        try {
            return cacheMap.get(key);
        } finally {
            lock.unlock();
        }
    }

    public void put(String key, Object value) {
        lock.lock();
        try {
            cacheMap.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    public void remove(String key) {
        lock.lock();
        try {
            cacheMap.remove(key);
        } finally {
            lock.unlock();
        }
    }
}
