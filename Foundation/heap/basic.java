public class basic{
    public static int height(int arr,int pi){
        if(pi >= arr.length ) return -1;
        int li = (2*pi) + 1;
        int ri = (2*pi) + 2;
        int lh = height(arr,li);
        int rh = height(arr,ri);
        return Math.max(lh, rh) + 1;
        
    }
    public static int size(int arr,int pi){
        if(pi >= arr.length ) return 0;
        int li = (2*pi) + 1;
        int ri = (2*pi) + 2;
        return size(arr,li) +size(arr,ri)+1
        
    }
    public static void main(String[] args){
        int[] arr = { 10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13, 14 };
        System.out.println(height(arr, 0));
        System.out.println(size(arr,0));
        System.out.println(arr.length);
    }
}