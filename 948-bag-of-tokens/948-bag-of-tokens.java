class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int i=0, j=tokens.length-1;
        int max =0;
        
        while(i<=j){
            if(power>=tokens[i]){
                power=power-tokens[i];
                score++;
                i++;
                max = Math.max(max,score);
            }else if(score>0){
                power +=tokens[j];
                j--;
                score--;
            }else{
                break;
            }
        }
        
        return max;
    }
}