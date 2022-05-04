// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            int p = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<Integer>();
            ArrayList<Integer> b = new ArrayList<Integer>();
            ArrayList<Integer> d = new ArrayList<Integer>();
            
            for(int i=0;i<p;i++)
            {
                a.add(sc.nextInt());
                b.add(sc.nextInt());
                d.add(sc.nextInt());
            }
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.solve(n, p, a, b, d); 
            System.out.println(ans.size());
            for (int i=0;i<ans.size();i++){ 
                System.out.println(ans.get(i).get(0)+" "+ans.get(i).get(1)+" "+ans.get(i).get(2)); 
            }
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int n, p;
    int rd[], wt[], cd[], ans;
    
    int dfs(int w){
    	if (cd[w] == 0)
    		return w;
    	if (wt[w] < ans)
    		ans = wt[w];
    	return dfs(cd[w]);
    }
    
    ArrayList<ArrayList<Integer>> solve(int n, int p, ArrayList<Integer> a ,
        ArrayList<Integer> b ,ArrayList<Integer> d) { 
         // code here
        this.n = n;
        this.p = p;
        rd = new int[n + 1];
        wt = new int[n + 1];
        cd = new int[n + 1];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        int i = 0;
       
    	while (i < p) {
    		int q = a.get(i), h = b.get(i), t = d.get(i);
    		cd[q] = h;
    		wt[q] = t;
    		rd[h] = q;
    		i++;
    	}
    	
    	for (int j = 1; j <= n; ++j)
    
    		/*If a pipe has no ending vertex
    		but has starting vertex i.e is
    		an outgoing pipe then we need
    		to start DFS with this vertex.*/
    		if (rd[j] == 0 && cd[j] != 0) {
    			ans = 1000000000;
    			int w = dfs(j);
    
    			// We put the details of component
    			// in final output res array
    			ArrayList<Integer> li = new ArrayList<>();
    			li.add(j);
    			li.add(w);
    			li.add(ans);
    			res.add(li);
    	}
    
        return res;
    }
} 