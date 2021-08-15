public class l002_DfsQuestion {
    // Leetcode 200 || Number of island
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int numOfIsland = 0;
        int[][] dir= {{-1,0}, {0,1} , {1,0}, {0,-1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j,dir);
                    numOfIsland++;
                }
            }
        }
        
        return numOfIsland;
    }
    
    public void dfs(char[][] grid,int r,int c,int[][] dir){
        
        grid[r][c]='0';
        for(int d=0;d<4;d++){
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(nc >= 0 && nr >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1'){
                dfs(grid,nr,nc,dir);
            }
        }
    }


    // Leetcode 695 || Max Area of island
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int maxArea=0;
        int[][] dir = {{-1,0}, {0,1},{1,0},{0,-1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(dfs(grid,i,j,dir),maxArea);
                }
            }
        }
        return maxArea;
    }
    
    public int dfs(int[][] grid,int r,int c,int[][] dir){
        int count = 0;
        grid[r][c]=0;
        for(int d=0;d<4;d++){
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1){
                count += dfs(grid,nr,nc,dir);
            }
        }
        return count + 1;
    }



    // Leetcode 463 || Island perimeter

    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int selfCount=0;
        int pardosiCount = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    selfCount++;
                    if(i+1 < n && grid[i+1][j] == 1){
                        pardosiCount++;
                    }
                    if(j+1 < m && grid[i][j+1] == 1){
                        pardosiCount++;
                    }
                }
            }
        }
        
        return 4 * selfCount - 2 * pardosiCount;
    }


    //Leetcode 130 || Surrounded Regions

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i == 0 || j == 0 || i == n-1 || j == m-1) && board[i][j] == 'O'){
                    mark(board,i,j,dir);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O'){
                    board[i][j]='X';
                }
                else if(board[i][j] == '*'){
                    board[i][j]='O';
                }
            }
        }
        
        
    }
    
    public void mark(char[][] mat,int r,int c,int[][] dir){
        mat[r][c]='*';
        for(int d=0;d<4;d++){
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length && mat[nr][nc] == 'O'){
                mark(mat,nr,nc,dir);
            }
        }
    }


    // Journey to Moon

    public static long journeyToMoon(int n , List<List<Integer>> astronaut){
        ArrayList[] graph = new ArrayList[n];
        for(int =0;i < n;i++) graph[i].add(new ArrayList<>());

        for(int i = 0; i < n;i++){
            for(int ele : astronaut.get(i)){
                graph[i].add(ele);
                graph[ele].add(i);
            }
        }

        ArrayList<Integer> sizeOfArray = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i])
                sizeArray.add(moonDFS(graph, i, vis));
        }

        long ssf = 0, res = 0;
        for (int ele : sizeArray) {
            res += ele * ssf;
            ssf += ele;
        }

        return res;
    }
    public static int moonDFS(ArrayList<Integer>[] graph, int src, boolean[] vis) {
        vis[src] = true;
        int size = 0;
        for (Integer e : graph[src]) {
            if (!vis[e])
                size += moonDFS(graph, e, vis);
        }

        return size + 1;
    }
}