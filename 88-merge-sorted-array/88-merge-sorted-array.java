//TC O(m+n) SC O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 =m-1;
        int p2=n-1;
        int e = nums1.length-1;
        
        while(e>=0){
          int firstEle = p1>=0? nums1[p1]:Integer.MIN_VALUE;
          int secEle = p2>=0? nums2[p2]: Integer.MIN_VALUE;
           
            if(firstEle>secEle){
                nums1[e]=firstEle;
                p1--;
            }else{
                nums1[e]=secEle;
                p2--;
            }
            e--;
        }
    }
}