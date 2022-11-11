class Solution {
  public int removeDuplicates(int[] nums) {
    int answer = 1;
    for (int i = 1; i != nums.length; ++i) {
        if(nums[i] != nums[i - 1]) {
            nums[answer] = nums[i];
            answer += 1;
        }
    }
    return answer;
}
}