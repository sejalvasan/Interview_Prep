class Solution {
    public int uniqueMorseRepresentations(String[] words) {
   
        
String []arr ={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
            
            
        HashSet<String> set = new HashSet<>();
        
        for(String s: words){
          char[]str = s.toCharArray();
            String ans = "";
          for(int i =0;i<str.length;i++){
              ans+=arr[str[i]-'a'];
          }
            set.add(ans);
        }
        
        return set.size();
    }
}