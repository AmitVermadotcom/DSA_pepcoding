public class l006_dijikstraAlgo{
    public static class pair {
        int vtx, par, w, wsf;

        // dijikstra_01
        pair(int vtx, int par, int w, int wsf) {
            this.vtx = vtx;
            this.par = par;
            this.w = w;
            this.wsf = wsf;
        }
        // dijikstra_02
        pair(int vtx, int wsf) {
            this.vtx = vtx;
            this.wsf = wsf;
        }
    }

    public static void dijikstra_01(ArrayList<Edge>[] graph, int src) {
        int N = graph.length;
        ArrayList<Edge>[] ngraph = new ArrayList[N];
        for (int i = 0; i < N; i++)
            ngraph[i] = new ArrayList<>();
        boolean[] vis = new boolean[N];
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> {
            return a.wsf - b.wsf;
        });

        int[] dis = new  int[N];
        int[] par = new  int[N];

        pq.add(new pair(src, -1, 0, 0));
        while (pq.size() != 0) {
            pair p = pq.remove();

            if (p.par != -1)
                addEdge(ngraph, p.vtx, p.par, p.w);

            if (vis[p.vtx])
                continue;

            vis[p.vtx] = true;
            
            dis[p.vtx] = p.wsf;
            par[p.vtx] = p.par;

            for (Edge e : graph[p.vtx]) {
                if (!vis[e.v])
                    pq.add(new pair(e.v, p.vtx, e.w, p.wsf + e.w));
            }
        }
    }

    public static void dijikstra_02(ArrayList<Edge>[] graph, int src) {
        int N = graph.length;
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> {
            return a.wsf - b.wsf;
        });

        int[] dis = new  int[N];
        int[] par = new  int[N];

        pq.add(new pair(src, -1, 0, 0));
        while (pq.size() != 0) {
            pair p = pq.remove();
            if (p.wsf >= dis[p.vtx])
                continue;
            
            
            for (Edge e : graph[p.vtx]) {
                if (p.wsf + e.w < dis[e.v])
                    dis[e.v] = p.wsf + e.w;
                    par[p.vtx] = p.vtx;
                    pq.add(new pair(e.v, p.wsf + e.w));
            }
        }
    }

    public static class pair {
        int vtx,w;

        pair(int vtx, int w) {
            this.vtx = vtx;
            this.w = w;
        }
    }

    public static void prism(ArrayList<Edge>[] graph, int src) {
        int N = graph.length;
        
        boolean[] vis = new boolean[N];
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> {
            return a.w - b.w;
        });

        int[] dis = new  int[N];
        Arrays.fill(dis,(int)1e8);
        pq.add(new pair(src, 0));
        while (pq.size() != 0) {
            pair p = pq.remove();

            if (vis[p.vtx])
                continue;
                
            vis[p.vtx]=true;
            for (Edge e : graph[p.vtx]) {
                if (e.w < dis[e.v] )
                    dis[e.v] = e.w;
                    pq.add(new pair(e.v, e.w));
            }
        }
    }
    
}