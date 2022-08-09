class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        HashMap<Integer, Integer>[]maps = new HashMap[nums.length];
        for(int i =0;i<nums.length;i++){
            maps[i]=new HashMap<>();
        }
        
        int ans = 0;
        
        for(int i=1;i<nums.length;i++){
            for(int j =0;j<i;j++){
                long diff = (long)nums[i] - (long)nums[j];
                
                if(diff<=Integer.MIN_VALUE || diff>= Integer.MAX_VALUE)
                    continue;
                
                int endAtJ = maps[j].getOrDefault((int)diff,0);
                int endAtI = maps[i].getOrDefault((int)diff,0);
                
                ans+=endAtJ;
                
                maps[i].put((int)diff,endAtJ+endAtI+1);
            }
        }
        
        return ans;
    }
}