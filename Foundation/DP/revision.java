import java.util.*;
public class revision{
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

    public static int stairCase_memo(int[][] dp,int r,int c,int er,int ec){
        if(r == er && c == ec) return dp[r][c] = 1;

        if(dp[r][c] != 0) return dp[r][c];

        int count=0;
        if(r + 1 <= er){
            count += stairCase_memo(dp,r+1,c,er,ec);
        }
        if(c + 1 <= ec){
             count += stairCase_memo(dp,r,c+1,er,ec);
        }
        if(r + 1 <= er && c + 1 <= ec){
             count += stairCase_memo(dp,r+1,c+1,er,ec);
        }

        return dp[r][c] = count;
    }

    public static int stairCase_tabulation(int[][] dp,int R,int C){
        for(int r= R;r >=0;r--){
            for(int c=C;c >= 0;c--){
                if(r == R && c == C) {
                    dp[r][c] = 1;
                    continue;
                }
                int count=0;
                if(r + 1 <= R){
                    count += dp[r+1][c];
                }
                if(c + 1 <= C){
                    count += dp[r][c+1]; //stairCase(dp,r,c+1,er,ec);
                }
                if(r + 1 <= R && c + 1 <= C){
                    count += dp[r+1][c+1]; //stairCase(dp,r+1,c+1,er,ec);
                }
                dp[r][c] = count;
            }
        }
        return dp[R][C];
    }

    public static int freindsPairing(int n,int[] dp){
        if(n <= 1) return dp[n] = 1;

        if(dp[n] != 0){
            return dp[n];
        } 

        int count=0;
        count += freindsPairing(n-1,dp);
        count += (n-1 ) * freindsPairing(n-2,dp);

        return dp[n] = count;
    }
    public static long freindsPairing_tabu(int N,long[] dp){
        for(int n=0;n <= N;n++){
            if(n <= 1){
                dp[n] = 1;
                continue;
            }

            long count=0;
            count += dp[n-1]; //freindsPairing(n-1,dp);
            count += (n-1 ) * dp[n-2];

            dp[n] = count;
        }
        return dp[N];
    }

    public static int freindsPairing_opti(int N,int[] dp){
        int a = dp[0] = 1;
        int b = dp[1] = 1;
        for(int n=2;n<=N;n++){
            int ans = a * (n - 1) + b;
            dp[n] = ans;
            a=b;
            b=ans;
        }
        return dp[N] = b;
    }
// longest palindromic subsequence ==============
    public static int lpss(String str,int i,int j,int[][] dp){
        if(i == j) return 1;
        if(i >= j) return 0;
        
        if(dp[i][j] != 0) return dp[i][j];

        int max =0;
        if(str.charAt(i) == str.charAt(j)){
            max = lpss(str,i+1,j-1,dp) + 2;
        }
        else{
            max = Math.max(lpss(str,i+1,j,dp),lpss(str,i,j-1,dp));
        }
        return dp[i][j]=max;
    }

    public static int lpss(String str,int i,int j,int[][] dp){

        for(int i=0)
        if(i == j) return 1;
        if(i >= j) return 0;
        
        if(dp[i][j] != 0) return dp[i][j];

        int max =0;
        if(str.charAt(i) == str.charAt(j)){
            max = lpss(str,i+1,j-1,dp) + 2;
        }
        else{
            max = Math.max(lpss(str,i+1,j,dp),lpss(str,i,j-1,dp));
        }
        return dp[i][j]=max;
    }

// longest palindromic substring ==================================================|
    public static String lps(String str){
        int n=str.length();
        int[][] dp=new int[n][n];
        int maxLen=0;
        int count=0;
        for(int gap=0;gap < n;gap++){
            for(int i=0,j=gap;j < n;i++,j++){
                if(i >= j){
                    dp[i][j] = i == j ? 1 : 0;
                    continue; 
                }
                
                if(gap == 0){
                    dp[i][j]=1;
                }

                else if(str.charAt(i) == str.charAt(j)){
                    if(gap == 1) dp[i][j]=2;
                    else if(dp[i+1][j-1] > 0) dp[i][j] = dp[i+1][j-1] + 2;
                }

                if(maxLen < dp[i][j]) maxLen = dp[i][j];

                if(dp[i][j] != 0 ) count++;
            }
        }

        return dp[0][n-1];
        
    }


