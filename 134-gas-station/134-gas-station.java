class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
//        int n = gas.length;

//         int totgas = 0;
//         int totcost = 0;
//         for(int i =0;i<n;i++){
//             totgas+=gas[i];
//             totcost+=cost[i];
//         }       
        
//         if(totcost>totgas)
//             return -1;
        
//         int [] delta = new int[n];
//         for(int i=0;i<n;i++){
//             delta[i]=gas[i]-cost[i];
//         }
        
//         int[]deltasum = new int[n];
//         deltasum[0]=delta[0];
//         for(int i =1;i<n;i++){
//             deltasum[i]=deltasum[i-1]+delta[i];
//         }
        
//         int idx=0;
//         int min =Integer.MAX_VALUE;
//         for(int i=0;i<n;i++){
//             if(deltasum[i]<min){
//                 min=deltasum[i];
//                 idx=i;
//             }
//         }
        
//         if(idx!=n-1)
//         return idx+1;
        
//         return 0;
//     }
// }
        
          int n = gas.length;

        int totgas = 0;
        int totcost = 0;
        for(int i =0;i<n;i++){
            totgas+=gas[i];
            totcost+=cost[i];
        }       
        
        if(totcost>totgas)
            return -1;
        
        int remainingGas =0;
        int start =0;
        
        for(int i=0;i<n;i++){
            remainingGas += gas[i]-cost[i];
            if(remainingGas<0){
             start=i+1;
                remainingGas =0;
            }
        }
        
        return start;
    }
}