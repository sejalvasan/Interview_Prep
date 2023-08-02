//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

// class Pair{
//     int val;
//     int par;
//     Pair(int val, int par){
//         this.val = val;
//         this.par = par;
//     }
// }
// class Solution {
//     // Function to detect cycle in an undirected graph.
//     public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
//         // Code here
        
//         boolean[]vis = new boolean[V];
        
//         for(int i=0;i<V;i++){
//             if(vis[i]==false){
//                 if(bfs(adj,vis,i)==true)
//                 return true;
//             }
//         }
//         return false;
//     }
    
//     public boolean bfs(ArrayList<ArrayList<Integer>>adj, boolean[]vis, int src){
//         Queue<Pair> q = new LinkedList<>();
//         q.add(new Pair(src,-1));
//         vis[src]=true;
        
//         while(!q.isEmpty()){
//             Pair rem = q.remove();
            
//             for(Integer it: adj.get(rem.val)){
//                 if(vis[it]==false)
//                 {
//                     q.add(new Pair(it, rem.val));
//                     vis[it]=true;
//                 }else if(rem.par!=it)
//                 return true;
//             }
//         }
        
//         return false;
        
//     }
// }

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if(checkCycle(adj, vis, i, -1)==true)
                return true;
            }
        }
        
        return false;
    }
    
    public boolean checkCycle(ArrayList<ArrayList<Integer>> adj, boolean[]vis,
    int node, int par){
        vis[node]=true;
        
        for(Integer it: adj.get(node)){
            if(vis[it]==false){
                if(checkCycle(adj, vis, it, node)==true)
                return true;
            }else if(it!=par)
            return true;
        }
        
        return false;
    }
}