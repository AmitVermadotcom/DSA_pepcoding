import java.util.Arrays;

public class l002Stringset{
    public static void print(int[] arr){
        for(int ele:arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }

    public static void print2D(int[][] arr){
        for(int[] ar:arr){
            print(ar);
        }
        System.out.println();
    }

    public static int LPSS_memo(String str,int i,int j,int[][] dp){
        if(i >= j){
            return dp[i][j] = (i == j) ? 1 : 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(str.charAt(i) == str.charAt(j)){
            return dp[i][j] = LPSS_memo(str,i+1,j-1,dp) + 2;
        }
        else{
            return dp[i][j] = Math.max(LPSS_memo(str,i+1,j,dp),LPSS_memo(str,i,j-1,dp));
        }
    }

    public static int LPSS_DP(String str,int I,int J,int[][] dp){
        int n=str.length();
        for(int gap=0;gap<n;gap++){
            for(int i = 0,j = gap;j<n;j++,i++){
                if(i >= j){
                    dp[i][j] = (i == j) ? 1 : 0;
                    continue;
                }

                if(str.charAt(i) == str.charAt(j)){
                   dp[i][j] = dp[i+1][j-1] + 2;
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[I][J];
    }

    public static void LPS(){
        String str = "geeksfgeek";
        int n=str.length();
        int[][] dp=new int[n][n];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        System.out.println(LPSS_DP(str,0,n - 1,dp));
        print2D(dp);
    }

//    leetcode-5 
// longest Palindrome substring
public static String longestPalindrome(String s) {
        
        int n=s.length();
        int[][] dp=new int[n][n];
        int maxLen=0;
        int st=0;
        int ep=0;
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(gap == 0){
                    dp[i][j] = 1;
                }
                else if(gap == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2:0;
                }
                else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] > 0 ){
                    dp[i][j]=dp[i+1][j-1]+2;
                }
                if(dp[i][j] > maxLen){
                    maxLen = dp[i][j];
                    st=i;
                    ep=j;
                }
            }
        }
        
        return s.substring(st,ep+1);
    }
// leetcode-647

     public int countSubstrings(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        int maxLen=0;
        int count=0;
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(gap == 0){
                    dp[i][j] = 1;
                }
                else if(gap == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2:0;
                }
                else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] > 0 ){
                    dp[i][j]=dp[i+1][j-1]+2;
                }
                if(dp[i][j] > maxLen){
                    maxLen = dp[i][j];
                    
                }
                if(dp[i][j] != 0) count++;
            }
        }
        
        return count;
    }

    // leetcode-1143
     public int LCS_memo(String s1, String s2,int n,int m,int[][] dp) {
        if(n == 0 || m == 0){
            return dp[n][m]=0;
        }
        
        if(dp[n][m] != -1) return dp[n][m];
        
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return dp[n][m] = LCS_memo(s1,s2,n-1,m-1,dp) + 1;
        }
        else{
             return dp[n][m] = Math.max(LCS_memo(s1,s2,n-1,m,dp),LCS_memo(s1,s2,n,m-1,dp));
        }
    }

    public int LCS_DP(String s1, String s2,int N,int M,int[][] dp) {
        
        for(int n=0;n<=N;n++){
            for(int m=0;m<=M;m++){
                if(n == 0 || m == 0){
                    dp[n][m]=0;
                    continue;
                }

                if(s1.charAt(n-1) == s2.charAt(m-1)){
                    dp[n][m] = dp[n-1][m-1] + 1;
                }
                else{
                     dp[n][m] = Math.max(dp[n-1][m],dp[n][m-1]);
                }
            }
        }
        return dp[N][M];
        
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        int n=text1.length();
        int m=text2.length();
        
        for(int[] d:dp) Arrays.fill(d,-1);
        return LCS_memo(text1, text2,n,m,dp);
    }

    public static void main(String[] args){
        LPS();
    }

}