class Solution {
    
    public String reverseWords(String s) {
        
        String[]arr = s.split(" ");
        String ans ="";
        for(int i =0;i<arr.length;i++){
            ans +=reverse(arr[i])+" ";
        }
        
        return ans.substring(0, ans.length()-1);
    }
    
    public String reverse(String s){
        String rev = "";
    
         for(int i = s.length() - 1; i >= 0; i--)
         {
         rev = rev + s.charAt(i);
         }
        return rev;
    }
}