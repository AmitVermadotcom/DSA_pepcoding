public class bfsQuestion{

    // the maze 
    // https://www.lintcode.com/problem/787/
    public boolean hasPath(int[][] maze, int[] start, int[] des) {
        // write your code here
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dir = {{0,1} , { 1, 0}, {0,-1} ,{-1, 0}};
        LinkedList<int[]> que = new LinkedList<>();
        que.addLast(new int[]{start[0],start[1]});

        while(que.size() != 0){
            int[] rv = que.removeFirst();
            if(vis[rv[0]][rv[1]]) continue;
            vis[rv[0]][rv[1]] = true;
            int i = rv[0] , j = rv[1];
            for(int d=0;d<4;d++){
                int r = i + dir[d][0];
                int c = j + dir[d][1];
                if(r >= 0 && c >=0 && r < n && c < m && maze[r][c] == 0){
                    while(r >= 0 && c >=0 && r < n && c < m && maze[r][c] == 0){
                        r = r + dir[d][0];
                        c = c + dir[d][1];
                    }
                    r -= dir[d][0];
                    c -= + dir[d][1];
                    if(!vis[r][c]){
                        if(r == des[0] && c == des[1]) return true;
                        que.addLast(new int[]{r,c});
                    }
                }
            
            }
        }
        return false;
    }

    
    // The maze - 2
    // https://www.lintcode.com/problem/788

    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        // write your code here
        int[][] dir = {{0,1} , { 1, 0}, {0,-1} ,{-1, 0}};
        int n = maze.length;
        int m = maze[0].length;
        int i = start[0];
        int j = start[1];
        int er = dest[0];
        int ec = dest[1];
        int[][] dist = new int[n][m];
        for(int[] d : dist) Arrays.fill(d,(int)1e9);
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) ->{
            return a[1] - b[1];
        });

        que.add(new int[]{i * m + j,0});
        while(que.size() != 0){
            int[] rv = que.remove();
            int sr = rv[0] / m;
            int sc = rv[0] % m;
            for(int d = 0 ;d < 4 ;d++){
                int count=0;
                int r = sr + dir[d][0];
                int c = sc + dir[d][1];
                
                while(r >= 0 && c >=0 && r < n && c < m && maze[r][c] == 0){
                    r = r + dir[d][0];
                    c = c + dir[d][1];
                    count++;
                }
                r -= dir[d][0];
                c -= dir[d][1];
                if(dist[r][c] <= rv[1] + count) continue;
                
                dist[r][c] = rv[1] + count;
               
                que.add(new int[]{r * m + c,rv[1] + count});
            }
        }
        return dist[er][ec] == (int)1e9 ? -1 : dist[er][ec];
    }
}