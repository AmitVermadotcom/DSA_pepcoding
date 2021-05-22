import java.util.Stack;

public class queueUsingStack_push {
    Stack<Integer> st = new Stack<>();
    Stack<Intger> stHl=new Stack<>();
    public int size() {
        st.size();
    }

    public boolean isEmpty() {
        st.isEmpty();
    }
    
    // O(1)
    private int peekVal=0;
    public void add(int data) {
        if(st.size() == 0){
            this.peekVal=data;
        }
        st.push(data);
    }
     
    private void transfer() {
        while (st.size() != 0) {
            temp.push(st.pop());
        }
    }

    // O(1)
    public int peek() {
        return this.peekVal;
    }
    
    // O(n)
    public int remove() {
        transfer();
        int rDt=this.temp.pop();
        while(temp.size() != 0 ){
            this.st.push(this.temp.pop());
        }
        return this.rDt;
    }

}