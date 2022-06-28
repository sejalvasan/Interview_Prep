class Solution {
    public int minDeletions(String s) {
        HashSet<Integer> set = new HashSet<>();
        
        int[]freq = new int[26];
        
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;
        }
        
        int ans =0;
        
        for(int i=0;i<26;i++){
            
           while(freq[i]>0){
               if(set.contains(freq[i])){
                freq[i]--;
                ans++;
            }else{
                   break;
               }
        }
            if(freq[i]>0)
                set.add(freq[i]);
        }
        return ans;
    }
}