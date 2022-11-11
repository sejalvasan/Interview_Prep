class Solution {
    public String largestNumber(int[] nums) {
        
        int n = nums.length;
        String arr[] = new String[n];
        
        //convert yo string array
        
        for(int i =0 ;i<n;i++){
            arr[i]=nums[i]+"";
        }
        
        Arrays.sort(arr,(a,b)->{
            long n1 = Long.parseLong(a+b);
            long n2 = Long.parseLong(b+a);
            if(n1>n2) return 1; //pos
            else if(n2>n1) return -1;//neg
            return 0;
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(int i =n-1;i>=0;i--){
            sb.append(arr[i]);
        }

        if(sb.charAt(0)=='0')
            return "0";
        
        return sb.toString();
    }
}