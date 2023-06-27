package list.linkList;

import java.util.HashMap;

/**
 * @program: SLLeeTop
 * @description: 最近最少使用缓存
 * @author: shileilei
 * @date: 2023-06-26 15:44
 **/
public class LRUCacheV2 {

    private Integer capacity;

    private HashMap<Integer, Node> cacheMap;

    private Node head;
    private Node tail;

    public LRUCacheV2(Integer capacity){
        this.capacity =  capacity;
        cacheMap =  new HashMap<>(capacity);
        head = new Node(-1,-1);
        tail = new Node(-100,-1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(Integer key){
        if (cacheMap.containsKey(key)){
            //移动该节点到头部
            moveNodeToFirst(cacheMap.get(key));
            return cacheMap.get(key).value;
        }
        return -1;
    }

    public void put(Integer key,Integer value){
        if (cacheMap.containsKey(key)){
            //移除key所在的节点
            removeNode(cacheMap.get(key));
        }else if (cacheMap.size() == capacity){
            //链表最后一个节点的值last
            Node lastNode = tail.pre;
            //移除cacheMap缓存中的last
            cacheMap.remove(lastNode.key);
            //移除链表最后一个节点
            removeNode(lastNode);
        }
        //链表头增加该节点
        Node newNode = new Node(key,value);
        addFirst(newNode);
        cacheMap.put(key, newNode);
    }

    private void removeNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addFirst(Node node){
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void moveNodeToFirst(Node node){
        removeNode(node);
        addFirst(node);
    }

    public class Node{
        Node pre;
        Node next;
        Integer value;
        Integer key;
        public Node(){
        }

        public Node(Integer key,Integer value){
            this.value = value;
            this.key =  key;
        }
    }

    public static void main(String[] args) {
        LRUCacheV2 lruCache =  new LRUCacheV2(2);
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
