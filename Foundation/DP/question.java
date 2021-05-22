public class question{

    // leetcode-1035
     public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[][] dp=new int[n+1][m+1];
        return MUL_DP(nums1,nums2,n,m,dp);
    }
    
    public int MUL_DP(int[] nums1, int[] nums2,int N,int M,int[][] dp) {
        for(int n=0;n<=N;n++){
            for(int m=0;m<=M;m++){
                if(n == 0 | m == 0){
                    dp[n][m]=0;
                    continue;
                }
                
                if(nums1[n-1] == nums2[m-1])
                    dp[n][m] = dp[n-1][m-1] + 1;
                else
                    dp[n][m] = Math.max(dp[n-1][m],dp[n][m-1]);
            }
        }
        return dp[N][M];
    }
    
    // leetcode-72 Edit distance

    public int minDistance_memo(String s1,String s2, int n,int m,int[][] dp){
        if(n == 0 || m == 0){
            return dp[n][m] = (n == 0 ? m : n);
        }

        if(dp[n][m] != -1) return dp[n][m];

        int insert = minDistance_memo(s1,s2,n,m-1,dp);
        int replace = minDistance_memo(s1,s2,n-1,m-1,dp);
        int delete = minDistance_memo(s1,s2,n-1,m,dp);

        if(s1.charAt(n-1) == s2.charAt(m-1))
            return dp[n][m] = replace;
        else
            return dp[n][m] = Math.min(Math.min(insert,replace),delete) + 1;
        
    }
    
    public int minDistance_DP(String s1,String s2, int N,int M,int[][] dp){
        for(int n=0;n<=N;n++){
            for(int m=0;m<=M;m++){
                if(n == 0 || m == 0){
                    dp[n][m] = (n == 0 ? m : n);
                    continue;
                }

                int insert = dp[n][m-1];
                int replace = dp[n-1][m-1];
                int delete = dp[n-1][m];

                if(s1.charAt(n-1) == s2.charAt(m-1))
                    dp[n][m] = replace;
                else
                    dp[n][m] = Math.min(Math.min(insert,replace),delete) + 1;
            }
        }
        return dp[N][M];
        
    }

    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();

        int[][] dp=new int[n+1][m+1];

        for(int[] d:dp)
            Arrays.fill(d,-1);
        
        return minDistance_DP(word1,word2,n,m,dp);
    }

    // https://www.geeksforgeeks.org/edit-distance-and-lcs-longest-common-subsequence/?ref=rp

    public static int LCSS(String s1, String s2) {
        int N = s1.length(), M = s2.length();
        int[][] dp = new int[N + 1][M + 1];
        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {

                if (n == 0 || m == 0) {
                    dp[n][m] = 0;
                    continue;
                }

                if (s1.charAt(n - 1) == s2.charAt(m - 1))
                    dp[n][m] = dp[n - 1][m - 1] + 1;
                else
                    dp[n][m] = Math.min(dp[n - 1][m], dp[n][m - 1]);
            }
        }

        return dp[N][M];
    }

    public static void editDistanceVariation(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int LCSS = LCSS(s1, s2);

        int ans = (n - LCSS) + (m - LCSS);
    }

// https://practice.geeksforgeeks.org/problems/minimum-deletitions1648/1
     public static int LPSS(String str, int I, int J, int[][] dp) {
        int n = str.length();
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (i >= j) {
                    dp[i][j] = (i == j) ? 1 : 0;
                    continue;
                }

                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;// LPSS(str, i + 1, j - 1, dp) + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[I][J];
    }

    public static void minDeleteToMakePlaindrome(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        int ans = n - LPSS(str, 0, n - 1, dp);
    }
}