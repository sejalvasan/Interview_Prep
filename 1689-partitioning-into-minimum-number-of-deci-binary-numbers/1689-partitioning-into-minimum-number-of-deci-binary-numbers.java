class Solution {
    public int minPartitions(String n) {
        //maximum digit in n is the answser
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<n.length();i++){
            int dig = (n.charAt(i)-'0');
            max = Math.max(max, dig);
        }
        return max;
    }
}