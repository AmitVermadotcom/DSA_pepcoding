import java.util.LinkedList;
import java.util.Arrays;


public class l001Basic{
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

    public static int fibo_memo(int n,int[] dp){
        if(n <= 1){
            return dp[n] = n;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        int ans = fibo_memo(n-1,dp) + fibo_memo(n-2,dp);
        return dp[n] = ans;
    }

    public  static int fibo_DP(int N,int[] dp){
        for(int i=0;i<=N;i++){
            if(i <= 1){
                dp[i] = i;
                continue;
            }

            int ans= dp[i-1] + dp[i-2];
            dp[i] = ans;
        }
        return dp[N];
    }

    public static int fibo_opti(int n,int[] dp){
        int a=0,b=1;
        for(int i=2;i<n;i++){
            System.out.print(a+" ");
            int sum = a+b;
            a=b;
            b=sum;
        }
        return a;
    }

    public static void fibo(){
        int n=6;
        int[] dp=new int[n+1];
        fibo_memo(n,dp);

        print(dp);


        System.out.println(fibo_DP(6,dp));
 System.out.println(fibo_opti(n,dp));
        fibo_opti(n,dp);
    }

// 746 leetcode

 public int minCostClimbingStairs_memo(int[] cost,int n,int[] dp) {
        if(n <= 1){
            return dp[n]=cost[n];
        }
        
        if(dp[n] != 0 ) return dp[n];
        
        int minOfOneStep =  minCostClimbingStairs_memo(cost,n-1,dp);
        int minOfTwoStep =  minCostClimbingStairs_memo(cost,n-2,dp);
        
        int ans = Math.min(minOfOneStep,minOfTwoStep) + (n != cost.length ? cost[n] : 0);
        
        return dp[n]=ans;
    }
    
    public int minCostClimbingStairs_DP(int[] cost,int N,int[] dp) {
        for(int n=0;n<=N;n++){
            if(n <= 1){
                dp[n]=cost[n];
                continue;
            }

            int minOfOneStep =  dp[n-1];
            int minOfTwoStep =  dp[n-2];

            int ans = Math.min(minOfOneStep,minOfTwoStep) + (n != cost.length ? cost[n] : 0);
            dp[n]=ans;
        }
        
        return dp[N];
    }
    
    public int minCostClimbingStairs_opti(int[] cost,int N,int[] dp) {
        int a=cost[0],b=cost[1];
        for(int n=2;n<=N;n++){

            int minVal = Math.min(a,b) + (n != cost.length ? cost[n] : 0);
            a=b;
            b=minVal;
        }
        
        return b;
    }
    
    
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        // return minCostClimbingStairs_memo(cost,n,dp);
        // return minCostClimbingStairs_DP(cost,n,dp);
        return minCostClimbingStairs_opti(cost,n,dp);
    }




    public static int boardPath_memo(int n,int[] dp){
        if(n == 0){
            return dp[n]=1;
        }

        if(dp[n] != 0) return dp[n];
        int cnt = 0;
        for(int i=1;i <= 6 && n-i >= 0;i++){
            cnt += boardPath_memo(n - i,dp);
        }
        return dp[n]=cnt;
    }

    public static int boardPath_DP(int N,int[] dp){
        for(int n=0;n<=N;n++){
            if(n == 0){
                dp[n]=1;
                continue;
            }

            int cnt = 0;
            for(int i=1;i <= 6 && n-i >= 0;i++){
                cnt += boardPath_DP(n - i,dp);
            }

            dp[n]=cnt;
        }

        return dp[N];
    }

    public static int boardPath_opti(int n){
        LinkedList<Integer> ll=new LinkedList<>();

        ll.addFirst(1);
        ll.addFirst(1);
        for(int i=2;i<=n;i++){
            if(ll.size() <= 6){
                ll.addLast(ll.getLast() * 2);
            }
            else{
                ll.addLast(ll.getLast()*2 - ll.removeFirst());
            }
        }

        return ll.getLast();

    }

