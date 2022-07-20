class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count =0;
        HashSet<Character> set = new HashSet<>();
        
        for(int i =0;i<allowed.length();i++)
            set.add(allowed.charAt(i));
        
        for(String str : words){
                    boolean flag = true;
                    for(int i=0;i<str.length();i++){
                            char ch = str.charAt(i);
                            if(set.contains(ch) == false){
                                flag = false;
                                    break;
                            }
                    }
            if(flag == true)
                count++;
        }
            
        return count;      
    }
}