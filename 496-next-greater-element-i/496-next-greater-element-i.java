class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int[]ans = new int[n2];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = nums2.length-1;i>=0;i--){
            
            if(st.size()==0)
                ans[i]=-1;
            
            else if(st.peek()>nums2[i])
                ans[i]=st.peek();
            
            else{
                while(st.size()>0 && st.peek()<nums2[i]){
                    st.pop();
                }
                
                if(st.size()==0)
                    ans[i]=-1;
                else
                    ans[i]=st.peek();
            }
            st.push(nums2[i]);
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i =0;i<n2;i++){
            map.put(nums2[i],ans[i]);
        }
        
        int[]answer = new int[n1];
        
        for(int i =0;i<n1;i++){
            answer[i] = map.get(nums1[i]);
        }
        
        return answer;
    }
}