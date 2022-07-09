class Solution {
    public int maxResult(int[] nums, int k) {
        
        //score, index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        
        if(nums.length==0)
            return 0;
        
        pq.add(new int[]{nums[0],0});
        
        int maxScore = nums[0];
        
        for(int i = 1 ;i<nums.length;i++){
            while(!(i-pq.peek()[1]<=k)){
                pq.poll();
            }
            int[]cur = pq.peek();
            maxScore = nums[i] + cur[0];
            pq.add(new int[]{maxScore,i});
        }
        
        return maxScore;
    }
}