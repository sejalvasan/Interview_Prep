class Solution {
    public int countDigitOne(int n) {
     int res = 0;
     int place = 1;
        
     while(place<=n){
         int q = n / (10*place);
         int r = n % (10*place);
         
         res += q*place;
         int extra = 0;
         
         if(r>=2*place){
         extra = place;    
         }else if(r>=place){
             extra = r - place+1;
         }else
             extra = 0;
         
         res +=extra;
         
         place = place*10;
     }
        
        return res;
    }
}