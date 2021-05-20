public class client{
    public static void main(String[] args) throws Exception{
        LinkedList ll1 = new LinkedList();
        for(int i=0;i<10;i++) ll1.addFirst(i * 10);
        System.out.println(ll1);
        
        System.out.println(ll1.removeAt(0));
    }
}