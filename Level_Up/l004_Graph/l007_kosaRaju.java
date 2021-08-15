public class l007_kosaRaju{


    public static void topoOrder(ArrayList<Edge>[] graph,int src,boolean[] vis,ArrayList<Integer> ans){
        vis[src]=true;
        for(Edge e: graph[src]){
            if(!vis[e.v]){
                topoOrder(graph,e.v,vis,ans);
            }
        }
        ans.add(src);
    }

    public static void dfs_SCC_comp(ArrayList<Edge>[] graph,int src,boolean[] vis,ArrayList<Integer> components){
        vis[src]=true;
        components.add(src);
        for(Edge e: graph[src]){
            if(!vis[e.v]){
                topoOrder(graph,e.v,vis,components);
            }
        }
    }

    public static void l007_kosaRaju(){
        
    }
}