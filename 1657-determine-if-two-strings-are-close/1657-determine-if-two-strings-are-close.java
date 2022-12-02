class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()){
            return false;
        }
        
        int[] word1letters = new int[26];
        int[] word2letters = new int[26];
        
        
        for(int i = 0; i< word1.length(); i++) {
            word1letters[word1.charAt(i) - 'a']++;
            word2letters[word2.charAt(i) - 'a']++;
        }
        
        for(int i =0; i<26; i++){
            
            if(word1letters[i]==0 && word2letters[i] != 0){
                return false;
            }
        }
        
        Arrays.sort(word1letters);
        Arrays.sort(word2letters);
        
        for(int i =0; i<26; i++){
            if(word1letters[i]!=word2letters[i]){
                return false;
            }
            if(word1letters[i]==0 && word2letters[i] != 0){
                return false;
            }
        }
        
        return true;
    }
    
}