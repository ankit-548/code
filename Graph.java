import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Stack;
@SuppressWarnings("unchecked")
public class Graph {
    public static class Edge {
        int src; int dest; int wt;
        Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }
    // 2. Graph Traversal

    public static void getGraph(ArrayList<Edge>[] graph) {
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));
    }
     public static void bfs(ArrayList<Edge>[] graph) {
        // using Queue and visited array
        Queue<Integer> q = new LinkedList<>();
        boolean isVisited[] = new boolean[graph.length];

        q.add(0);
        while(!q.isEmpty()) {
            Integer curr = q.remove();
            if(isVisited[curr]!=true) {
                isVisited[curr] = true;
                System.out.print(curr + " ");
                for(Integer i=0; i<graph[curr].size(); i++) {
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
     }
     // Q3. dfs
     public static void dfs(ArrayList<Edge>[] graph, int vertex, boolean[] isVisited) {
        System.out.print(vertex+ " ");
        isVisited[vertex] = true;
        for(int i=0; i<graph[vertex].size(); i++) {
            int des = graph[vertex].get(i).dest;
            if(!isVisited[des]) {
                dfs(graph, des, isVisited);
            }
        }
     }
       // Q4. hasPath
       public static boolean hasPath(ArrayList<Edge>[] graph, int src, int des, boolean[] isVisited) {
        if(src==des) {
            return true;
        }
        isVisited[src] = true;
        for(int i=0; i<graph[src].size(); i++) {
            int curr = graph[src].get(i).dest;
            if(!isVisited[curr] && hasPath(graph, curr, des, isVisited)) {
                return true;
            }
        }
        return false;
       }
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
    boolean visited[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!visited[i]) {
                if(detectCycleutil(graph, visited, i, -1)) {
                    return true;
                }
            }
            
        }
        return false;
    }
    public static boolean detectCycleutil(ArrayList<Edge>[] graph, boolean[] visited, int vertex, int par) {
        visited[vertex] = true;
        for(int i=0; i<graph[vertex].size(); i++) {
            int neigh = graph[vertex].get(i).dest;
            // case:1
            if(visited[neigh] && neigh!=par) {
                return true;
            }
            // case:3
            else if(!visited[neigh]) {
                if(detectCycleutil(graph, visited, neigh, vertex)) {
                    return true;
                }            
            }
            // case:2 
        }
        return false;
    }
    // Q6. isBipartite
    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int col[] = new int[graph.length];
        for(int i=0; i<col.length; i++) {
            col[i] = -1;// no color
        }
        Queue<Integer> q = new LinkedList<>();
        for(int j=0; j<graph.length; j++) {// if our graph has different components
          if(col[j]==-1) {
            q.add(j);
            col[j]=0;
            while(!q.isEmpty()) {
                int curr = q.remove();
                    for(int i=0; i<graph[curr].size(); i++) {
                        int neigh = graph[curr].get(i).dest;
                        if(col[neigh] == -1) {
                            q.add(neigh);
                            col[neigh] = col[curr]==0 ? 1 : 0;
                        } else if(col[neigh] == col[curr]) {
                            return false;
                        }
                    }
            }
          }
          
        }
        
        return true;
    }
    // Q7. isCyclic
    public static boolean isCyclic(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!visited[i]) {
                if(isCyclicUtil(i, visited, stack, graph)) {
                    return true;
                }
            }            
        }
        return false;
    }
    public static boolean isCyclicUtil(int curr, boolean[] visited,boolean[] stack, ArrayList<Edge>[] graph) {
        stack[curr] = true; 
        visited[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) {
                return false;
            }
            if(!visited[e.dest] && isCyclicUtil(e.dest, visited, stack, graph)) {
                return true;
            }
            stack[curr] = false;
        }
        return false;
    }
    public static void topSortdfs(ArrayList<Edge>[] graph) {
        boolean visit[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<graph.length; i++) {
            if(!visit[i]) {
                topSortUtil(graph, i, visit, s);
            }
        }
        while(!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] visit, Stack<Integer> s) {
        visit[curr] = true; 
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visit[e.dest]) {
                topSortUtil(graph, e.dest, visit, s);
            }
        }
        s.push(curr);
    }
    // Q9. topological sort using Bfs
    public static void getindeg(int indeg[], ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
            int v=i;
            for(int j=0; j<graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void topSortBfs(ArrayList<Edge>[] graph) {
        int indeg[] = new int[graph.length];
        getindeg(indeg, graph);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }
    // Q. 10 All path from src to dest
    public static void allPath(ArrayList<Edge>[] graph, int src, int dest, String str) {
        if(src == dest) {
            System.out.println(str+dest);
            return;
        }
        for(int i=0; i<graph[src].size(); i++) {
                Edge e = graph[src].get(i);
                allPath(graph, e.dest, dest, str+src);
            
        }
    }

    //public static void main(String args[]) {
       /* int n = 5;// vertices
        // 1. Create Array 
        ArrayList<Edge>[] graph = new ArrayList[n]; // this graph initially store null values
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        graph[4].add(new Edge(4, 2, 2));
        
        for(int i=0; i<graph[2].size(); i++) { // to find all destination of 2
            System.out.print(graph[2].get(i).dest + " ");
        }
        */
        /*int g=7;
        ArrayList<Edge>[] graph = new ArrayList[g];
        for(int i=0; i<g; i++) {
            graph[i] = new ArrayList<>();
        }
        getGraph(graph);
        //bfs(graph);
        boolean isVisited[] = new boolean[g];
        //dfs(graph, 0, isVisited);
        //System.out.println(hasPath(graph, 0, 5, isVisited));
        */
        /*int g=7;
        ArrayList<Edge>[] graph = new ArrayList[g];
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));     
        System.out.println(detectCycle(graph));*/
        /*int n = 4;
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
       // graph[2].add(new Edge(2, 4, 1));
        graph[2].add(new Edge(2, 3, 1)); 
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 2, 1));
       // graph[3].add(new Edge(3, 4, 1));
       // graph[4].add(new Edge(4, 2, 1));
        //graph[4].add(new Edge(4, 3, 1));
        //System.out.print(isBipartite(graph));
        if(detectCycle(graph)) {
           if(graph.length % 2 == 0) {
             System.out.println("bipartite");
           } else {
             System.out.println("non-bipartite");
           }
        } else {
            System.out.println("bipartite");
        }*/
        /*int n=4;
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 1, 1));
        System.out.println(isCyclic(graph));*/
        /*int n = 6;
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));
        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));*/

        // topSortdfs(graph);
        // topSortBfs(graph);
        // allPath(graph, 5, 1, "");
        // int n=6;
        // ArrayList<Edge>[] graph = new ArrayList[n];
        // for(int i=0; i<graph.length; i++) {
            //     graph[i] = new ArrayList<>();
            // }
            // graph[5]
    //}
        public static class Info implements Comparable<Info> {
            int n; int path;
            Info(int n, int path) {
               this.n = n;
               this.path = path;
            }
            @Override
            public int compareTo(Info o) {
               return this.path-o.path;
            }
        }
        //Q.11 dijkstras
        public static void dijkstras(ArrayList<Edge>[] graph, int src) {
          int dis[] = new int[graph.length];
          for(int i=0; i<dis.length; i++) {
            if(i!=src) {
                dis[i] = Integer.MAX_VALUE;
            }
          }
          PriorityQueue<Info> pq = new PriorityQueue<>();
          pq.add(new Info(src, 0));
          boolean vis[] = new boolean[graph.length];
          while(!pq.isEmpty()) {
            Info curr = pq.remove();
            if(!vis[curr.n]) {
                vis[curr.n] = true;
                for(int i=0; i<graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dis[u]+wt < dis[v]) {
                        dis[v] = dis[u] + wt;
                        pq.add(new Info(v, dis[v]));
                    }
                }
            }
          }
          for(int i=0; i<dis.length; i++) {
            System.out.print(dis[i] + " ");
          }

        }
         // Q12. bellmanFord
         public static void bellmanFord(ArrayList<Edge>[] graph, int src) {
            int dis[] = new int[graph.length];
            for(int i=0; i<graph.length; i++) {
                if(i!=src) {
                    dis[i] = Integer.MAX_VALUE;
                }
            }
            int V = graph.length-1;
            for(int i=0; i<V; i++) {
                for(int j=0; j<graph.length; j++){
                    for(int k=0; k<graph[j].size(); k++) {
                        Edge e = graph[j].get(k);
                        int u = e.src;
                        int v = e.dest;
                        int wt = e.wt;
                        if(dis[u]!=Integer.MAX_VALUE && dis[u]+wt < dis[v]) {
                            dis[v] = dis[u]+wt;
                        }
                    }
                }
            }
            for(int i=0; i<dis.length; i++) {
                System.out.print(dis[i] + " ");
            }
         }
         // prim's Algorithm
         public static class File implements Comparable<File> {
            int v, cost;
            public File(int v, int cost) {
                this.v=v;
                this.cost = cost;
            }
            @Override
            public int compareTo(File i) {
                return this.cost-i.cost; // ascending 
            }
         }
         public static void primsAlgorithm(ArrayList<Edge>[] graph) {
            PriorityQueue<File> pq = new PriorityQueue<>();
            pq.add(new File(0, 0));
            boolean[] vis = new boolean[graph.length];
            int finalCost = 0;
            while(!pq.isEmpty()) {
                File curr = pq.remove();
                if(!vis[curr.v]) {
                    finalCost += curr.cost;
                    vis[curr.v] = true;
                    for(int i=0; i<graph[curr.v].size(); i++) {
                        Edge e = graph[curr.v].get(i);
                        pq.add(new File(e.dest, e.wt));                        
                    }
                }
            }
            System.out.print(finalCost);

         }
         //Q14. cheapest Flight
         public static class Inf {
            int v, cost, stops;
            Inf(int v, int c, int s) {
                this.v = v;
                this.cost = c; 
                this.stops = s;
            }
         }
         public static void cheapestFlight(int[][] flight, int src, int dest, int k) {
            ArrayList<Edge>[] graph = new ArrayList[flight.length];
            for(int i=0; i<graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            for(int i=0; i<flight.length; i++) {
                int s = flight[i][0];
                int d = flight[i][1];
                int c = flight[i][2];
                Edge e = new Edge(s, d, c);
                graph[s].add(e);
            }
            int dis[] = new int[graph.length];
            for(int i=0; i<dis.length; i++) {
                if(i!=src) {
                    dis[i] = Integer.MAX_VALUE;
                }
            }
            Queue<Inf> q = new LinkedList();
            q.add(new Inf(src, 0, 0));
            while(!q.isEmpty()) {
                Inf curr = q.remove();
                if(curr.stops > k) {
                    break;
                }
                for(int i=0; i<graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(curr.cost + wt < dis[v] && curr.stops<=k) {  // for reason check dry run
                    // if(dis[u] != Integer.MAX_VALUE && dis[u]+wt < dis[v] && curr.stops<=k) {
                        dis[v] = dis[u] + wt;
                        q.add(new Inf(v, dis[v], curr.stops+1));
                    }
                }
            }
            if(dis[dest] == Integer.MAX_VALUE) {
                System.out.print(-1);
            } else {
                System.out.print(dis[dest]);
            }
         }
         // Connecting cities with Minimum Cost
         public static class Edges implements Comparable<Edges> {
            int des; int cost;
            Edges(int d, int c) {
                this.des = d;
                this.cost = c;
            }
            @Override
            public int compareTo(Edges o) {
                return this.cost-o.cost;
            }
         }
         public static void connectCities(int cities[][]) {
            PriorityQueue<Edges> pq = new PriorityQueue<>();
            boolean vis[] = new boolean[cities.length];
            pq.add(new Edges(0, 0));
            int totalCost=0;
            while(!pq.isEmpty()) {
                Edges curr = pq.remove();
                if(!vis[curr.des]) {
                    vis[curr.des ]=true;
                    totalCost += curr.cost;
                    for(int i=0; i<cities[curr.des].length; i++) {
                        if(cities[curr.des][i] != 0) {
                            pq.add(new Edges(i, cities[curr.des][i]));
                        }
                    }
                }
            }
            System.out.println(totalCost);
         }
        public static void main(String args[]) {
            int n=9;
            ArrayList<Edge>[] graph  = new ArrayList[n];
            for(int i=0; i<graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            // graph[0].add(new Edge(0, 1, 2));
            // graph[0].add(new Edge(0, 2, 4));
            // graph[1].add(new Edge(1, 2, 1));
            // graph[1].add(new Edge(1, 3, 7));
            // graph[2].add(new Edge(2, 4, 3));
            // graph[4].add(new Edge(4, 3, 2));
            // graph[4].add(new Edge(4, 5, 5));
            // graph[3].add(new Edge(3, 5, 1));
            // dijkstras(graph, 0);
            // graph[0].add(new Edge(0, 1, 2));
            // graph[0].add(new Edge(0, 2, 4));
            // graph[1].add(new Edge(1, 2, -4));
            // graph[2].add(new Edge(2, 3, 2));
            // graph[3].add(new Edge(3, 4, 4));
            // graph[4].add(new Edge(4, 1, -1));
            // bellmanFord(graph, 0);
            // graph[0].add(new Edge(0, 1, 10));
            // graph[0].add(new Edge(0, 2, 15));
            // graph[0].add(new Edge(0, 3, 30));
            // graph[1].add(new Edge(1, 0, 10));
            // graph[1].add(new Edge(1, 3, 40));
            // graph[2].add(new Edge(2, 0, 15));
            // graph[2].add(new Edge(2, 3, 50));
            // graph[3].add(new Edge(3, 0, 30));
            // graph[3].add(new Edge(3, 1, 40));
            // graph[3].add(new Edge(3, 2, 50)); 
            // primsAlgorithm(graph);
            // int flight[][] = {{0, 1, 100}, {1, 2, 100}, {1, 3, 600}, {2, 0, 100}, {2, 3, 200}};
            // cheapestFlight(flight, 0, 3, 1);
            int cities[][] = {{0, 1, 2, 3, 4}, {1, 0, 5, 0, 7}, {2, 5, 0, 6, 0}, {3, 0, 6, 0, 0}, {4, 7, 0, 0, 0}};
            connectCities(cities);
        }

}