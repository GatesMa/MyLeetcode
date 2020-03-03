class LRUCache {

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleList();
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        put(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        Node x = new Node(key, value);
        if(map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key, x);
        } else {
            //KEY不在map中
            if (cap == cache.size()) {
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}


class Node {
    public int val, key;
    public Node next, prev;
    public Node() {}
    public Node(int key, int val) {
        this.val = val;
        this.key = key;
    }
}

class DoubleList {

    private Node head, tail;
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        size = 0;
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node x) {
        x.next  = head.next;
        head.next.prev = x;
        x.prev = head;
        head.next = x;
        size++;
    }

    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    public Node removeLast() {
        if(tail.prev == head)  return null;
        Node last = tail.prev;
        remove(last);
        return last;
    }

    public int size() {
        return size;
    }

}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
