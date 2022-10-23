class Solution {
    public String minWindow(String s, String t) {
       int i = 0;
        int j = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int k=0;k<t.length();k++){
            map.put(t.charAt(k),map.getOrDefault(t.charAt(k),0)+1);
        }
        int count = map.size();
        int min = Integer.MAX_VALUE;
        String ans = "";
        
        while(j<s.length()){
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j),map.get(s.charAt(j))-1);
                if(map.get(s.charAt(j)) == 0){
                    
                    count--;
                }
            }
            if(count == 0)
            {
                if(min > j-i+1){
                    min = j-i+1;
                    ans = s.substring(i,j+1);
                }
                while(count == 0){
                    if(map.containsKey(s.charAt(i))){
                        map.put(s.charAt(i),map.get(s.charAt(i))+1);
                        if(map.get(s.charAt(i)) > 0){
                            count++;
                            i++;
                            break;
                        }
                    }
                   
                        i++;
                    
                     if(min > j-i+1){
                       min = j-i+1;
                       ans = s.substring(i,j+1);
                    }
                }
            }
            j++;
        }
        if(ans.length()==0)
        return "";
        
        return ans;
    }
}
      