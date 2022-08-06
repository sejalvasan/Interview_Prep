class Solution {
    public int reversePairs(int[] nums) {
     return mergeSort(nums,0,nums.length-1);   
    }
    
    public int mergeSort(int[]nums, int lo, int hi){
        if(lo>=hi) return 0;
        int mid = lo+(hi-lo)/2;
        int inv = mergeSort(nums,lo,mid);
        inv+=mergeSort(nums,mid+1,hi);
        inv+=merge(nums,lo,mid,hi);
        return inv;
    }
    
    public int merge(int[]nums, int lo, int mid, int hi){
        int cnt =0;
        int j = mid+1;
        
        for(int i =lo;i<=mid;i++){
            while(j<=hi && nums[i]>(2*(long)nums[j]))
                j++;
            
            cnt+=(j-(mid+1));
        }
        
        ArrayList<Integer> temp = new ArrayList<>();
        int left=lo, right = mid+1;
        
        while(left<=mid && right<=hi){
            if(nums[left]<=nums[right])
                temp.add(nums[left++]);
            else
                temp.add(nums[right++]);
        }
    
    while(left<=mid){
        temp.add(nums[left++]);
    }
    
    while(right<=hi){
        temp.add(nums[right++]);
    }
    
    for(int i =lo;i<=hi;i++){
        nums[i]=temp.get(i-lo);
    }
    
    return cnt;
}
}