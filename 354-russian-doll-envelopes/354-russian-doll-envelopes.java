class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        int n = envelopes.length;
        Envelopes[] env = new Envelopes[n];
        int k = 0;
        for(int[] e : envelopes){
            int w = e[0];
            int h = e[1];
            
            env[k++] = new Envelopes(w,h);
        }
        
        Arrays.sort(env,(a,b) -> a.w==b.w?b.h-a.h:a.w-b.w);
                
        ArrayList<Envelopes> temp = new ArrayList<>();
        temp.add(env[0]);
        
        for(int i = 1 ; i < n ; i++){
            
            if(env[i].h > temp.get(temp.size()-1).h){
                temp.add(env[i]);
            }else{
                int idx = lower_bound(temp,env[i].h);
                temp.set(idx,env[i]);
            }
        }
        
        return temp.size();
        
    }
    
    public int lower_bound(ArrayList<Envelopes> array, int key)
    {

        int low = 0, high = array.size();
        int mid;
 
        while (low < high) {
 
            mid = low + (high - low) / 2;
 
            if (key <= array.get(mid).h) {
                high = mid;
            }else {
                low = mid + 1;
            }
        }

        if (low < array.size() && array.get(low).h < key) {
            low++;
        }
         return low;
    }
    
   public class Envelopes{
       int w;
       int h;
       
       Envelopes(int w, int h){
           this.w = w;
           this.h = h;
       }
   }
}