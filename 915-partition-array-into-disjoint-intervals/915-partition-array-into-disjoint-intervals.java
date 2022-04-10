class Solution {
    public int partitionDisjoint(int[] arr) {
        int n = arr.length;
        int [] lmax = new int[n];
        int [] rmin = new int[n];
        
        lmax[0]=arr[0];
        
        for(int i =1;i<n;i++){
            if(arr[i]>lmax[i-1])
                lmax[i]=arr[i];
            else
                lmax[i]=lmax[i-1];
        }
        
        rmin[n-1] = arr[n-1];
        
        for(int i =n-2;i>=0;i--){
            if(arr[i]>rmin[i+1])
                rmin[i]=rmin[i+1];
                else
                  rmin[i]=arr[i];
        }
        
      int i=0;
        
        for( i =1;i<n-1;i++){
            if(lmax[i-1]<=rmin[i]){
                break;
            }
           }
        
        return i;
    }
}