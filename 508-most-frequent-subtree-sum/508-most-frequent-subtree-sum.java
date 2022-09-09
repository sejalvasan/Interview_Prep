/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer,Integer> map=new HashMap<>();
    public int nodeSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftVal=nodeSum(root.left);
        int rightVal=nodeSum(root.right);
        int sum=root.val+leftVal+rightVal;
        map.put(sum,map.getOrDefault(sum,0)+1);
        return sum;
        
        
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        int x=nodeSum(root);
        System.out.println(map);
        int maxFrequency=Integer.MIN_VALUE;
        for(Map.Entry m: map.entrySet()){
            if(maxFrequency<(int)m.getValue()){
                maxFrequency=(int)m.getValue();
            }
        }
        List<Integer> resList=new ArrayList<>();
        for(Map.Entry m: map.entrySet()){
            if(maxFrequency==(int)m.getValue()){
                resList.add((int)m.getKey());
            }
        }
        
        int sizeOfList=resList.size();
        int [] res=new int[sizeOfList];
        for(int i=0;i<sizeOfList;i++){
            res[i]=resList.get(i);
        }
        return res;
    }
}