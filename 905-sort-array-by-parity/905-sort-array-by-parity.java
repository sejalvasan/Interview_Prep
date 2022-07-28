class Solution {
    public int[] sortArrayByParity(int[] arr) {
        
        int i =0;
        int j = arr.length-1;
        
        while(i<j){
            if(arr[i]%2==0 && arr[j]%2==1){
                //even odd
                i++;
                j--;
            }else if(arr[i]%2==0 && arr[j]%2==0){
                //both even 
                i++;
            }else if(arr[i]%2!=0 && arr[j]%2==0){
                //swap as odd even
                swap(arr,i,j);
                i++;
                j--;
            }else{
                //both odd
                j--;
            }
        }
        
        return arr;
        
    }
    
    public void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}