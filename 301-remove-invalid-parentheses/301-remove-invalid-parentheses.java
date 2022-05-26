class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans=new ArrayList<>();
       // HashSet<String> set=new HashSet<String>();
        HashSet<String> visited=new HashSet<String>();
        
        int minBracket=removeBracket(s);
        getAns(s, minBracket,ans,visited);
        
        return ans;
    }
    
    public void getAns(String s, int minBracket, List<String> ans,HashSet<String> visited){
        
           //TLE can be resolved if we pass another HashSet object in the recursive function to track if the string has been visited before. If the string is visited,simply return. otherwise, put the string in HashSet and then perform rest of the operation. :Just add following condition at the very first line of recursive function.
          if(visited.contains(s))
            return;
        visited.add(s);
        
        if(minBracket==0){
              int removenow=removeBracket(s);   
                if(removenow==0){
                  //  if(!set.contains(s)){
                       //set.add(s);
                       ans.add(s);
                   // }
                }
            return;
        }
        
        for(int i=0;i<s.length();i++){
            String L=s.substring(0,i); //removing ith bracket
            String R=s.substring(i+1);
        getAns(L+R,minBracket-1,ans,visited);
        }
    }
    
    public int removeBracket(String s){
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            
            if(x=='(') stack.push(x);
            else if(x==')'){
                if(stack.size()==0)
                    stack.push(x);
                else if(stack.peek()=='(')
                    stack.pop();
                else if(stack.peek()==')')
                    stack.push(x);
            } 
        }
        return stack.size();
    }
}