import java.util.Scanner;
import java.util.ArrayList;

public class l002{


// num to power a=a^1
    public static boolean primemun(int n,ArrayList<Integer> list){
        for(int i=2;i*i<n;i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public static void solution(int num,ArrayList<Integer> list){
        int i=0;
        int count=0;
        while( i < list.size()){
            if(num % list.get(i)==0){
                count++;
                num/=list.get(i);
            }
            else{
                if(count>0){
                    System.out.print(list.get(i) + "^" + count +"\t");
                }
                count=0;
                i++;
            }
        }
        if(num != 1){
                System.out.print(num + "^" + "1");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner scn=new Scanner (System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        ArrayList <Integer> list=new ArrayList<>();
        for(int i=2;i*i<=10000;i++){
            if(primemun(i,list)==true) list.add(i);
        }
        for(int ele: arr){
            solution(ele,list);
        }
    }
}