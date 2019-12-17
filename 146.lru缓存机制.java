import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache {
    private Map<Integer, Node> map = null;
    private Node head = null;
    private Node tail = null;
    private int capacity = 0;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public Integer get(int key) {
        Node target = map.get(key);
        if(target == null){
            return -1;
        }
        moveToHead(target);
        return target.value;
    }
    
    public void put(int key, int value) {
        Node target = map.get(key);
        if(target!=null){
            target.value = value;
            moveToHead(target);
        }else{
            if(isFull()){
                map.remove(tail.key);
                removeTail();
            }

            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            addToHead(newNode);
            map.put(key, newNode);
        }
    }

    private void addToHead(Node node){
        if(map.isEmpty()){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.pre = node;
            head = node;
        }
    }

    private void moveToHead(Node node){
       //remove from link
       if(node == head){
           return;
       }else if(node == tail){
           removeTail();
       }else{
           node.pre.next = node.next;
           node.next.pre = node.pre;
       }
       node.pre = head.pre;
       node.next = head;
       head.pre = node;
       head = node;
    }

    private void removeTail(){
        Node tailPre = tail.pre;
        if(tailPre != null){
              tailPre.next = null;
        }
        tail = tailPre;
    }

    private boolean isFull(){
        return capacity <= map.size();
    }

    class Node{
        private int value;
        private Node next;
        private Node pre;
        private int key;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

