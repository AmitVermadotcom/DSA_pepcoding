import java.io.*;
import java.util.*;
public class copy{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int  n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        // int k=scn.nextInt();
        // int m=arr[k-1];
        // System.out.print(m);
        // sss(arr,m);

        nextGreatest(arr);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void sss(int[] arr,int n){
        int i=0;
        int j=0;
        while(j < arr.length){
            if(arr[j] <= n){
                int temp= arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
            }
            j++;
        }
    }

    public static void nextGreatest(int arr[]) {
        // code here
        int m=arr.length;
        int pre=arr[m-1];
        arr[m-1]=-1;
        for(int i=m-2;i >= 0;i--){
            int temp = arr[i];
            arr[i] = pre;
            if(temp > pre) pre = temp;
        }
    }
}
// 8
// 6 7 2 5 4 9 8 5 5