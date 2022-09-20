// class NumArray {

//      class SegmentTreeNode {
//         private int start, end;
//         private  SegmentTreeNode left, right;
//         private  int sum;

//         public SegmentTreeNode(int start, int end) {
//             this.start = start;
//             this.end = end;
//             this.left = null;
//             this.right = null;
//             this.sum = 0;
//         }
//     }

//     SegmentTreeNode root = null;

//     public NumArray(int[] nums) {
//         root = buildTree(nums, 0, nums.length-1);
//    }
//     // TC : O(n)
//     private SegmentTreeNode buildTree(int[] nums, int start, int end) {
//         if (start > end) {
//             return null;
//         } else {
//             SegmentTreeNode ret = new SegmentTreeNode(start, end);
//             if (start == end) {
//                 ret.sum = nums[start]; // leaf nodes
//             } else {
//                 int mid = start  + (end - start) / 2;
//                 ret.left = buildTree(nums, start, mid);
//                 ret.right = buildTree(nums, mid + 1, end);
//                 ret.sum = ret.left.sum + ret.right.sum;
//             }
//             return ret;
//         }
//     }

//     // TC : O(logn)
//     void update(int i, int val) {
//         updateHelper(root, i, val);
//     }

//     void updateHelper(SegmentTreeNode root, int pos, int val) {
//         // found leaf node to be updated
//         if (root.start == root.end) {
//             root.sum = val;
//         } else {
//             // parent nodes across the path
//             int mid = root.start + (root.end - root.start) / 2;
//             if (pos <= mid) {

//                 updateHelper(root.left, pos, val);
//             } else {
//                 updateHelper(root.right, pos, val);
//             }
//             root.sum = root.left.sum + root.right.sum;
//         }
//     }

//     public int sumRange(int i, int j) {
//         return sumRangeHelper(root, i, j);
//     }

//     // TC : O(logn)
//     public int sumRangeHelper(SegmentTreeNode root, int start, int end) {
//         // if you found out the node that matches your search return its value
//         if (root.start == start && root.end == end ) {
//             return root.sum;
//         } else {

//             int mid = root.start + (root.end - root.start) / 2; // overflow conditions
//             if (end <= mid) {
//                 // move left
//                 return sumRangeHelper(root.left, start, end);
//             } else if (start >= mid+1) {
//                 // move right
//                 return sumRangeHelper(root.right, start, end);
//             }  else {
//                 // consider both nodes
//                 return  sumRangeHelper(root.left, start, mid) + sumRangeHelper(root.right, mid+1, end) ;
//             }
//         }
//     }
// }


class NumArray {

    class Fenwick{
        int[] farr;
        
        Fenwick(int[]nums){
            this.farr = new int[nums.length+1];
        }
        
        int sum(int pos){
            int res = 0;
            
            while(pos>0){
                res += farr[pos];
                pos = pos - rsb(pos);
            }
            return res;
        }
        
        void update(int pos, int delta){
            while(pos<farr.length){
                farr[pos] += delta;
                    pos = pos + rsb(pos);
            }
        }
        
        private int rsb(int x)
        { 
          return x&-x;  
        }
    }
    
    
    Fenwick ft;
    int[]oarr ;
    
         public NumArray(int[] nums) {
             ft = new Fenwick(nums);
             oarr = nums;
             
             for(int i =0;i<nums.length;i++){
                 int pos = i+1;
                 int val = nums[i];
                 ft.update(pos,val);
             }
         }
    
    
       public void update(int index, int val) {
            int delta = val - oarr[index];
           int pos = index+1;
           ft.update(pos,delta);
           oarr[index]=val;
        }
    
    
    public int sumRange(int left, int right){
        int lpos = left + 1;
        int rpos = right + 1;
        
        int sumBeforeLeft = ft.sum(lpos-1);
        int sumTillRight = ft.sum(rpos);
        
        return sumTillRight - sumBeforeLeft;
    }
    
}