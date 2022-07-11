class Solution {
    //TC = O(logn)
    public int[] findRightInterval(int[][] intervals) {
     
        int n = intervals.length;
          int[]arr = new int[n];
        
        if(n==0){
            return new int[0];
        }
        
        if(n==1){
            return new int[]{-1};
        }
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i =0;i<n;i++)
            map.put(intervals[i][0],i);
    
    
    for(int i =0;i<n;i++){
        Integer minFirstKey = map.ceilingKey(intervals[i][1]);
        
        if(minFirstKey==null)
            arr[i]=-1;
        else
            arr[i]=map.get(minFirstKey);
    }
    return arr;
}
}