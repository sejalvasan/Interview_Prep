class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int parent[]=new int[n+1];
        int rank[]= new int[n+1];
        
for(int i=0;i<=n;i++){
    parent[i]=i;
    rank[i]=1;
}        
        for(int[]e: edges){
            int u =e[0];
            int v =e[1];
            
        int lx = find(u, parent);
        int ly = find(v,parent);
            if(lx!=ly){
                if(rank[lx]<rank[ly])
                    parent[lx]=ly;
            else if(rank[lx]>rank[ly])
                parent[ly]=lx;
            else{
                parent[lx]=ly;
                rank[ly]++;
            }
        }else{
                return e;
            }
            }
        return new int[2];
    }
    
    public static int find(int x, int[]parent){
        if(x==parent[x])
            return x;
        
        int temp = find(parent[x],parent);
        parent[x]=temp;
        return temp;
    }
}