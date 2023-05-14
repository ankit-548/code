import java.util.ArrayList;
import java.util.Collections;
// import java.util.List;
import java.util.Stack;
import java.util.*;
@SuppressWarnings("unchecked")

public class graphDisjointSet {
    static int[] par = new int[10];
    static int rank[] = new int[10];

    static void init() {
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        // optimised
        return par[x] = find(par[x]);
        // return find(par[x]);
    }

    public static void union(int b, int a) {
        int parA = par[a];
        int parB = par[b];
        if (rank[parA] == rank[parB]) {
            par[parA] = parB;
            rank[parB]++;
        } else if (rank[parA] > rank[parB]) {
            par[parB] = parA;// in dono cases me koi rank update nhi hoga
        } else {
            par[parA] = parB;
        }
    }

    public static class Edges implements Comparable<Edges> {
        int src;
        int dest;
        int wt;

        Edges(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edges e) {
            return this.wt - e.wt;
        }
    }

    public static void createGraph(ArrayList<Edges> graph) {
        graph.add(new Edges(0, 1, 10));
        graph.add(new Edges(0, 2, 15));
        graph.add(new Edges(0, 3, 30));
        graph.add(new Edges(1, 3, 40));
        graph.add(new Edges(2, 3, 50));
    }

    // Q.17 kruskalsAlgo(
    public static void kruskalsAlgo(ArrayList<Edges> graph, int V) {
        init();
        Collections.sort(graph);
        int count = 0;
        int costCount = 0;
        for (int i = 0; count < V - 1; i++) {
            Edges e = graph.get(i);
            int parA = par[e.src];
            int parB = par[e.dest];
            if (parA != parB) {
                par[parB] = parA;
                costCount += e.wt;
            }
            count++;
        }
        System.out.print(costCount);
    }

    // Q18. floodFill
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

