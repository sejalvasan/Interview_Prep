class Solution 
{
    public int[] findOriginalArray(int[] nums) 
    {
        int n = nums.length;
        List<Integer> l = new ArrayList<>();
        int a[] = new int[n/2];
        if(nums.length%2==1)
            return new int[0];
        
        HashMap<Integer,Integer> map = new HashMap<>();
       Arrays.sort(nums);
        
        for(int i=0;i<n;i++)
        {
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
        }
        
        int zero=0;
        if(map.containsKey(0))  // Handling the case of zero separately...
        {
            zero = map.get(0);
            if(zero%2==0)
            {
                for(int i=0;i<zero/2;i++)
                    l.add(0);
            }
            else 
                return new int[0];
        }
        for(int i=0;i<n;i++)
        {
            int b = nums[i]*2;
            if(nums[i]!=0 && map.containsKey(nums[i]) && map.containsKey(b))
            {
                l.add(nums[i]);
                map.put(nums[i] , map.get(nums[i])-1);
                map.put(b , map.get(b)-1);
                if(map.get(nums[i])==0)
                    map.remove(nums[i]);
                if(map.get(b)==0)
                    map.remove(b);
            }
        }

        if(l.size() != n/2)
            return new int[0];
        else
        {
            for(int i=0;i<l.size();i++)
                a[i] = l.get(i);
            return a;
        }
    }
}