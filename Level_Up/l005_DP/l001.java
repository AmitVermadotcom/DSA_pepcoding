public class l001{
    /* 

    Rules to Solve DP...................................!
    1. Faith
    2. Recursion tree ( dry run )
    3. Recursion code
    4. memoization
    5. Observation
    6. Tabulation
    7. Optimization
    
    */

public static void display(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void display2D(int[][] arr) {
        for (int[] ar : arr) {
            display(ar);
        }
        System.out.println();
    }

    // Faith fibo(n) = fibo(n-1) + fibo(n-2);
    public static int fibo_memo(int n,int[] dp){
        if(n <= 1){
            return dp[n] =1;
        }

        if(dp[n] != 0) return dp[n];

        int ans = fibo_memo(n-1,dp) + fibo_memo(n-2,dp);
        return dp[n] = ans;
    }


public static int fibo_tabu(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = n;
                continue;
            }

            int ans = dp[n - 1] + dp[n - 2];// fibo_memo(n - 1, dp) + fibo_memo(n - 2, dp);
            dp[n] = ans;
        }

        return dp[N];
    }

    public static int fibo_opti(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }
    // Maze path with single Jump

    public static int mazePathCOunt(int[][] maze,int sr,int sc,int er,int ec,int[][] dp){
        if(sr == er && sc == ec){
            return dp[sr][sc] = 1;
        }

        if(dp[sr][sc] != -1) return dp[sr][sc];

        int count = 0;

        if(sr + 1 <= er){
            count += mazePathCOunt(maze,sr+1,sc,er,ec,vis);
        }

        if(sc + 1 <= ec){
            count += mazePathCOunt(maze,sr,sc+1,er,ec,vis);
        }

        return dp[sr][sc] = count;
    }

    public static int mazePathCOunt_tabu(int[][] maze,int SR,int SC,int er,int ec){
        for(int sr = er; sr >= 0;sr--){
            for(int sc = ec; sc >=0 ; sc --){
                if(sr == er && sc == ec){
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;

                if(sr + 1 <= er){
                    count += dp[sr+1][sc];           //mazePathCOunt(maze,sr+1,sc,er,ec,vis);
                }

                if(sc + 1 <= ec){
                    count += dp[sr][sc+1];          //mazePathCOunt(maze,sr,sc+1,er,ec,vis);
                }

                dp[sr][sc] = count;
            }
        }
        return dp[SR][SC];
    }

    // maze path with multiple Jumps

    public static int mazePathCOunt(int[][] maze,int sr,int sc,int er,int ec,int[][] dp){
        if(sr == er && sc == ec){
            return dp[sr][sc] = 1;
        }

        if(dp[sr][sc] != -1) return dp[sr][sc];

        int count = 0;

        for(int r = 1 ; r < er;r++){
            if(sr + r <= er){
                count += mazePathCOunt(maze,sr+r,sc,er,ec,vis);
            }
            if(sc + r <= ec){
            count += mazePathCOunt(maze,sr,sc+r,er,ec,vis);
        }

        return dp[sr][sc] = count;
    }

    public static int mazePathCOunt_tabu(int[][] maze,int SR,int SC,int er,int ec){
        for(int sr = er; sr >= 0;sr--){
            for(int sc = ec; sc >=0 ; sc --){
                if(sr == er && sc == ec){
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;

                for(int r = 1 ; r < er;r++){
                    if(sr + r <= er){
                        count += dp[sr+r][sc];              //mazePathCOunt(maze,sr+r,sc,er,ec,vis);
                    }
                    if(sc + r <= ec){
                        count += dp[sr][sc+r];             //mazePathCOunt(maze,sr,sc+r,er,ec,vis);
                    }
                }

                dp[sr][sc] = count;
            }
        }
        return dp[SR][SC];
    }


    // https://www.geeksforgeeks.org/count-the-number-of-ways-to-divide-n-in-k-groups-incrementally/
    public static int divideInKGroups_memo(int n,int k,int[][] dp){
        if(n == k || k == 1){
            return dp[n][k]=1;
        }

        int selfSet = divideInKGroups(n-1,k-1,dp);
        int partOfAnotherSet = divideInKGroups(n-1,k,dp) * k;

        return dp[n][k] = selfSet + partOfAnotherSet;
    }

    public static void divideInKGroups(int n,int k){
        int[][] dp = new int[n+1][k+1];
        divideInKGroups_memo(n,k,dp);
    }


}