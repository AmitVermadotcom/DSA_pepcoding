public class client {
    public static void main(String[] args){
        dynamicQueue dq=new dynamicQueue(6);
        for(int i=0;i<15;i++){
            dq.push_(i*10);
        }
        System.out.println(dq.pop());
        System.out.println(dq.pop());
        System.out.println(dq.pop());
        System.out.println(dq.pop());
        System.out.println(dq.pop());
        System.out.println(dq);
    }
}