class Solution {
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