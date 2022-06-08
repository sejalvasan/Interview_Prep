class Solution {
    public int removePalindromeSub(String s) {
     boolean flag = isPalin(s, 0,s.length()-1);
        if(flag)
            return 1;
        
        return 2;
    }
    
    public static boolean isPalin(String s, int st, int end){
        
        while(st<=end){
        if(s.charAt(st)==s.charAt(end))
        {
            st++;
            end--;
        }else
            return false;
    }
        return true;
}
}