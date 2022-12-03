
class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character, Integer> map = new   HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>((x,y)->map.get(y)-map.get(x));
        
    for(char c:s.toCharArray()){
        map.put(c, map.getOrDefault(c,0)+1);
    }        
        
        for(char c:map.keySet()){
            pq.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()){
            char ch = pq.poll();
            
            for(int i =0;i<map.get(ch);i++){
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}