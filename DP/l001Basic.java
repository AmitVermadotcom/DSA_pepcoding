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

    public static void main(String[] args){
        fibo();
    }
}