    public static void helper(int[][] image, int sr, int sc, int color, boolean[][] vis, int orgCol) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != orgCol) {
            return;
        }
        vis[sr][sc] = true;
        image[sr][sc] = color;
        // left
        helper(image, sr, sc - 1, color, vis, orgCol);
        // right
        helper(image, sr, sc + 1, color, vis, orgCol);
        // up
        helper(image, sr - 1, sc, color, vis, orgCol);
        // down
        helper(image, sr + 1, sc, color, vis, orgCol);
    }

    // Strongly Connected Component
    // Q.19 kosaraju's Algorithm
    public static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // public static void createGraph(ArrayList<Edge>[] graph) {
    // graph[0].add(new Edge(0, 2, 0));
    // graph[0].add(new Edge(0, 3, 0));
    // graph[2].add(new Edge(2, 1, 0));
    // graph[1].add(new Edge(1, 0, 0));
    // graph[3].add(new Edge(3, 4, 0));
    // }

    public static void topSort(ArrayList<Edge>[] graph, Stack<Integer> s, boolean vis[], int curr) {
        vis[curr] = true;
        for (int j = 0; j < graph[curr].size(); j++) {
            Edge e = graph[curr].get(j);
            if (!vis[e.dest]) {
                vis[e.dest] = true;
                topSort(graph, s, vis, e.dest);
            }
        }
        s.push(curr);
    }

    // public static void dfs(ArrayList<Edge>[] graph, boolean vis[], int i) {
    // vis[i] = true;
    // System.out.print(i + " ");
    // for (int j = 0; j < graph[i].size(); j++) {
    // Edge e = graph[i].get(j);
    // if (!vis[e.dest]) {
    // vis[e.dest] = true;
    // dfs(graph, vis, e.dest);
    // }
    // }
    // }

    // public static void kosarajusAlgo(ArrayList<Edge>[] graph, int v) {
    //     Stack<Integer> s = new Stack<>();
    //     boolean vis[] = new boolean[v];
    //     // 1. get Nodes in stack
    //     for (int i = 0; i < graph.length; i++) {
    //         if (!vis[i]) {
    //             topSort(graph, s, vis, i);
    //         }
    //     }
    //     // 2. transpose the graph
    //     ArrayList<Edge>[] transpose = new ArrayList[v];
    //     for (int i = 0; i < v; i++) {
    //         vis[i] = false;
    //         transpose[i] = new ArrayList<>();
    //     }
    //     for (int i = 0; i < graph.length; i++) {
    //         for (int j = 0; j < graph[i].size(); j++) {
    //             Edge e = graph[i].get(j);
    //             transpose[e.dest].add(new Edge(e.dest, e.src, e.wt));
    //         }
    //     }
    //     // 3. dfs according stack nodes on dfs
    //     while (!s.isEmpty()) {
    //         int i = s.pop();
    //         if (!vis[i]) {
    //             System.out.print("SCC->");
    //             // dfs(transpose, vis, i);
    //             System.out.println();
    //         }
    //     }
    // }

    // Q. 20 tarjan's algorithm
    public static void createGraph(ArrayList<Edge>[] graph) {
        graph[0].add(new Edge(0, 1, 0));
        graph[0].add(new Edge(0, 2, 0));
        graph[0].add(new Edge(0, 3, 0));
        graph[1].add(new Edge(1, 2, 0));
        graph[1].add(new Edge(1, 0, 0));
        graph[2].add(new Edge(2, 0, 0));
        graph[2].add(new Edge(2, 1, 0));
        graph[3].add(new Edge(3, 0, 0));
        graph[3].add(new Edge(3, 4, 0));
        graph[3].add(new Edge(3, 5, 0));
        graph[4].add(new Edge(4, 3, 0));
        graph[4].add(new Edge(4, 5, 0));
        graph[5].add(new Edge(5, 3, 0));
        graph[5].add(new Edge(5, 4, 0));
    }

    public static void tarjansAlgo(ArrayList<Edge>[] graph, int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean[] vis = new boolean[V];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfs(graph, i, V, dt, low, vis, -1, 0);
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int V, int dt[], int low[],
                           boolean[] vis, int  par, int time) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(e.dest == par) {// 1.
               continue; 
            } else if(!vis[e.dest]) {// 2.
                dfs(graph, e.dest, V, dt, low, vis, par, time);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if(dt[curr] < low[e.dest]) {
                    System.out.print("Bridge" + curr +"----"+ e.dest);                
                }
            } else { //3.
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }
    // Q. 21 Articulation point
    public static void articulationPoint(ArrayList<Edge>[] graph, int v) {
        int low[] = new int[v];
        int dt[] = new int[v];
        boolean vis[] = new boolean[v];
        boolean ap[] = new boolean[v];
        for(int i=0; i<v; i++) {
            if(!vis[i]) {
                dfsAP(graph, v, 0, low, dt, vis, -1, i, ap);
            }
        }
        for(int i=0; i<v; i++) {
            if(ap[i]) {
                System.out.println("AP: " + i);
            }
        }
    }
    public static void dfsAP(ArrayList<Edge>[] graph, int v, int time, int low[],
                             int dt[], boolean vis[], int par, int curr, boolean ap[]) {
        vis[curr] = true;
        low[curr] = dt[curr] = ++time;
        int children = 0;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
           if(e.dest == par) {
            continue;
           } else if(vis[e.dest]) {
             low[curr] = Math.min(low[curr], dt[e.dest]);
           } else {
            dfsAP(graph, v, time, low, dt, vis, curr, e.dest, ap);
            low[curr] = Math.min(low[curr], low[e.dest]);
            if(par != -1 && dt[curr] <= low[e.dest]) {
             ap[curr] = true;
            }
            children++;
           }
        }
        if(par == -1 && children>1) {
            ap[curr] = true;
           }
    }
    public static void main(String args[]) {
        // init();
        // union(1, 3);
        // System.out.println(find(3));
        // union(2, 4);
        // union(3, 6);
        // union(1, 4);
        // System.out.println(find(3));
        // System.out.println(find(4));
        // union(1, 5);
        // int V=4;
        // ArrayList<Edges> graph = new ArrayList<>();
        // createGraph(graph);
        // kruskalsAlgo(graph, V);
        // int[][] image = {{1, 1, 1},
        // {1, 1, 0},
        // {1, 0, 1}};
        // int res[][] = floodFill(image, 1, 1, 2);
        // for(int i=0; i<3; i++) {
        // for(int j=0; j<3; j++) {
        // System.out.print(res[i][j]+ " ");
        // }
        // System.out.println();
        // }
        // int v = 5;
        // ArrayList<Edge>[] graph = new ArrayList[v];
        // for (int i = 0; i < v; i++) {
        // graph[i] = new ArrayList<>();
        // }
        // createGraph(graph);
        // kosarajusAlgo(graph, v);
        // int v = 6;
        // // @SuppressWarnings("unchecked")
        // ArrayList<Edge> graph[] = new ArrayList[v];

        // for (int i = 0; i < graph.length; i++) {
        //     graph[i] = new ArrayList<Edge>();
        // }
        // graph[0].add(new Edge(0, 1, 0));
        // graph[0].add(new Edge(0, 2, 0));
        // graph[0].add(new Edge(0, 3, 0));
        // graph[1].add(new Edge(1, 2, 0));
        // graph[1].add(new Edge(1, 0, 0));
        // graph[2].add(new Edge(2, 0, 0));
        // graph[2].add(new Edge(2, 1, 0));
        // graph[3].add(new Edge(3, 0, 0));
        // graph[3].add(new Edge(3, 4, 0));
        // graph[3].add(new Edge(3, 5, 0));
        // graph[4].add(new Edge(4, 3, 0));
        // graph[4].add(new Edge(4, 5, 0));
        // graph[5].add(new Edge(5, 3, 0));
        // graph[5].add(new Edge(5, 4, 0));
        // // createGraph(graph);
        // tarjansAlgo(graph, v);
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<v; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 0));
        graph[0].add(new Edge(0, 2, 0));
        graph[0].add(new Edge(0, 1, 0));
        graph[1].add(new Edge(1, 3, 0));
        graph[1].add(new Edge(1, 0, 0));
        graph[2].add(new Edge(2, 1, 0));
        graph[2].add(new Edge(2, 0, 0));
        graph[3].add(new Edge(3, 0, 0));
        graph[3].add(new Edge(3, 4, 0));
        graph[4].add(new Edge(4, 3, 0));
        articulationPoint(graph, v);
    }
}
