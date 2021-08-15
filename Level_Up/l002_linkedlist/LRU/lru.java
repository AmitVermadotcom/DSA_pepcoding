public class lru{


    // Doubly linkedlist
    public class Node{
        int key;
        int value;
        Node next=null;
        Node prev=null;

        Node(int key,int value){
            this.key=key;
            this.value=value;
            this.next=null;
            this.prev=null;
        }
    }

    private Node head=null;
    private Node tail=null;
    private int size = 0;
    private int limit=0;
    private HashMap<Integer,Node> map=new HashMap<>();


    private void addLast(Node node){
        if(this.size == 0){
            this.head = this.tail=node;
        }
        else{
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
        this.size++;
    }

    private void removeNode(Node node){
        Node prev = node.prev;
        Node forw = node.next;
        if(this.size == 1){
            this.head = this.tail = null;
        }
        
        else if(forw == null){
            prev.next=null;
            this.tail = prev;
        }
        else if(prev == null){
            forw.prev = null;
            this.head = forw;
        }
        else{
            forw.prev = prev;
            prev.next=forw;
        }
        // map.remove(node.key);
        node.next = node.prev = null;    
        this.size--;
    }

    public LRUCache(int capacity) {
        this.limit = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        addLast(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            Node node = new Node(key,value);
            map.put(key,node);
            addLast(node);
            if(this.size > this.limit){
                Node temp = this.head;
                removeNode(temp);
                map.remove(temp.key);
            }
        }
        else{
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addLast(node);
            
        }
    