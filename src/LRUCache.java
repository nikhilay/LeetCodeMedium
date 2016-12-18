/**
 * Created by Nikhil on 12/17/16.
 */

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 */

public class LRUCache {
    class CacheNode {
        int key;
        int value;
        CacheNode next;
        CacheNode pre;

        CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private int capacity;
    HashMap<Integer, CacheNode> hmap;
    CacheNode head;
    CacheNode end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hmap = new HashMap<>();
    }

    public int get(int key) {
        if (hmap.containsKey(key)) {
            CacheNode node = hmap.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (hmap.containsKey(key)) {
            CacheNode node = hmap.get(key);
            node.value = value;
            remove(node);
            setHead(node);

        } else {
            CacheNode node = new CacheNode(key, value);
            hmap.put(key, node);
            setHead(node);
            if (hmap.size() > capacity) {
                hmap.remove(end.key);
                remove(end);
            }
        }
    }

    private void remove(CacheNode node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            end = node.pre;
        }

    }

    private void setHead(CacheNode node) {
        node.next = head;
        node.pre = null;
        if (head != null) {
            head.pre = node;
        }
        head = node;
        if (end == null) {
            end = head;
        }

    }
}
