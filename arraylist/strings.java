import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String s = str.substring(i, j);
                if (isPalindrome(s) == true) {
                    System.out.println(s);
                }
            }
        }

    }
    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(j);
            if (c1 != c2 ){
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }

}