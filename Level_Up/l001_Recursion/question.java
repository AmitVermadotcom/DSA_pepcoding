import java.util.Arrays;

public class question{


    // https://practice.geeksforgeeks.org/problems/special-matrix4201/1#
    int mod = (int) 1e9 + 7;

     public int dfs(int sr, int sc, int er, int ec, boolean[][] block, int[][] dp) {
        if (sr == er && sc == ec)
            return dp[sr][sc] = 1;

        if (dp[sr][sc] != -1)
            return dp[sr][sc];
        int count = 0;
        if (sc + 1 <= ec && !block[sr][sc + 1])
            count = (count % mod + dfs(sr, sc + 1, er, ec, block, dp) % mod) % mod;
        if (sr + 1 <= er && !block[sr + 1][sc])
            count = (count % mod + dfs(sr + 1, sc, er, ec, block, dp) % mod) % mod;

        return dp[sr][sc] = count;
    }

    public int FindWays(int n, int m, int[][] blocked_cells) {
        n++;
        m++;
        boolean[][] block = new boolean[n][m];

        for (int[] b : blocked_cells)
            block[b[0]][b[1]] = true;

        if (block[1][1] || block[n - 1][m - 1])
            return 0;

        int[][] dp = new int[n][m];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return dfs(1, 1, n - 1, m - 1, block, dp);
    }

// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#

    public static ArrayList<String> findPath(int[][] mat, int n) {
        // Your code here
        int[][] dir = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
        String[] Sdir = { "L", "R", "U", "D" };

        ArrayList<String> res = new ArrayList<>();
        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0)
            return res;
        int ans = floodFill(0, 0, n - 1, n - 1, dir, Sdir, mat, "", res);

        Collections.sort(res);
        return res;
        
    }


     public static int floodFill(int sr, int sc, int er, int ec, int[][] dir, String[] Sdir, int[][] vis, String psf,
            ArrayList<String> res) {

        if (sr == er && sc == ec) {
            res.add(psf);
            return 1;
        }

        int count = 0;
        vis[sr][sc] = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec && vis[r][c] == 1) {
                count += floodFill(r, c, er, ec, dir, Sdir, vis, psf + Sdir[d], res);
            }
        }

        vis[sr][sc] = 1;
        return count;
    }


    // leetcode-39 combination sum
    public int combinationSum(int[] arr, int tar, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (tar == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            res.add(base);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                smallAns.add(arr[i]);
                count += combinationSum(arr, tar - arr[i], i, smallAns, res);
                smallAns.remove(smallAns.size() - 1);
            }
        }

        return count;
    }


    // leetcode-40 combinationSum2

    public int combinationSum2_helper(int[] arr,int tar,int idx,List<List<Integer>> ans,List<Integer> subAns){
        if(tar == 0){
            List<Integer> base = new ArrayList<>(subAns);
            ans.add(base);
            return 1;
        }
        
        int count =0;
        boolean[] vis = new boolean[51];
        for(int i=idx;i<arr.length;i++){
            if(!vis[arr[i]]){
                if(tar - arr[i] >= 0){
                    vis[arr[i]]=true;
                    subAns.add(arr[i]);
                    combinationSum2_helper(arr,tar-arr[i],i+1,ans,subAns);
                    subAns.remove(subAns.size()-1);
                }
            }
        }
        return count;
    }

    // Or

    public int combinationSum2_helper(int[] arr,int tar,int idx,List<List<Integer>> ans,List<Integer> subAns){
        if(tar == 0){
            List<Integer> base = new ArrayList<>(subAns);
            ans.add(base);
            return 1;
        }
        
        int count =0;
        int pre =-1;
        for(int i=idx;i<arr.length;i++){
            if(pre != arr[i]){
                if(tar - arr[i] >= 0){
                    subAns.add(arr[i]);
                    combinationSum2_helper(arr,tar-arr[i],i+1,ans,subAns);
                    subAns.remove(subAns.size()-1);
                    pre=arr[i];
                }
            }
        }
        return count;
    }
    

}