    public static int mazePath_memo(int sr,int sc,int er,int ec,int[][] dir,int[][] dp){
        if(sr == er && sc == ec){
            return dp[sr][sc] = 1;
        }

        if(dp[sr][sc] != 0) return dp[sr][sc];
        int count=0;
        for(int d = 0;d < dir.length;d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r >= 0 && c >= 0 && r <=er && c <= ec)
                count += mazePath_memo(r,c,er,ec,dir,dp);
        }
        return dp[sr][sc]=count;
    }

    public static int mazePath_DP(int SR,int SC,int er,int ec,int[][] dir,int[][] dp){

        for(int sr=0;sr<=SR;sr++){
            for(int sc=0;sc <= SC;sc++){
                if(sr == er && sc == ec){
                    dp[sr][sc] = 1;
                    continue;
                }
                int count=0;
                for(int d = 0;d < dir.length;d++){
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    if(r >= 0 && c >= 0 && r <=er && c <= ec)
                        count += mazePath_memo(r,c,er,ec,dir,dp);
                }
                dp[sr][sc]=count;
            }
        }
        return dp[SR][SC];
        
    }

    public static int mazePathWithJumps_HDV_memo(int sr,int sc,int er,int ec,int[][] dir,int[][] dp){
        if(sr == er && sc == ec){
            return dp[sr][sc] = 1;
        }

        if(dp[sr][sc] != 0) return dp[sr][sc];

        int count=0;
        for(int d = 0;d < dir.length; d++){
            for(int rad=1;rad < Math.max(er,ec);rad++){

                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];
                if(r >= 0 && c >= 0 && r <= er && c <= ec){
                    count += mazePathWithJumps_HDV_memo(r,c,er,ec,dir,dp);
                }
                else break;
            }
        }
        return dp[sr][sc]=count;

    }
    public static int mazePathJump_HDV_DP(int SR, int SC, int er, int ec, int[][] dir, int[][] dp) {

        for (int sr = er; sr >= 0; sr--) {
            for (int sc = ec; sc >= 0; sc--) {
                if (sr == er && sc == ec) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for (int d = 0; d < dir.length; d++) {
                    for (int rad = 1; rad <= Math.max(er, ec); rad++) {
                        int r = sr + rad * dir[d][0];
                        int c = sc + rad * dir[d][1];
                        if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                            count += dp[r][c];// mazePathJump_HDV(r, c, er, ec, dir, dp);
                        } else
                            break;
                    }
                }

                dp[sr][sc] = count;
            }
        }

        return dp[SR][SC];
    }

    public static void mazePath(){
        int n=7,m=5;
        int[][] dp=new int[n][m];
        int[][] dir={{1,0}, {0,1}, {1,1}};
        System.out.println(mazePath_DP(0,0,n-1,m-1,dir,dp));
        print2D(dp);
    }


    public static int friendsPairing_memo(int n,int[] dp){
        if(n <=1) return dp[n]=1;

        if(dp[n] != 0) return dp[n];

        int single = friendsPairing_memo(n-1,dp);
        int pairUp = friendsPairing_memo(n-2,dp) * (n-1);
        return dp[n]=single + pairUp;
    }

    public static int friendsPairing_DP(int N,int[] dp){
        for(int n = 0;n <= N; n++){
            if(n <= 1) {
                dp[n]=1;
                continue;
            }

            int single = dp[n-1];
            int pairUp = dp[n-2] * (n-1);

            dp[n]=single + pairUp;
        }
        return dp[N];
    }

    public static int friendsPairing_opti(int n){
        int a=1,b=1;
        for(int i = 2;i <= n; i++){
            int sum= b + a * (i-1);
            a = b;
            b = sum;
        }
        return b;
    }

    // gold mine gfg
     public static int goldMine_memo(int[][] arr, int r, int c, int[][] dp, int[][] dir) {
        if (c == arr[0].length - 1) {
            return dp[r][c] = arr[r][c];
        }

        if (dp[r][c] != -1)
            return dp[r][c];

        int maxGold = 0;
        for (int d = 0; d < dir.length; d++) {
            int x = r + dir[d][0];
            int y = c + dir[d][1];

            if (x >= 0 && y >= 0 && x < arr.length && y < arr[0].length)
                maxGold = Math.max(maxGold, goldMine_memo(arr, x, y, dp, dir) + arr[r][c]);
        }

        return dp[r][c] = maxGold;
    }

    public static void goldMine() {
        int[][] arr = {{1, 3, 3}, {2, 1, 4}, {0, 6, 4} };
        int n = arr.length, m = arr[0].length;
        int[][] dir = { { 0, 1 }, { 1, 1 }, { -1, 1 } };

        int[][] dp = new int[n][m];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        int maxGold = 0;
        for (int i = 0; i < n; i++) {
            maxGold = Math.max(maxGold, goldMine_memo(arr, i, 0, dp, dir));
        }

        print2D(dp);
        System.out.println(maxGold);
    }

     public static int goldMine_dp(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int[][] dir = { { 0, 1 }, { 1, 1 }, { -1, 1 } };

        int[][] dp = new int[n][m];
        for (int c = arr[0].length - 1; c >= 0; c--) {
            for (int r = arr.length - 1; r >= 0; r--) {
                if (c == arr[0].length - 1) {
                    dp[r][c] = arr[r][c];
                    continue;
                }

                int maxGold = 0;
                for (int d = 0; d < dir.length; d++) {
                    int x = r + dir[d][0];
                    int y = c + dir[d][1];

                    if (x >= 0 && y >= 0 && x < arr.length && y < arr[0].length)
                        maxGold = Math.max(maxGold, dp[x][y] + arr[r][c]);
                }

                dp[r][c] = maxGold;
            }
        }

        int maxGold = 0;
        for (int i = 0; i < n; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }

        // print2D(dp);
        return maxGold;
    }


    public static void main(String[] args){
        // fibo();
        int[] dp=new int[11];
        // System.out.println(stepByDice_memo(10,dp));
        // System.out.println(stepByDice_DP(10,dp));
        // System.out.println(boardPath_opti(10));
        // mazePath();

        // System.out.println(friendsPairing_opti(5));
        // print(dp);
        goldMine();

    }
}