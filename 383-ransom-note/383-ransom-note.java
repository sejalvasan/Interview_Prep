class Solution {
    public boolean canConstruct(String rans, String mag) {
        if(rans.length()==0)
            return true;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i =0;i<mag.length();i++){
            map.put(mag.charAt(i),map.getOrDefault(mag.charAt(i),0)+1);
        }
        
        for(int i =0;i<rans.length();i++){
            if(!map.containsKey(rans.charAt(i)))
                return false;
            
            map.put(rans.charAt(i),map.getOrDefault(rans.charAt(i),0)-1);
            if(map.get(rans.charAt(i))<0)
                return false;
        }
        return true;
    }
}