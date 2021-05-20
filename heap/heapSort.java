import java.util.ArrayList;

// public class heapSort{
//     public static boolean isMax = false;
//     public static void Sort(int[] arr,int i){  // i = arr.length-1 in starting..
//         if( i < 0){
//             return;
//         }
//         swap(arr,0,i--);
//         heapify(arr,0,i);
//         Sort(arr,i);
//     }
//     public static void swap(int[] arr,int i,int j){
//         int temp = arr[i];
//         arr[i]=arr[j];
//         arr[j]=temp;
//     }
//     public static void heapify(int[] arr,int pi,int n){
//         // if(pi >= n) return;
//         int maxIdx= pi;
//         int li = (2*pi)+1;
//         int ri=(2*pi)+2;
//         if(li <= n && compareTo(arr[li],arr[maxIdx]) > 0){
//             maxIdx = li;
//         }
//         if(ri <= n && compareTo(arr[ri],arr[maxIdx]) > 0){
//             maxIdx=ri;
//         }
//         if(maxIdx != pi){
//             swap(arr,maxIdx,pi);
//             heapify(arr,maxIdx,n);
//         }
//     }
//     public static int compareTo(int a,int b){
//         if(isMax){
//             return a-b;
//         }else{
//             return b-a;
//         }

//     }
//     public static void main(String[] args){
//         int[] arr = {10,20,30,-2,-3,-4,5, 64,7,8,1,3,6,323,39,322,64};
//         int n =arr.length-1;
//         for(int i=arr.length-1;i>=0;i--){
//             heapify(arr,i,n);
//         }

//         Sort(arr,n); // Recursion method
//         // OR 
        
//         while(n >= 0){   // iterative method
//             swap(arr,0,n--);
//             heapify(arr,0,n);
//         }
//         for(int ele:arr)
//             System.out.print(ele+" ");
//         System.out.println();
//     }
// }


public class heapSort{
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void heapify(int[] arr,int pi,int li){
        int lci = 2*pi + 1;
        int rci = 2 * pi +2;
        int maxIdx = pi;
        if(lci <= li && arr[lci] > arr[maxIdx]){
            maxIdx=lci;
        }
        if(rci <= li && arr[rci] > arr[maxIdx]){
            maxIdx=rci;
        }
        if(maxIdx != pi){
            swap(arr,maxIdx,pi);
            heapify(arr,maxIdx,li);
        }
    }
    public static void main(String[] args){
        int[] arr = {-4,10,20,30,-2,-3,-4,5, 64,7,8,1,3,6,323,39,322,64};
        int n=arr.length-1;
        for(int i=n;i>=0;i--){
            heapify(arr,i,n);
        }
        while(n > 0){
            swap(arr,0,n--);
            heapify(arr,0,n);
        }
        for(int ele:arr){
            System.out.print(ele+" ");
        }
    }
}