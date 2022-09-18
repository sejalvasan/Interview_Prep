class Solution {
    public boolean isUgly(int n) {
     
        if(n==0)
            return false;
        
        //keep dividing by 2, 3 and 5
        
        int[]divs = {2, 3, 5};
        
        for(int div: divs){
            while(n%div==0)
                n=n/div;
        }
        
        return n==1;
    }
}