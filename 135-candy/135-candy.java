class Solution {
    public int candy(int[] ratings) {
        // => children with equal ratings might get different candies
        int n = ratings.length;
        int[]res = new int[n];
        Arrays.fill(res,1);
        
        //forward
        
        for(int i =0;i<n-1;i++){
            if(ratings[i+1]>ratings[i]){
                res[i+1]=res[i]+1;
            }
        }
        
        //backward
        
        for(int i=n-1;i>0;i--){
            if(ratings[i-1]>ratings[i]){
                if(res[i-1]<=res[i]){
                    res[i-1]=res[i]+1;
                }
            }
        }
        int sum =0;
        for(int i =0;i<n;i++){
            sum+=res[i];
        }
        return sum;
    }
}