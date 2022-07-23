class Solution {
    public String reorganizeString(String s) {
     
        HashMap<Character, Integer>map = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>((n1,n2)->(map.get(n2)-map.get(n1)));
        
        for(int i =0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        
        pq.addAll(map.keySet());
        
        StringBuilder sb = new StringBuilder();
        
        char block = pq.poll();
        sb.append(block);
        map.put(block,map.get(block)-1);
        
        while(pq.size()>0){
            char temp = pq.poll();
            sb.append(temp);
            map.put(temp,map.get(temp)-1);
            
            if(map.get(block)>0){
                pq.add(block);
            }
            
            block = temp;
        }
        
        if(map.get(block)>0){
            return "";
        }
        
        return sb.toString();
    }
}