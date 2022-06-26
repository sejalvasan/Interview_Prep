class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //sliding window
        
        int sumOfKEle = 0;
        
        for(int i=0;i<k;i++){
            sumOfKEle += cardPoints[i];
        }
        
        int len = cardPoints.length;
        int maxSum = sumOfKEle;
        int i=0;
        while(i<k){
            sumOfKEle = sumOfKEle - cardPoints[k-i-1] +cardPoints[len-1-i];
            maxSum = Math.max(maxSum,sumOfKEle);
            i++;
        }
        
        return maxSum;
    }
}