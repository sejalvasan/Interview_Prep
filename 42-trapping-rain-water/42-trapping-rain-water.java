class Solution {
    public int trap(int[] height) {
        int i=0;
        int j =height.length-1;
        int leftMax=0, rightMax=0;
        int res=0;
        
        while(i<=j){
        if(height[i]<=height[j]){
            if(leftMax<height[i])
                leftMax=height[i];
            else
                res+=leftMax-height[i];
            
            i++;
        }else{
              if(rightMax<height[j])
                rightMax=height[j];
               else
                 res+=rightMax-height[j];
            
            j--;
        }
            
        }
        return res;
    }
}

       