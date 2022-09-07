class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
       HashMap<Integer,Integer> hashmap = new HashMap<>();
        
        int[] ans = new int[k];
        
        for(int i:nums){
            hashmap.put(i,hashmap.getOrDefault(i,0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        
        for(Map.Entry<Integer,Integer> map:hashmap.entrySet()){
            pq.add(map);
        }
        
        for(int i=0;i<k;i++){
            Map.Entry<Integer,Integer> map = pq.remove();
            ans[i] = map.getKey();
        }
        
        return ans;
        
    }
}