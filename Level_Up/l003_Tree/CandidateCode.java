/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;
public class CandidateCode {
   public static void main(String args[] ) throws Exception {

	//Write code here
   Scanner scn=new Scanner(System.in);
   String virus = scn.next();
   int n = scn.nextInt();
   String[] blood = new String[n];
   for(int i=0;i<n;i++){
      blood[i]=scn.next();
   }
   for(int i=0;i<n;i++){
      // if(blood[i].length() > virus.length()){
      // System.out.println("NEGATIVE");
      // continue;
      // }
      boolean flag = helper(blood[i],virus,0,0);
      if(flag){
         System.out.println("POSITIVE");
      }
      else{
         System.out.println("NEGATIVE");
      }
   }
   }

   public static boolean helper(String blood,String virus,int i,int j){
      if(blood.length() <= i) return true;
      if(virus.length() <= j) return false;
      if(blood.charAt(i) == virus.charAt(j)){
         boolean left = helper(blood,virus,i+1,j+1);
         if(left) return true;
      }
      else{
         boolean right = helper(blood,virus,i,j+1);
         if(right) return true;
      }

      return false;
   }
}