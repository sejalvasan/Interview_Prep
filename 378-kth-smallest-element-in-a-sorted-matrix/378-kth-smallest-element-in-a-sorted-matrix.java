class Solution {
    public int kthSmallest(int[][] matrix, int k) {
 int n = matrix.length;
        int startVal = matrix[0][0];
        int endVal = matrix[n-1][n-1];
        
        while(startVal<=endVal){
           int midVal = startVal + (endVal - startVal)/2;
           
            int ans =0;

            for(int i=0;i<n;i++){                
                int lo=0,hi=n-1;
                
                while(lo<=hi){
                    
                int mid = lo+(hi-lo)/2;
                if(matrix[i][mid]<=midVal) lo = mid+1;
                else hi = mid -1;
                    
                }
                
                ans+=lo;
            }
            
            if(ans<k) startVal = midVal+1;
            else
                endVal = midVal-1;
        }
        
        return startVal;
    }
}