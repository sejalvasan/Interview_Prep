class Solution {
    public List<String> generateParenthesis(int n) {
         List<String> res = new ArrayList<>();
        f("",n,n,res);
        return res;
    }
    
    void f(String s, int o, int c,List<String> res)
    {
        if(o==0 && c==0)
        {
            res.add(s);
            return;
        }
        
        if(o==c)
        {
            f(s+"(",o-1,c,res);
        }
        else
        {
            if(o>0)
            {
            f(s+"(",o-1,c,res);
            }
            if(c>0)
            {
            f(s+")",o,c-1,res);
            }
        }   
    }
}