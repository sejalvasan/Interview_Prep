class Solution {
   public String reorganizeString(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (char c:s.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((n1,n2)->mp.get(n2)-mp.get(n1));
        
        pq.addAll(mp.keySet());
        
        StringBuilder sb = new StringBuilder();
        
        char block = pq.poll();
        sb.append(block);
        mp.put(block,mp.get(block)-1);
        
        while(pq.size()>0){
            char temp = pq.poll();
            sb.append(temp);
            mp.put(temp,mp.get(temp)-1);
            
            if(mp.get(block)>0)
                pq.add(block);
              
        block =temp;
        }
        
         if(mp.get(block)>0)
                return "";
        return sb.toString();
    }
}