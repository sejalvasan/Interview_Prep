class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        if(firstList.length==0 || secondList.length==0)
            return new int[0][0];
       
        ArrayList<int[]> res = new ArrayList<>();
        
        int i =0, j=0;
        
        while(i<firstList.length && j<secondList.length){
            int maxofStart = Math.max(firstList[i][0],secondList[j][0]);
            int minofEnd = Math.min(firstList[i][1],secondList[j][1]);
            
            if(maxofStart<=minofEnd){
                res.add(new int[]{maxofStart ,minofEnd});
            }
            
            if(firstList[i][1]<secondList[j][1]){
                i++;
            }else{
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}