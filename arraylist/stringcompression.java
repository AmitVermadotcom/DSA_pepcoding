import java.io.*;
import java.util.*;

public class Main{
    public static void main{
        Scanner scn =new Scanner(System.in);
        String str=scn.next();

        StringBuilder sb = new StringBuilder();
        char pre=str.charAt(0);
        sb.append(pre);
        int count=1;
        for(int i=1;i<str.length();i++){
            String curr=str.charAt(i);
            if(curr == pre){
                count++;
            }
            else{
                sb.append(pre);
                if(count>1){
                    sb.append(pre);
                }
                pre=curr;
                count=1;
            }

        }
        if(count>1){
                    sb.append(p);
                }

    }
}