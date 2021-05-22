import java.util.Queue;
import java.util.LinkedList;

public class stackusingQueue_push{

    Queue<Integer> que=new LinkedList<>();
    Queue<Integer> que=new LinkedList<>();

    public int size() {
        return que.size();
    }

    public boolean isEmpty() {
        return que.isEmpty();
    }

    private void transfer() {
        while(temp.size() != 0){
            que.add(temp.remove());
        }
    }

    // O(1)
    private int peekVal=0;
    public void push(int data) {
       que.add(data);
       this.peekVal=data;
    }

    // O(1)
    public int peek() {
        return this.peekVal;
    }

    // O(n)
    public int pop() {
        while(que.size() != 1){
            temp.add(que.remove());
        }
        int rData=this.que.remove();
        transfer();
    }
}