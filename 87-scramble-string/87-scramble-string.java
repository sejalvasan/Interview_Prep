class Solution {
    
    static HashMap<String,Boolean> map = new HashMap<>();
    
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length())
            return false;
     if(s1.length()<1 && s2.length()<1)
         return true;
        
        return solve( s1, s2);
    }
    
    public boolean solve(String s1, String s2){
        if(s1.compareTo(s2)==0)
            return true;
        
        // if(s1.length()<=1)
        //     return false;
     String keyValue=s1+" "+s2;
        
         if ( map.containsKey(keyValue) ) {
            return map.get(keyValue);
        }


        int n = s1.length();
        boolean flagScramble = false;
        
        for(int i =1;i<=n-1;i++){
            
         boolean cond1=(solve(s1.substring(0, i),s2.substring(n - i,n)) &&  
                        solve(s1.substring(i, n),s2.substring(0, n-i)));

     boolean cond2=(solve(s1.substring(0, i),s2.substring(0, i))  
                    && solve(s1.substring(i, n),s2.substring(i, n)));

               if(cond1 || cond2){
                flagScramble = true;
                break;
        }
    }
       map.put(keyValue, flagScramble);
        return flagScramble;
   }
}