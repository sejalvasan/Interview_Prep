class Solution {
    public boolean halvesAreAlike(String s) {
        int num = 0;
        HashSet<Character> set = new HashSet<>();
        
        set.add('A');
         set.add('E');
         set.add('I');
         set.add('O');
         set.add('U');
         set.add('a');
         set.add('e');
         set.add('i'); 
        set.add('o'); 
        set.add('u');
        
        for(int i =0;i<=s.length()/2-1;i++){
           char c = s.charAt(i);
            if(set.contains(c))
                num++;
        }
        
        for(int i =s.length()/2;i<s.length();i++){
             char c = s.charAt(i);
            if(set.contains(c))
                num--;
        }
        
        return num==0?true:false;
    }
}