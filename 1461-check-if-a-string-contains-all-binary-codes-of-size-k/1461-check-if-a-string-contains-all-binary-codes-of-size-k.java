// class Solution {
//     public boolean hasAllCodes(String s, int k) {
//      if(s.length()<k)
//          return false;
        
//         HashSet<String> set = new HashSet<>();
         
//          for(int i=0;i<s.length()-k;i++){
//              set.add(s.substring(i,i+k));
//          }
         
//         if(set.size()==Math.pow(2,k))
//             return true;
        
//         return false;
//     }
// }

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int combinations = (int)Math.pow(2,k); 
        int len = s.length();
        Set<String> set = new HashSet<>();
        for(int i=0; i<=len-k;i++){ 
                set.add(s.substring(i,i+k));
        }
        if(set.size() == combinations){
            return true; // if both the numbers match return true
        }
        return false;
    }
}