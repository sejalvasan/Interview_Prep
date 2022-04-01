class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l =0;
        int r = n-1;
        int maxr=height[n-1];
        int maxl=height[0];
       
        int res =Integer.MIN_VALUE;
      
        while(l<=r){
            res = Math.max(res,(r-l)*Math.min(height[l],height[r])); 
            if(height[l]>height[r]){
                r--;
            }
            else{
                 l++;
            }
             
         //  res = Math.max(res, (r-l)*Math.min(maxl,maxr)); 
        }  

        return res;
    }
}