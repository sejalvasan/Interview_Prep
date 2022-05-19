// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
 //   static int count =0;
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        Stack<Integer> st = new Stack<>();
        boolean[]vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i]==false)
            dfs(adj,vis,i,st);
        }
        int pot_ans = st.pop();
        vis = new boolean[V];
        
        dfs2(adj,vis,pot_ans);
        
        // if(count==V)
        // return pot_ans+1;
for(int i =0;i<V;i++){
    if(vis[i]==false)
    return -1;
}
        return pot_ans;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>>adj, boolean[]vis,int node, Stack<Integer> st){
        vis[node]=true;
        for(int nbr: adj.get(node)){
            if(vis[nbr]==false)
           dfs(adj,vis,nbr,st);
        }
        st.add(node);
    }
    
    public void dfs2(ArrayList<ArrayList<Integer>>adj, 
    boolean[]vis,int pot_ans){
        vis[pot_ans]=true;
             //   count++;

        for(int nbr: adj.get(pot_ans)){
            if(vis[nbr]==false)
           dfs2(adj,vis,nbr);
        }
    }
    
}