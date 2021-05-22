// import java.util.HashMap;
// import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class l001{
    public static void main(String[] args){
        // printFrequency("abcdefabcdefa");
        // highestFreq("abcdefabcdefa");
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        // posOfAllChar(str);
        posOfAllCharUsingArrayList(str);
    }

    public static void printFrequency(String str){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i =0;i<str.length();i++){
            char c=str.charAt(i);
            // if(map.containsKey(c)){
            //     map.put(c,map.get(c)+1);
            // }
            // else{
            //     map.put(c,1);
            // }

            // OR
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c : map.keySet()){
            System.out.println(c +"->"+map.get(c));
        }
    }

    public static void highestFreq(String str){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i =0;i<str.length();i++){
            char c=str.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }
        int freq=0;
        char ans =' ';
        for(Character ch : map.keySet()){
            if(map.get(ch) > freq){
                freq = map.get(ch);
                ans=ch;
            }
        }
        System.out.println(ans +" -> "+freq);
    }

    public static void posOfAllChar(String str){
        HashMap<Character,String> map=new HashMap<>();
        for(int i =0;i<str.length();i++){
            char c=str.charAt(i);
            String s = " "+i;
            if(map.containsKey(c)){
                map.put(c,map.get(c)+","+s);
            }
            else{
                map.put(c,s);
            }
        }
        for(char c : map.keySet()){
            System.out.println(c +" -> ["+map.get(c)+" ]");
        }
    }

    public static void posOfAllCharUsingArrayList(String str){
        HashMap<Character,ArrayList<Integer>> map=new HashMap<>();
        for(int i =0;i<str.length();i++){
            char c=str.charAt(i);
           if(!map.containsKey(c)) map.put(c,new ArrayList<>());
           map.get(c).add(i);
        }
        // for(int i =0;i<str.length();i++){
        //     char c=str.charAt(i);
        //    map.putIfAbsent(c,new ArrayList<>());
        //    map.get(c).add(i);
        // }
        for(char c : map.keySet()){
            System.out.println(c +" -> "+map.get(c));
        }
    }
    public static void longestConsecutiveSequence(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        int sp = 0, maxLen = 0;

        for (int ele : arr) {
            if (!map.containsKey(ele))
                continue;

            map.remove(ele);
            int le = ele - 1;
            int re = ele + 1;

            while (map.containsKey(le)) {
                map.remove(le);
                le--;
            }

            while (map.containsKey(re)) {
                map.remove(re);
                re++;
            }

            int len = re - le - 1;
            if (len > maxLen) {
                maxLen = len;
                sp = le + 1;
            }
        }

        for (int i = 0; i < maxLen; i++)
            System.out.println(sp + i);

    }
    
}
