class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[]parent=new int[n+1];
        int[]rank = new int[n+1];
        int[]indegree = new int[n+1];
        Arrays.fill(indegree,-1);
        int black1 =-1;
        int black2=-1;
        
        for(int i=0;i<n;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            if(indegree[v]==-1){
                indegree[v]=i;
            }else{
                black1 = i;
                black2=indegree[v];
                break;
            }
        }
        
        //cycle detection - dsu
        
        for(int i=1;i<=n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        
        for(int i=0;i<n;i++){
            //if case 1 or 3 we ignore black list 1
            if(i==black1)
                continue;
            int u = edges[i][0];
            int v = edges[i][1];
            
            boolean flag = union(u, v, parent, rank);
            
            if(flag==true){
                //cycle detected
                if(black1 ==-1)
                    //case 2
                    return edges[i];
                else{
                    return edges[black2];
                }
            }
        }
        //no cycle detected
        return edges[black1];
    }
    
    public static boolean union(int x, int y, int[]parent, int[]rank){
          int lx= find(x,parent);
          int ly = find(y,parent);
            if(lx!=ly){
            if(rank[lx]<rank[ly])
                    parent[lx]=ly;
                else if(rank[lx]>rank[ly])
                    parent[ly]=lx;
                    else
                    {
                      parent[ly]=lx;
                        rank[lx]++;
                    }
                //no cycle, merged here
                return false;
           }
        //leader same so cycle
        return true;
    }
    
    public static int find(int x, int[]parent){
        if(x==parent[x])
            return x;
        //path compression
        int temp = find(parent[x],parent);
        parent[x]=temp;
        return temp;
    }
}