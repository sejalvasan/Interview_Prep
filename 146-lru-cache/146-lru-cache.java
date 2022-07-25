class LRUCache {

    class Node{
        Node prev;
        Node next;
        int key;
        int val;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
            
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        
        if(capacity == map.size())
            remove(tail.prev);
        
        insert(new Node(key,value));
    }
    
    public void insert(Node node){
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    public void remove(Node node){
        map.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */