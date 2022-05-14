class Solution {
     public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;
        
        Map<Character, Integer> pMap = new HashMap<>();
        
        for (int i = 0; i < p.length(); i++) {
            char curr = p.charAt(i);
            pMap.put(curr, pMap.getOrDefault(curr, 0) + 1);
        }
        
        Map<Character, Integer> sMap = new HashMap<>();
        
        int windowStart = 0, wordSize = p.length();
        
        int pSize = pMap.size(), sSize = 0;
        
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char curr = s.charAt(windowEnd);
            sMap.put(curr, sMap.getOrDefault(curr, 0) + 1);
            
            if (pMap.containsKey(curr) && pMap.get(curr).intValue() == sMap.get(curr).intValue()) {
                sSize++;
            }
            
            if (wordSize == windowEnd - windowStart + 1) {
                if (sMap.size() == pMap.size() && pSize == sSize) {
                    res.add(windowStart);
                }
                
                char start = s.charAt(windowStart);
                if (pMap.containsKey(start) && pMap.get(start).intValue() == sMap.get(start).intValue()) {
                    sSize--;
                }
                sMap.put(start, sMap.get(start) - 1);
                if (sMap.get(start) == 0) sMap.remove(start);
                windowStart++;
                
            }
            
        }
        
        return res;
        
    }
}