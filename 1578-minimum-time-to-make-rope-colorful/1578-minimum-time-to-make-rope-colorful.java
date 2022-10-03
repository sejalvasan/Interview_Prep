class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        char c = '$';
        int costp=0;
        int ans =0;
        
        for(int i =0;i<colors.length();i++){
            char s = colors.charAt(i);
            
            if(s==c){
                if(neededTime[i]<costp){
                    ans+=neededTime[i];
                }else{
                    ans+=costp;
                    costp=neededTime[i];
                }
            }else{
                c = s;
                costp=neededTime[i];
            }
        }
        
        return ans;
    }
}