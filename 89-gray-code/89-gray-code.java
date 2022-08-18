class Solution {
    public List<Integer> grayCode(int n) {
        List<String> res=grayCode_(n);
        List<Integer> ans=new ArrayList<>();
        for(String s:res){
        ans.add(Integer.parseInt(s,2));
        }
        return ans;
    }
    static List<String> grayCode_(int n){
        if(n==1){
        List<String> myAns=new ArrayList<>();
        myAns.add("0");
        myAns.add("1");
        return myAns;    
        }
        List<String> prev=grayCode_(n-1);
        List<String> myAns=new ArrayList<>();
        for(int i=0;i<prev.size();i++){
            myAns.add("0"+prev.get(i));
        }
        for(int i=prev.size()-1 ; i>=0;i--){
            myAns.add("1"+prev.get(i));
        }
        return myAns;
    }
}