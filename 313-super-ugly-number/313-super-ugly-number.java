class Solution {
        
//  static class Pair implements Comparable<Pair>{
//     int prime;
//     int pointer;
//     int value;
//     public Pair(int prime,int pointer,int value){
//         this.prime= prime;
//         this.pointer= pointer;
//         this.value= value;
//  }

// public int compareTo(Pair o){
// return this.value-o.value;
//    }
// }
  public int nthSuperUglyNumber(int n, int[] primes) {

// int[]dp=new int[n+1];
// PriorityQueue<Pair>pq=new PriorityQueue<>();

// for(int i=0;i<primes.length;i++){
// pq.add(new Pair(primes[i],1,primes[i]));
// }
// dp[1]=1;

// for(int i=2;i<=n;){
// Pair rp=pq.remove();
// if(dp[i-1]!=rp.value){
//     dp[i]=rp.value;
//     i++;
// }
// pq.add(new Pair(rp.prime, rp.pointer++, rp.prime*dp[rp.pointer++]));
// }
// return dp[n];
// }
// }
        long[] ugly = new long[n+1];
        ugly[0] = 1;
        int[] index = new int[primes.length];
      
        for (int i = 1; i < n; i++) {
            long min = Integer.MAX_VALUE;
            
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, ugly[index[j]] * primes[j]);
            }
            
            ugly[i] = min;
            
            for (int j = 0; j < primes.length; j++) {
                if (ugly[index[j]] * primes[j] == min) {
                    index[j]++;
                }
            }
            
        }
        return (int)ugly[n - 1];       
    }
}