class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][]dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        
        int n = heights.length;
        int m = heights[0].length;
        
        //min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        
        pq.add(new int[]{0,0,0});
        int[][]effort = new int[n][m];
        
        for(int[]eff:effort)
            Arrays.fill(eff,Integer.MAX_VALUE);
        effort[0][0]=0;
        
        while(!pq.isEmpty()){
            int[]rem = pq.remove();
            int r = rem[0];
            int c = rem[1];
            int eff = rem[2];
            
            if(r==n-1 && c == m-1)
                return effort[r][c];
            
            for(int i=0;i<4;i++){
                int x = r +dirs[i][0];
                int y = c +dirs[i][1];
                
                if(x<0 || y<0 || x>=n || y>=m)
                    continue;
                
                int newEffort = Math.max(eff,Math.abs(heights[x][y]-heights[r][c]));
                
                if(newEffort<effort[x][y]){
                    effort[x][y]=newEffort;
                    pq.add(new int[]{x,y,newEffort});
                }
            }
        }
        return 0;
    }
}