class Solution {
    public List<Integer> partitionLabels(String s) {
        
       int[]map = new int[26];
        Arrays.fill(map,-1);
        
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            map[ch-'a']=i;
        }
        
        
        int st =0;
        int e =0;
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            
           e = Math.max(e,map[ch-'a']);
            
            if(i==e){
             ans.add(e-st+1);   
                e = st= i+1;
            }
        }
        
        return ans;
    }
}