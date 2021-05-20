import java.util.Stack;
import java.util.LinkedList;
import java.util.Arrays;
import java.io.*;
import java.util.*;


// NG : Next Greater
    // NS : Next Smaller
    // OR : on Right
    // OL : on Left
 public class question{
     public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        int[] ans = NGTL(arr);
        for(int i=0;i<n;i++){
            System.out.println(ans[i]);
        }
        
        }
    // public static int[] NGOR(int[] arr) {
    //     int n = arr.length;
    //     LinkedList<Integer> st = new LinkedList<>();
    //     int[] ans = new int[n];
    //     Arrays.fill(ans, -1);

    //     for (int i = 0; i < n; i++) {
    //         while (st.size() != 0 && arr[st.getFirst()] < arr[i]) {
    //             ans[st.removeFirst()] = arr[i];
    //         }

    //         st.addFirst(i);
    //     }
    //     return ans;
    // }

    // public static int[] NGOL(int[] arr) {
    //     int n = arr.length;
    //     LinkedList<Integer> st = new LinkedList<>();
    //     int[] ans = new int[n];
    //     Arrays.fill(ans,-1);
    //     for(int i=n-1;i >= 0;i--){
    //         while(st.size() > 0 && arr[i] > arr[st.getFirst()]){
    //             ans[st.removeFirst()] = arr[i];
    //         }
    //         st.addFirst(i);
    //     }
    //     return ans;

    // }
    // public static int[] NSOR(int[] arr) {
    //     int n = arr.length;
    //     LinkedList<Integer> st = new LinkedList<>();
    //     int[] ans = new int[n];
    //     Arrays.fill(ans,n);
    //     for (int i = 0; i < n; i++) {
    //         while (st.size() != 0 && arr[st.getFirst()] > arr[i]) {
    //             ans[st.removeFirst()] = arr[i];
    //         }

    //         st.addFirst(i);
    //     }
    //     return ans;

    // }

    // public static int[] NSOL(int[] arr) {
    //     int n = arr.length;
    //     LinkedList<Integer> st = new LinkedList<>();
    //     int[] ans = new int[n];
    //     Arrays.fill(ans,-1);
    //     for(int i=n-1;i >= 0;i--){
    //         while(st.size() > 0 && arr[i] < arr[st.getFirst()]){
    //             ans[st.removeFirst()] = arr[i];
    //         }
    //         st.addFirst(i);
    //     }
    //     return ans;
    // }
    // public static int nextGreaterElement(int n) {
    //     int cnt=0;
    //     int m=n;
    //     while(m != 0){
    //         m /= 10;
    //         cnt++;
    //     }
    //     int[] arr=new int[cnt];
    //     int j=0;
    //     m=n;
    //     while(n != 0){
    //         int r= n % 10;
    //         n /= 10;
    //         arr[j]=r;
    //         j++;
    //     }
    //     Arrays.sort(arr);
    //     int num=0;
    //     for(int i=0;i <cnt;i++){

    //         num +=arr[i]*Math.pow(10,i);
    //     }
    //     return m >= num ? -1:num;
    // }
    public static int[] NGTR(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        for(int i=0;i<n;i++){
            while(st.size() != 0 && arr[st.peek()] < arr[i]){
                ans[st.pop()]=i;
            }
            st.push(i);
        }
        
        return ans;
    }
    public static int[] NGTL(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        for(int i=n-1;i >= 0;i--){
            while(st.size() != 0 && arr[st.peek()] < arr[i]){
                ans[st.pop()]=i;
            }
            st.push(i);
        }
        
        return ans;
    }
}
    