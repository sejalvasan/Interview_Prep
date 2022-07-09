class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int remove =0;
        
        Arrays.sort(edges,(a,b)->b[0]-a[0]);
        
        int[]parenta = new int[n+1];
        int[]parentb = new int[n+1];
        int[]ranka = new int[n+1];
        int[]rankb = new int[n+1];
        
        for(int i=1;i<n+1;i++){
            parenta[i]=i;
            parentb[i]=i;
            ranka[i]=1;
            rankb[i]=1;
        }
        
        int mergeda =1;
        int mergedb =1;
        
        for(int[]e:edges){
            if(e[0]==3){
                boolean flaga = union(e[1],e[2],parenta, ranka);
                boolean flagb = union(e[1],e[2],parentb, rankb);
                
                if(flaga==true)
                    mergeda++;
                
                if(flagb==true)
                    mergedb++;
                
                if(flaga==false && flagb==false)
                    remove++;
                
            }else if(e[0]==1){
                 boolean flaga = union(e[1],e[2],parenta, ranka);
                  if(flaga==true)
                    mergeda++;
                else
                    remove++;
            }else {
                    boolean flagb = union(e[1],e[2],parentb, rankb);
                    if(flagb==true)
                    mergedb++;
                   else
                    remove++;
            }
        }
        
        if(mergeda!=n || mergedb!=n)
            return -1;
        
        return remove;
        
    }
    
    public boolean union(int x, int y, int[]parent, int[]rank){
        int lx = find(x,parent);
        int ly = find(y,parent);
        
        if(lx!=ly){
            if(rank[lx]<rank[ly]){
                 parent[ly]=lx;
            }else if(rank[lx]>rank[ly]){
                parent[ly]=lx;
            }else {
                parent[ly]=lx;
                lx++;
            }
            return true;
        }
        return false;
    }
    
    public int find(int x,int[]parent){
        if(parent[x]==x)
            return x;
        
        int sl = find(parent[x],parent);
        parent[x] = sl;
        return sl;
    }
}