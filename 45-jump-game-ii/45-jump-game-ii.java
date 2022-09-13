class Solution {
    public int jump(int[] arr) {
  if (arr.length <= 1) 
            return 0; 
  
        // Return -1 if not possible to jump 
        if (arr[0] == 0) 
            return -1; 
            
        int maxReach = arr[0];
        int steps = arr[0];
        int jump = 1;
        
        for(int i =1;i<arr.length;i++){
            if(i==arr.length-1)
            return jump;
            
            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;
            
            if(steps==0){
                jump++;
                
                if(i>=maxReach)
                return -1;
                
                steps=maxReach -i;
                
            }
        }
        return jump;
    }
}