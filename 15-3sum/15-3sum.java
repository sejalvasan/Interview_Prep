class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
     List<List<Integer>> list = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        
        Arrays.sort(nums);
        
        for(int i =0;i<nums.length-1;i++){
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
            if(nums[i]+nums[l]+nums[r]==0){
                List<Integer> arr = new ArrayList<>();
                arr.add(nums[i]);
                arr.add(nums[l]);
                arr.add(nums[r]);
              if(!set.contains(arr))
                list.add(arr);
                
                set.add(arr);

                l++;
                r--;
            }else if(nums[i]+nums[l]+nums[r]<0){
                l++;
            }else{
                r--;
            }
        }
        }
        return list;
    }
}