public class client {
    public static void main(String[] args) {
        stackusingQueue_pop que = new stackusingQueue_pop();
        for (int i = 1; i <= 10; i++) {
            que.push(i * 10);
        }

        while (que.size() != 0) {
            System.out.println(que.pop());
        }
    }
}