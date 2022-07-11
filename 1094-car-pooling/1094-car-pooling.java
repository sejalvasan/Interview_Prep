class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
         int lastDrop=0;
        
        for(int[] trip : trips){
            lastDrop=Math.max(lastDrop,trip[2]);
        }
        
        int highway[]=new int[lastDrop+1];
        for(int trip[] : trips){
            
            highway[trip[1]] +=trip[0];
            highway[trip[2]] -=trip[0];
        
        }
        
        if(highway[0]>capacity) return false;
        
        for(int i=1;i<=lastDrop;i++){
            highway[i] +=highway[i-1];
            if(highway[i]>capacity){
                return false;
            }
        }
        
        return true;
        
        
    }
}