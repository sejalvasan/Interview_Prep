// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    ArrayList<ArrayList<Integer>> V;
    boolean dfs(int v, int[] label, int count, int N)
    {
        label[v] = 1;
        if(count == N)
            return true;

        for(int j = 0; j < V.get(v).size(); j++)
        {
            if(label[V.get(v).get(j)] == 0)
            {
                if(dfs(V.get(v).get(j), label, count+1, N))
                    return true;
                label[V.get(v).get(j)] = 0;
            }
        }

        return false;
    }
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        // code here
        V = new ArrayList<>();
        for(int i = 0; i <= N; i++)
            V.add(new ArrayList<>());

        for(ArrayList<Integer> i : Edges)
        {
            V.get(i.get(0)).add(i.get(1));
            V.get(i.get(1)).add(i.get(0));
        }

        int[] label = new int[15];

        for(int i = 0; i < N; i++)
        {
            if(dfs(i, label, 1, N))
                return true;
            label[i] = 0;
        }
        return false;
    }
}