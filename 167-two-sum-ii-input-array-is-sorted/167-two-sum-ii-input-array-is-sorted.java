class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        //Brute 
    //TC =0(n)^2 -> USE 2 FOR LOOPS
        
        //brute 2
        //o(n)-tc  o(n)-sc use hashmap
        
        //above mentioned brutes can be used for unsorted array aswell
        
        
        //tc - o(n)
        //sc-o(1)
        int i=0;
        int j =numbers.length-1;
        int[]ans = new int[2];
        while(i<j){
            if(numbers[i]+numbers[j]<target){
                i++;
            }else if(numbers[i]+numbers[j]>target){
                j--;
            }else if(numbers[i]+numbers[j] ==target){
                ans[0]=i+1;
                ans[1]=j+1;
                return ans;
            }
        }
        return null;
    }
}