class Solution {
public int[] findOriginalArray(int[] changed) {

    //Count Sort Approach
    
    int n = changed.length;
    
    if(n%2 != 0){
        return new int[0];
    }
    
    int[]ans = new int[n/2];
    int[]countArr = new int[100001];
    int idx = 0;
    
    for(int a : changed){
        countArr[a]++;
    }
    
    for(int i = 0; i<countArr.length; i++){
        
        while(countArr[i] > 0 && i*2 < countArr.length && countArr[i*2] > 0){
            countArr[i]--;
            countArr[i*2]--;
            ans[idx] = i;
            idx++;
        }
    }
     

    for(int i = 0 ; i<countArr.length; i++){
        if(countArr[i] != 0){
            return new int[0];
        }
    }
    return ans;
}
}