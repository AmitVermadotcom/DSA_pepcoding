public class l003_unionFind{

    public static class Edge {
        int v = 0, w = 0;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    // T.C - O(2E)
    public static void display(ArrayList<Edge>[] graph) {
        int N = graph.length;
        for (int i = 0; i < N; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print("(" + e.v + ", " + e.w + ") ");
            }
            System.out.println();
        }
    }
    // ===============================================================================================================================
    static int[] size;
    static int[] par;
    public static int find(int u){
        if(par[u] == u) return u;

        return par[u] = find(par[u]);
    }

    public static union(int p1,int p2){
        if(size[p1] < size[p2]){
            par[p1] = p2;
            size[p2] += size[p1];
        }
        else{
            par[p2] = p1;
            size[p1] += size[p2];
        }
    }

    public static void unionFind(int[][] edges){
        int N = edges.length;
        ArrayList<Edge>[] graph=new ArrayList[N];
        for(int i=0;i<N;i++) graph[i]=new ArrayList<>();

        size = new int[N];
        par = new int[N];

        for(int i=0;i<N;i++){
            size[i]=1;
            par[i]=i;
        }

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];

            int p1 = find(u);
            int p2 = find(v);

           if(p1 != p2){
                union(p1,p2);
                addEdge(graph,u,v,w);
           }
        }
    }


    //Questions================================

    //Lexicographically Smallest Equivalent String
    public static int findPar(int u){
        if(parent[u] == u) return u;
        return parent[u] = findpar(parent[u]);
    }
    public static void LSES(A string, B string, S string){
        int n =A.length();
        int[] par=new int[26];
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            char c1 = A.charAt(i);
            char c2 = B.charAt(i);
            int p1 = findPar(c1 - 'a');
            int p2 = findPar(c2-'a');
            if(p1 != p2){
                if(p1 < p2){
                    parent[p2]=p1;
                }
                else{
                    parent[p1]=p2;
                }
            }
        }
        String ans="";
        for(int i=0;i<S.length();i++){
            char c1 = S.charAt(i);
            ans += findPar(c1-'a') + 'a';
        }
    }


    // Number of Islands - II
    // https://www.lintcode.com/problem/434/
    // T.c = O(k) (assume path compression) 
    // T.c = O(k * log(mn)) without path compression

    public static int findPar(int u,int[] par){
        if(par[u] == u) return u;
        return par[u] = findPar(par[u],par);
    }

    int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> ans=new ArrayList<>();
        if(operators == null) return ans;
        int[] par=new int[n*m];
        for(int i=0;i<n*m;i++) par[i] = -1;
        int count=0;
        
        for(Point p : operators){
            int r = p.x;
            int c = p.y;
            if(par[r*m+c] == -1){
                count++;
                par[r*m+c] == r*m+c;
                int p1 = findPar(r*m+c,par);

                for(int d=0;d < 4; d++){
                    int nr = r + dir[d][0];
                    int nc = c + dir[d][1];
                    if(nr >=0 && nc >= 0 && nr <n && nc <m && par[nr*m+nc] != -1){
                        int p2 = findPar(nr *m + nc,par);
                        if(p1 != p2){
                            par[p2]=p1;
                            count--;
                        }
                    }
                }
                
            }
            ans.add(count);
        }
        return ans;
    }

    // leetcode 924 Malware spread Infection
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int N = graph.length;
        int[] par = new int[N];
        int[] poc = new int[N];         // poc -> population of country

        for(int i;i<N;i++){
            poc[i]=1;
            par[i]=i;
        }
        for(int i=0;i<N;i++){
            for(int j = 0;j<N;j++){
                if(i != j){
                    int p1 = findPar(i);
                    int p2 = findPar(j);
                    if(p1 != p2){
                        par[p2]=p1;
                        pop[p1] += poc[p2];
                    }

                }
            }
        }

        int[] ipc = new int[N];  // ipc -> infected person in country

        for(int ip : initial){
            int p = findPar(ip);
            ipc[p]++;
        }

        Arrays.sort(initial);
        int maxPop = 0;
        int c = 0;
        for(int e : initial){
            int p = findPar(e);
            if(ipc[p] == 1 && size[p] > maxPop){
                maxPop = size[p];
                c=e;
            }
        }
        return c;
    }
    
}