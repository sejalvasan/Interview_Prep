class Pair{
    int src;
    int wt;
    Pair(int src, int wt){
        this.src = src;
        this.wt = wt;
    }

}
 
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<Pair> q = new LinkedList<>();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        
        for(int[]row: flights){
            int u = row[0];
            int v = row[1];
            int w = row[2];
            adj.get(u).add(new Pair(v,w));
        }
        q.add(new Pair(src,0));
        int min = Integer.MAX_VALUE;
        int level=0;

        int[]dis = new int[n];
        
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        
        while(!q.isEmpty() && level<=k){
          int size = q.size();
            while(size-->0){
                Pair rem = q.remove();
                for(Pair nbr: adj.get(rem.src)){
                    if(rem.wt+nbr.wt<dis[nbr.src]){
                        dis[nbr.src]= rem.wt + nbr.wt;
                        q.add(new Pair(nbr.src, dis[nbr.src]));
                    }
                }
            }
            level++;
        }
        return dis[dst]==Integer.MAX_VALUE?-1:dis[dst];
    }
}