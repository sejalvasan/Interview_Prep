class Solution {
    public int largestPerimeter(int[] num) {
     
        Arrays.sort(num);
        
       for(int i = num.length-1;i>=2;i--){
        int peri = num[i]+num[i-1]+num[i-2];
           if(num[i-1]+num[i-2]>num[i]){
            return peri;   
           }
           peri = 0;
       }
        
            return 0;

    }
}