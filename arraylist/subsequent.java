import java.io.*;
import java.util.*;

public class arraylist{
     public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        ArrayList<String> ans =subSequent(str);
     }
     public static Arraylist<> subSequent(String str){
         Arraylist<String> arr =new Arraylist<> ();
         arr.add("");
         for(int i=0;i<str.length();i++){
             int size=arr.size;
             char c=str.charAt(i);
             for(int j=0;j<size;j++){
                 arr.add(arr.get(j)+'c');
             }
         }
         return arr;
     }
}

import java.io.*;
import java.util.*;

public class Main {

    public static void solution(ArrayList < Integer > al) {
        for (int i = al.size() - 1; i >= 0; i--) {
            int a = al.get(i);
            if (isPrime(a) == true) {
                al.remove(i);
            }
        }

    }
    public static boolean isPrime(int a) {
        for (int div = 2; div * div <= a; div++) {
            if (a % div == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList < Integer > al = new ArrayList < > ();
        for (int i = 0; i < n; i++) {
            al.add(scn.nextInt());
        }
        solution(al);
        System.out.println(al);
    }

}