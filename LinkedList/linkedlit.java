public class linkedlist{
    private class Node{
        int data=0;
        Node next = null;
        Node(int data){
            this.data =data;
        }
    }

    private Node head =null;
    private Node tail=null;
    private int sizeOfLL = 0; 

    public boolean isEmpty(){
        return this.sizeOfLL == 0;
    }

    // Exceptions====================================================...
    public void EmptyExceptiom() throws Exceptions{
        if(this.sizeOfLL == 0 )
          throw new Exceptions("return -1");
    }  
    public void IndexOutOfBoundSizeExclusiveException(int idx) throws Exception {
        if (idx < 0 || idx >= this.sizeOfLL)
            throw new Exception("Index Out Of Bound : -1");
    }

    public void IndexOutOfBoundSizeInclusiveException(int idx) throws Exception {
        if (idx < 0 || idx > this.sizeOfLL)
            throw new Exception("Index Out Of Bound : -1");
    }




    // get====================================================================
    public int getFirst() throws Exception {
        EmptyException();
        return this.head.data;

    }

    public int getLast() throws Exception {
        EmptyException();
        return this.tail.data;
    }

    private Node getNodeAt(int idx) {

    }

    public int getAt(int idx) {
        IndexOutOfBoundSizeExclusiveException(idx);
        Node node = getNodeAt(idx);
        return node.data;
    }



    // Add======================================================================
    private addFirstNode(Node node){
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }
        else{
            node.next = this.head;
            this.head = node;
        }
        this.sizeOfLL++;
    }
    public addFirst(int data){
        // EmptyExceptiom()
        Node node=new Node(data);
        addFirstNode(node);
    }
    private addLastNode(Node node){
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }
        else{
            this.tail.next = node;
            this.tail = node;
        }
        this.sizeOfLL++;
    }
    public addlast(int data){
        // EmptyExceptiom()
        Node node=new Node(data);
        addLastNode(node);
    }
    private addAtidx(Node node){
        if()
    }
    public addAt(int data){
        Node node=new Node(data);
        addAtidx(node);
    }


    // remove==================================================================

    private Node removeAtNode(idx){
        if(this.sizeOfLL == 1){
            this.head=null;
            this.tail=null;
        }
        else{
            Node preNode = getNodeAt(idx-1);
            this.next = null;
            this.tail = this.preNode;
        }
        this.sizeOfLL--;
        return this.head;
    }
    public int removeAt(int idx) throws Exceptions{
        IndexOutOfBoundSizeExclusiveException(idx);
        Node node = removeAtNode(idx);
        return node.data;
    }

}