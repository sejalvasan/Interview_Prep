class Solution {
   public boolean validUtf8(int[] data) {
    int type=0,i=0;         
    boolean isValid = false;
    
    while(i<data.length){                                   //traverse whole given data array        
        if(!isValid){
            String s = convertToBinary(data[i]);            //function call for conversion
            if(s.charAt(0) == '0')                          //if OCTET seq. begin with '0' then it is type 1 (given)
                type = 1;
            else if(s.substring(0,5).equals("11110"))       //similarly check for all other types (type 4)
                type = 4;
            else if(s.substring(0,4).equals("1110"))        //Type 3
                type = 3;
            else if(s.substring(0,3).equals("110"))         //Type 2         
                type = 2;
            else
                return false;                               //if other then given respective types, return false
            
            isValid = true;                                 //if false does not return, it means beginning isValid
            i++;
            type--;
        }
        else{
            while(type>0){                                
                String s = convertToBinary(data[i]).substring(0,2);         //check for rest of the sequence
                if(!s.equals("10"))                                         //if not equals to "10" (as given in Question)
                    return false;                                           //return false
                
                type--;
                i++;
            }
            isValid = false;
        }
    }
    
    if(type != 0)               //if type is not zero, all sequence are not according to the rule & loop is not run till end.
        return false;           
    
    return true;            
}

public String convertToBinary(int x)                    //Here, we convert an int into a binary string
{
    final char[] binary = new char[8];                  //Given OCTECT Sequence that's why size = 8
    for (int i = 7; i >= 0 ; i--){
        int mask = 1 << i;
        binary[7 - i] = (x & mask) != 0 ? '1' : '0';
    }

    return new String(binary);
}
}