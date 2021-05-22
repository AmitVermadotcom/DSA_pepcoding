import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int k=sc.nextInt();
            String str=sc.next();
            int cnt=0;
            for(int j=0; j < n/2;j++){
                if(str.charAt(i) != str.charAt(n-i-1)) cnt++;
            }
        System.out.println("Case #"+(i+1)+": "+Math.abs(cnt-k));
            
        }
    }
}