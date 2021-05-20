  
import java.util.Stack;

public class queueUsingStack_pop {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> temp = new Stack<>();

    public int size() {
        return st.size();
    }

    public boolean isEmpty() {
        return st.isEmpty();
    }

    private void transfer() {
        while (st.size() != 0) {
            temp.push(st.pop());
        }
    }

    // O(n)
    public void add(int data) {
        transfer();
        this.st.push(data);
        while (this.temp.size() != 0)
            this.st.push(this.temp.pop());
    }

    // O(1)
    public int peek() {
        return this.st.peek();
    }

    // O(1)
    public int remove() {
        return this.st.pop();
    }
}