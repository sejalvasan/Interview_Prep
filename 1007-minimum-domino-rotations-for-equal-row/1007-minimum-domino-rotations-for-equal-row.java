class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int swapA_B_A = rotations(tops,bottoms,tops[0]) ;
        int swapB_A_A = rotations(bottoms,tops,tops[0]);
        
        int minSwapA_B_A = Math.min(swapA_B_A , swapB_A_A );
        
        int swapA_B_B = rotations(tops,bottoms,bottoms[0]) ;
        int swapB_A_B = rotations(bottoms,tops,bottoms[0]);
        
        int minSwapA_B_B = Math.min(swapA_B_B , swapB_A_B );

        int minSwap = Math.min(minSwapA_B_A , minSwapA_B_B );
        
        return minSwap == Integer.MAX_VALUE ? -1 : minSwap;
    }
    
    private int rotations(int[] tops, int[] bottoms,int a){
        
        int numSwaps = 0;
        
        for(int i = 0 ; i < tops.length ; i++){
            if(a != tops[i] && a != bottoms[i]){
                return Integer.MAX_VALUE;
            }else if(a != tops[i]){
                numSwaps++;
            }
        }
        
        return numSwaps;
    }
}