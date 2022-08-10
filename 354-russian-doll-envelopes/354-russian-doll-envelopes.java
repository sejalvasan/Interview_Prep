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
                
        //ArrayList<Integer> temp = new ArrayList<>();
        int[]temp=new int[n];
        temp[0]=env[0].h;
      //  temp.add(env[0].h);
        int lastIndex =0;
        for(int i = 1 ; i < n ; i++){
            
            int index = binary(temp,0,lastIndex,env[i].h);
           // temp.set(index, env[i].h);
            temp[index]=env[i].h;
            lastIndex = Math.max(lastIndex, index);
            
        }
        
        return lastIndex+1;
        
    }
    
    public int binary(int[] array,int l, int h, int key)
    {

   if(key>array[h]) return h+1;
        while(l<h){
            int mid = l+(h-l)/2;
            
            if(key==array[mid])
                return mid;
            
            else if(array[mid]<key)
                l= mid+1;
            
            else
               h = mid;
        }
        return h;
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