class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y =y;
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        
        Pair[]a = new Pair[n];
        
        for(int i =0;i<n;i++){
            int u = intervals[i][0];
            int v = intervals[i][1];
            
            a[i]=new Pair(u,v);
        }
        
        Arrays.sort(a,(p,q)->p.y-q.y);
        int count =0;
        int last =Integer.MIN_VALUE;
        
        for(int i =0;i<n;i++){
            if(a[i].x>=last){
                last = a[i].y;
                count++;
                }
        }
        return n - count;
    }
}