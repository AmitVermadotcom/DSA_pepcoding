public class dynamicQueue extends queue {
    
    public dynamicQueue(){
        super();
    }
    public dynamicQueue(int size){
        super(size);
    }

    public dynamicQueue(int[] arr){
        super.initialization(2 * arr.length);
        for(int ele:arr){
            super.push_(ele);
        }
    }

    @Override
    public void push(int data) throws Exception {
        if(super.capacity == super.eleCount){
            int n = super.capacity;
            int f =super.front;
            int[] temp = new int[n];
            for(int i=0;i<n;i++){

                int idx = (f+i)%n;
                temp[i]=super.arr[idx];
            }

            super.initialization(2 * n);
            for(int ele:temp){
                super.push_(ele);
            }
        }
        super.push_(data);
    }
}