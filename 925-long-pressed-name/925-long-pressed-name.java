class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name.length()>typed.length())
            return false;
        
        int i = 0;
        int j =0;
        
        while(i<name.length() && j<typed.length()){
            if(name.charAt(i)==typed.charAt(j))
            {
                i++;
                j++;
            }else if(i>0 && typed.charAt(j)==name.charAt(i-1)){
                j++;
            }
        else{
                    return false; //eg aac and bc
                }
        }
    //if j is left
        while(j<typed.length()){
            if(name.charAt(i-1)!=typed.charAt(j))
                return false;
            j++;
        }
        
        //if i is left
        
        return i<name.length()?false: true;
    }
}