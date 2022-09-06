class Solution {
    public String removeKdigits(String nums, int k) {
     
        if(nums.length()==k){
            return "0";
        }
        //like we take example "1432219" and k=3
        //so first of fall we will be pushing eleemnt in stack and also checking that 
        //in mean while whatever element is in last in stack peeking it out and and checking it with cuurent element that whether it is greater than it then pop it out it will happen till k>0
        //so first 1 is pushed then 4 as it goes to i=2 then so it peek out 4 and it greater than 3 (4>3) so pop it out and add 3 in stack then it goes to i=3 element 2 and check while loop that(3>2) so pop it out add 2 and again add 2 and then it goes to 1 then check that 2>1 and pop it out now now add 9 
        //into it so now stack contian 9121 so it it in reverse order storing element in stringbuilder then reverse it and also delete leading 0 it ther in string then return with toString method
        Stack<Character> st=new Stack<>();
        int i=0;
        while(i<nums.length()){
            while(k>0 && !st.isEmpty() && st.peek()>nums.charAt(i)){
                st.pop();
                k--;
            }
            st.push(nums.charAt(i));
            i++;
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}