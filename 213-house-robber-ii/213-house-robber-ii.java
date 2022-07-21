class Solution {
    public int rob(int[] arr) {
        if(arr.length==0)
            return 0;
        if(arr.length==1)
        return arr[0];
        
        int one =util(arr,0,arr.length-1);
        int two = util(arr,1,arr.length);
        return Math.max(one,two);
    }     
        public static int util(int[]arr,int s, int e){
        int inc = arr[s];
        int exc =0;
        int ans =0;
        
        for(int i =s+1;i<e;i++){
            ans = Math.max(inc,exc);
            inc = arr[i]+exc;
            exc = ans;
        }
        return Math.max(inc,exc);
	}	
}