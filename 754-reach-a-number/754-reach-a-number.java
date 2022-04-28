class Solution {
    public int reachNumber(int target) {
      target =Math.abs(target);
       int total =0;
        int steps=0;
        while(total<target){
            steps++;
            total+=steps;
        }
       
     while((total-target)%2!=0){
          steps++;
            total+=steps;
        }
    return steps;
    }
}
