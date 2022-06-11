class Solution {
    public int minOperations(int[] nums, int x) {
        
        if(nums[0]>x&&nums[nums.length-1]>x)
        return -1;
        
    HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        
        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        
        if(sum<x)
            return -1;
        
        int newTarget = sum-x;
        sum=0;
        int subArrLen=0;
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

            if(map.containsKey(sum-newTarget)){
                subArrLen = Math.max(subArrLen, i-map.get(sum-newTarget));
              map.put(sum,i);
            }else{
                map.put(sum,i);
            }
                
        }
        
        return nums.length - subArrLen;
    }
}