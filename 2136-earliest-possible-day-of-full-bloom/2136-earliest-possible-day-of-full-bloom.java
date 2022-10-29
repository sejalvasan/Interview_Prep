class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int[][]mat = new int[n][2];
        
        for(int i =0;i<n;i++){
            mat[i][0]=plantTime[i];
            mat[i][1]=growTime[i];
        }
        
        Arrays.sort(mat,(a,b)->b[1]-a[1]);
        
        int bloom = 0, seedPlantDay = 0;
        
        for(int i =0;i<n;i++){
             int pTime = mat[i][0];
            int gTime = mat[i][1];
            
            bloom = Math.max(bloom, pTime+gTime+seedPlantDay);
            seedPlantDay += pTime;
        }
        
        return bloom;
    }
}