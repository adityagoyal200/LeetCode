class LRUCache {

    class Node{
        int key, value;
        Node next,prev;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }

    Node head,tail;
    int capacity;
    Map<Integer,Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
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
        } else if(map.size() >= capacity){
            Node toRemove = tail.prev;
            removeNode(toRemove);
            map.remove(toRemove.key);
        }

        Node newNode = new Node(key,value);
        addToFront(newNode);
        map.put(key,newNode);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */