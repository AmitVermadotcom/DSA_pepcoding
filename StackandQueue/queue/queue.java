public class queue{
    protected int[] arr=null;
    protected int capacity = 0;
    protected int front=0;
    protected int back=0;
    protected int eleCount=0;


// constructor ========================||
    protected void initialization(int capacity){
        this.capacity = capacity;
        this.arr = new int[this.capacity];
        this.eleCount=0;
        this.front = 0;
        this.back = 0;
    }
    public queue(){
        initialization(10);
    }
    public queue(int data){
        initialization(data);
    }

    // Basic function ========================================||
    public int size(){
        return this.eleCount;
    }

    public boolean isEmpty(){
        return this.eleCount == 0;
    }

    public void Display(){
        for(int i=0;i<eleCount;i++){
            System.out.println(this.arr[]);
        }
    }

    // Exception ========================||

    private void overflowException() throws Exception{
        if(this.eleCount == this.capacity){
            throw new Exception("queueIsFull");
        }
    }

    private void underflowException() throws Exception{
        if(this.eleCount == 0){
            throw new Exception("queueIsEmpty");
        }
    }

    // function ====================== =========||
    private void push_(int data){
        this.arr[this.back] = data;
        this.eleCount++;
        this.back = (this.back + 1) % this.capacity;
    }
    public void push(int data) throws Exception{
        overflowException();
        push_(data);
    }

    public int top() throws Exceptions{
        underflowException();
        return this.arr[this.front];
    }
    private int pop_(){
        int rv = this.arr[this.front];
        this.arr[this.front] = 0;
        this.eleCount--;
        this.front= (this.front +1)%this.capacity;
        return rv;
    }
    public int pop() throws Exception{
        underflowException();
        return pop_();
    }
}