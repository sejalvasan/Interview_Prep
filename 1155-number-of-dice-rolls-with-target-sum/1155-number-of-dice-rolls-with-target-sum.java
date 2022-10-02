//  public int mod=(int) 1e9+7;
//     public int numRollsToTarget(int n, int k, int target) {

//         int[][] dp = new int[n+1][target+1];

//         for(int i=0;i<=n;i++){
//             dp[i][0] = 0;
//         }

//         for(int i=0;i<=target;i++){
//             dp[0][i] = 0;
//         }

//         dp[0][0] = 1;

//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=target;j++){
//                 int countWays = 0;

//                 for(int z=1;z<=k;z++){
//                     if(z>j){
//                         break;
//                     }   
//                     countWays += dp[i-1][j-z];
//                     countWays %= mod;
//                 }
                
//                 dp[i][j] = countWays;
//             }
//         }

//         return dp[n][target];
//     }
// }

//Recursive memoizaation solution 
class Solution {
    public int mod=(int) 1e9+7;
    public int numRollsToTarget(int n, int k, int target) {

        Integer[][] dp = new Integer[n+1][target+1];

        return numRollsToTargetHelper(n, k, target, dp);
    }

    public int numRollsToTargetHelper(int n, int k, int target, Integer[][] dp) {
        if(n==0 && target==0){
            return 1;
        } 
        
        if(n==0 || target<=0) {
            return 0;
        }
        
        if(dp[n][target]!=null) return dp[n][target];

        int countWays = 0;

        for(int i=1;i<=k;i++){
            if(i>target){
                break;
            }   
            countWays += numRollsToTargetHelper(n-1, k, target-i, dp);
            countWays %= mod;
        }

        return dp[n][target] = countWays;
    }
}