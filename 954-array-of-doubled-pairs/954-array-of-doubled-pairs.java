class Solution {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : arr) {
            if(val != 0) {
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
        }
        
        Arrays.sort(arr);
        
        for(int val : arr) {
            if(map.containsKey(val) && map.containsKey(2 * val)) {
                if(map.get(val) > 1) {
                    map.put(val, map.get(val) - 1);
                } else {
                    map.remove(val);
                }
                
                if(map.get(2 * val) > 1) {
                    map.put(2 * val, map.get(2 * val) - 1);
                } else {
                    map.remove(2 * val);
                }
            }
        }
        
        if(map.size() == 0) {
            return true;
        }
        
        return false;
    }
}