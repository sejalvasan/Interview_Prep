class Solution {
    public int largestRectangleArea(int[] heights) {
     
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = Integer.MIN_VALUE;
        
        for(int i =0;i<=heights.length;i++){
            int val = i==heights.length?0:heights[i];
            
            while(st.peek()!=-1 && heights[st.peek()]>=val){
                int rm = i;
                int h = heights[st.pop()];
                int lm = st.peek();
                max = Math.max(max, (rm-lm-1)*h); 
            }
            
            st.push(i);
        }
        
        return max;
    }
}