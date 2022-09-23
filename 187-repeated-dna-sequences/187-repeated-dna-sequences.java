class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        int i =0, j=0;
        
        while(j<s.length()){
            
            if(j-i+1<10){
                j++;
            }
            else if(j-i+1==10){
                String ss = s.substring(i,j+1);
                map.put(ss,map.getOrDefault(ss,0)+1);
                
                if(map.get(ss)>1 && !ans.contains(ss))
                    ans.add(ss);
                
                i++;
                j++;
            }
        }
        
        return ans;
    }
}