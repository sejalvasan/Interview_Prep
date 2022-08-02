
class Solution {
    int[]parent= new int[20005] ;
    int[]rank = new int[20005];
    
    public int find(int x){
        if(parent[x]==-1)
            return x;
        
        int temp = find(parent[x]);
        parent[x]=temp;
        return temp;
    }
    
    public void union(int x, int y){
        
        int lx = find(x);
        int ly = find(y);
        
        if(lx!=ly){
            if(rank[lx]<rank[ly]){
                parent[lx]=ly;
            }else if(rank[ly]>rank[lx]){
                parent[ly]=lx;
            }else{
                parent[lx]=ly;
                ly++;
            }
        }
    }
    
    public int removeStones(int[][] stones) {
        Arrays.fill(parent,-1);
        Arrays.fill(rank,1);
        
        for(int[]stone:stones){
            union(stone[0],stone[1]+10001);
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int[]stone:stones){
            set.add(find(stone[0]));
        }
        
        int comps =set.size();
        return stones.length-comps;
    }
}