    public static String lps(String str){
        int n=str.length();
        int maxLen=0;
        int sp=0,ep=0;
        int[][] dp=new int[n][n];
        for(int[] d:dp) Arrays.fill(d,0);
        for(int gap=0;gap < n;gap++){
            for(int i=0,j=gap;j < n;i++,j++){
                if(gap == 0) dp[i][j]=1;
                
                else if(str.charAt(i) == str.charAt(j)){
                    if(gap ==1) dp[i][j]=2;
                    else if(dp[i+1][j-1] > 0 ) dp[i][j]=dp[i+1][j-1] + 2;
                }
                
                if(maxLen < dp[i][j]){
                    maxLen=dp[i][j];
                    sp=i;
                    ep=j;
                }
            }
        }
        return str.substring(sp,ep+1);
    }


    // Longest common subsequence
    // https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1#
    public static int lcs(int x, int y, String s1, String s2)
    {
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        return lcss(s1,s2,n,m,dp);
    }

    public static int lcss(String s1,String s2,int n,int m,int[][] dp){
        if(n == 0 || m == 0) return dp[n][m] = 0;

        if(dp[n][m] != -1) return dp[n][m];

        if(s1.charAt(n-1) == s2.charAt(m-1))
            return dp[n][m] = lcss(s1,s2,n-1,m-1,dp) + 1;
        else
            return dp[n][m] = Math.max(lcss(s1,s2,n-1,m,dp) , lcss(s1,s2,n,m-1,dp));
    }

    public static int lcss_DP(String s1,String s2,int N,int M,int[][] dp){
        for(int n=0;n<=N;n++){
            for(int m=0;m<=M;m++){
                if(n == 0 || m == 0){
                    dp[n][m] = 0;
                    continue;
                }

                if(s1.charAt(n-1) == s2.charAt(m-1))
                    dp[n][m] = dp[n-1][m-1] +1; //lcss(s1,s2,n-1,m-1,dp) + 1;
                else
                    dp[n][m] = Math.max(dp[n-1][m] , dp[n][m-1]);
            }
        }
        return dp[N][M];
    }
// uncrossed lines
public static int uncrossedLine(int[] nums1,int[] nums2,int i,int j,int[][] dp){
    if(i == nums1.length || j == nums2.length) return dp[i][j]=0;
    if(dp[i][j] != -1) return dp[i][j];

    if(nums1[i] == nums2[j])
        return dp[i][j] = uncrossedLine(nums1,nums2,i+1,j+1, dp) + 1;
    else
        return dp[i][j] = Math.max(uncrossedLine(nums1,nums2,i+1,j, dp) , uncrossedLine(nums1,nums2,i,j+1, dp));
}


public static int editDistance(String s1,String s2,int n,int m,int[][] dp){
    if(n == m || m ==0){
        return dp[n][m] = (n == 0 ? m:n);
    }

    if(dp[n][m] != -1) return dp[n][m];
    int insert = editDistance(s1,s2,n,m-1,dp);
    int replace = editDistance(s1,s2,n-1,m-1,dp);
    int delete = editDistance(s1,s2,n-1,m,dp);
    if(s1.charAt(n-1) == s2.charAt(m-1)){
        return dp[n][m] = editDistance(s1,s2,n-1,m-1,dp);
    }
    else{
        return dp[n][m] = Math.min(Math.min(insert,replace),delete);
    }
}









    public static void main(String[] args){
        int r=7;
        int c =5;
        int n=4;
        int[] dp=new int[n+1];
        // int[][] dp=new int[r][c];
        // stairCase(dp,0,0,r-1,c-1);
        // System.out.println(stairCase_tabulation(dp,r-1,c-1));
        // Arrays.fill(dp,-1);
        // freindsPairing_tabu(n,dp);
        freindsPairing_opti(n,dp);
        print(dp);
        // print2D(dp);
    }
}