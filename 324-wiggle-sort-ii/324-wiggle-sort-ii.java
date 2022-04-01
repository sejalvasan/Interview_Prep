class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int i=1;
        int n=nums.length;
        int j=n-1;
        int []arr = new int[n];
        // a b c d e f 
        // c f b e a d
        while(i<n){
        arr[i]=nums[j];
            i+=2;
            j--;
        }
        
        i=0;
        
        while(i<n){
        arr[i]=nums[j];
            i+=2;
            j--;
        }
        
        for(i =0;i<n;i++){
            nums[i]=arr[i];
        }
    }
}