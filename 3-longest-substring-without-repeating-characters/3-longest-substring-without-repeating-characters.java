class Solution {
    public int lengthOfLongestSubstring(String S) {
        //sliding window
        
     
       HashMap<Character, Integer> mp = new HashMap<>();
        int i=0,j=0, max =0;
        
        while(j<S.length()){
            char endChar = S.charAt(j);
            if(!mp.containsKey(endChar))
            mp.put(endChar, 1);
            else
            mp.put(endChar, mp.get(endChar)+1);
            
            
            if(mp.size()==j-i+1){
            max=Math.max(max, j-i+1);
            j++;
            }
            
           else if(mp.size()<j-i+1)
            {
                while(mp.size()<j-i+1){
                    char startChar=S.charAt(i);
                    
                    if(mp.containsKey(startChar))
                    mp.put(startChar, mp.get(startChar)-1);
                    
                    if(mp.get(startChar)==0)
                    mp.remove(startChar);
                    
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}