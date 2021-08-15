
public class l004_kruskalAlgo{
    int[] size;
    int par[];
    public static void kruskalAlgo(int N,int[][] edges){
        Arrays.sort(edges,(a,b)->{
            return a[2] - b[2];
        })
        ArrayList<Edges>[] graph=new ArrayList[N];
        for(int i=0;i<N;i++) graph[i]=new ArrayList<>();

        unionFind(edges,graph);
    }

    public static void unionFind(int[][] edges,ArrayList<Edge>[] graph){
        int n = graph.size();
        par=new int[n];
        size=new int[n];

        for(int i=0;i<n;i++){
            size[i]=1;
            par[i]=i;
        }

        for(int[] e : edges){
            int u = e[0],v = e[1] , w = e[2];
            int p1 = findPar(u);
            int p2 = findPar(v);
            if(p1 != p2){
                union(p1,p2);
                addEdge(u,v,w);
            }
        }
    }

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

    public static int find(int u){
        return par[u] == u ? u : (par[u] = find(par[u]));
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


    // ==========================================================================================================================================================
    // 1168 - Optimize Water Distribution in a Village
    // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/optimize-water-distribution-official/ojquestion#!

    public static int minCost(int n,int[] wells , int[][] pipes){
        ArrayList<int[]> allPipes=new ArrayList<>();
        for(int[] p:pipes){
            allPipes.add(p);
        }

        for(int i=1;i<=n;i++){
            allPipes.add(new int[]{0,i,wells[i-1]});
        }

        collections.sort(allPipes,(a,b)->{
            return a[2] - b[2];
        });
        int minCost=0;
        int[] par=new int[n+1];
        int[] size = new int[n+1];
        for(int i=0;i<=n;i++) {
            par[i]=i;
            size[i]=1;
        }
        for(int[] e : allPipes){
            int p1 = findPar(par[e[0]]);
            int p2 = findPar(par[e[1]]);
            if(p1 != p2){
                minCost += e[2];
                if(size[p2] < size[p1]){
                    par[p2]=p1;
                }
                else{
                    par[p1]=p2;
                }
            }
        }

        return minCost;
    }

}