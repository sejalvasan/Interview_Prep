class Solution {
    List<Integer> rest=new ArrayList<>();
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> cache=new HashMap<>();
        for(int i=0;i<words.length;i++)
        {
            if(!cache.containsKey(words[i]))
            {
                cache.put(words[i],1);
            }
            else
            {
                cache.put(words[i],cache.get(words[i])+1);
            }
        }
        helper(0,s,words,cache);
        return rest;
    }
    public void helper(int i,String s,String[] words,HashMap<String,Integer> cache)
    {
        if(i+words.length*words[0].length()>s.length())
        {
            return;
        }
        HashMap<String,Integer> temp=new HashMap<>();
        boolean res=true;
        for(int j=i;j<i+words.length*words[0].length();j=j+words[0].length())
        {
            String t=s.substring(j,j+words[0].length());
           
            if(!temp.containsKey(t))
            {
            temp.put(t,1);
            }
            else
            {
            temp.put(t,temp.get(t)+1);
            }
            
            if(!cache.containsKey(t) || temp.get(t)>cache.get(t))
            {
                res=false;
                break;
            }
        }
        if(res)
            rest.add(i);
        
        helper(i+1,s,words,cache);
    }
}