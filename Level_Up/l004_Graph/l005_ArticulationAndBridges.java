public class l005_ArticulationAndBridges{
    static int[] disc;
    static int[] low;
    static int rootCall=0;
    static boolean[] isArticulation;
    static boolean[] vis;
    static int time=0;
    public static void articulationPointAndBridges(ArrayList<Edge>[] graph){
        int N = graph.length;
        disc=new int[N];
        low=new int[N];
        isArticulation = new boolean[N];
        vis = new boolean[N];
        for(int i=0;i<N;i++){
            dfs(graph,i,-1);
        }
    }

    public static void dfs(ArrayList<Edge> graph,int src,int par){
        disc[src] = low[src] = time++;
        vis[src]=true;

        for(Edge e : graph[src]){
            if(!vis[e.v]){
                dfs(graph,e.v,src);
                if(par == -1) rootCall++;
                if(disc[src] <= low[e.v]) isArticulation[src]=true;
                low[src] = Math.min(low[e.v],low[src]);
            }
            else if(par != e.v){
               low[src] = Math.min(low[src],disc[e.v]);
            }
        }
    }
}