
import java.io.*;
import java.util.*;

public class q{

    public static void main(String[] args){
    Scanner scn =new Scanner(System.in);
    String str=scn.nextLine();
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<str.length();i++){
          if (i<2 && str.charAt(i) != 'x'){
             sb.append(i);
            }
          if(i>1){
            sb.append(i);
          }
        }
    }
}