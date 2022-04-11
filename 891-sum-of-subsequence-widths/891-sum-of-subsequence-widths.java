class Solution {
    public int sumSubseqWidths(int[] nums) {
        
    long res = 0;
    long mod = 1000000007;
    Arrays.sort(nums);
    long[] powers = new long[nums.length];
    powers[0] = 1;
        
 //to keep account of powers of 2
    for (int i = 1; i < powers.length; i++) {
        powers[i] = (powers[i - 1] * 2) % mod;
    }
    for (int i = 0; i < nums.length; i++) {
        res = (res + nums[i] * (powers[i] - powers[nums.length - i - 1])) % mod;
    }
    return (int) res;
}
}