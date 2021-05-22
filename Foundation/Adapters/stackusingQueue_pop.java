import java.util.Queue;
import java.util.LinkedList;

public class stackusingQueue_pop{
    Queue<Integer> que=new LinkedList<>();
    Queue<Integer> temp=new LinkedList<>();

    public int size() {
        return que.size();
    }

    public boolean isEmpty() {
        return que.isEmpty();
    }

    private void transfer() {
        while(que.size() != 0){
            temp.add(que.remove());
        }
    }

    // O(n)
    private int peekVal=0;
    public void push(int data) {
        if(que.size() != 0){
            transfer();
        }
        que.add(data);
        this.peekVal=data;
        while(temp.size() != 0){
            que.add(temp.remove());
        }
    }

    // O(1)
    public int peek() {
        return this.peekVal;
    }

    // O(n)
    public int pop() {
        return que.remove();
    }
}