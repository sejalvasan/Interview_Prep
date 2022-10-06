class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        
        word(s, wordDict, res, "");
        
        return res;
    }
    
    
    public void word(String s, List<String> dict, List<String> res, String ans){
        
        if(s.length()==0){
            StringBuilder sb = new StringBuilder(ans);
            sb.deleteCharAt(ans.length()-1);
            res.add(sb.toString());
            return;
        }
        
        for(int i = 0; i<s.length();i++){
            String left = s.substring(0,i+1);
            if(dict.contains(left)){
                String right = s.substring(i+1);
                word(right, dict, res, ans+left+" ");
            }
        }
    }
}