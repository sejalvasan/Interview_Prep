class Solution {
    public String orderlyQueue(String s, int k) {
        StringBuilder temp = new StringBuilder(s);
        String res = temp.toString();
        
        if(k==1){
            for(int i=0;i<s.length()-1;i++){
                StringBuilder sb = new StringBuilder();
                temp = sb.append(temp.substring(1)).append(temp.charAt(0));
                 res  =  (isSmall(temp.toString(),res))? temp.toString():res;
            }
        }
        else{
            char[]arr = s.toCharArray();
            Arrays.sort(arr);
            return String.valueOf(arr);
        }
        
        return res;
    }
    
    public static boolean isSmall(String s1, String s2){
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)<s2.charAt(i))
                return true;
            else if(s1.charAt(i)>s2.charAt(i))
                return false;
        }
        return false;
    }
}