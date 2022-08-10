class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int ans =0;
        int n = matrix[0].length;
        int []stored = new int[n];
        for(int i =0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                
                    if(matrix[i][j]=='1')
                        stored[j]+=1;
                    else
                        stored[j]=0;
                }
                
                ans = Math.max(ans,largestRectangleArea(stored));
            }
        return ans;
        }
     public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> st = new Stack<>();
        st.add(-1);
        int area =0;
        
        for(int i =0;i<=heights.length;i++){
            int val = i==heights.length?0:heights[i];
            
            while(st.peek()!= -1 && heights[st.peek()]>=val){
                int rm = i;
                int idx = st.pop();
                int h = heights[idx];
                int lm = st.peek();
                
                area = Math.max(area, (rm-lm-1)*h);
            }
            st.push(i);
        }
        
        return area;
    }
}