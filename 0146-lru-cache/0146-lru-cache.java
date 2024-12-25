class LRUCache {
    class Node{
        int key,value;
        Node next,prev;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }

    int capacity;
    Map<Integer,Node> map;
    Node head,tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public void addToFront(Node node){
        node.next =  head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            addToFront(node);
            return node.value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            map.remove(node.key);
        } else if(map.size() >= capacity){
            Node toRemove = tail.prev;
            removeNode(toRemove);
            map.remove(toRemove.key);
        }
        Node newNode = new Node(key,value);
        map.put(key,newNode);
        addToFront(newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */