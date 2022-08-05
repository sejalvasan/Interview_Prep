class Solution {
    public int countArrangement(int n) {
        int[]arr = new int[n];
        
        //making array
        for(int i =0;i<n;i++){
            arr[i]=i+1;
        }
        
        solve(arr,0);
        return count;
    }
    
     int count=0;
    
    public void solve(int[]arr, int idx){
        
        if(idx==arr.length)
            count++;
        
        for(int i=idx;i<arr.length;i++){
            swap(arr,i,idx);
            
            if((arr[idx]%(idx+1)==0) || (idx+1)%arr[idx]==0)
                solve(arr,idx+1);
            
            swap(arr,i,idx);
        }
    }
    
    public void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}