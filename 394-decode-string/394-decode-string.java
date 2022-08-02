class Solution {
    public String decodeString(String s) {
        //TC = O(N) SC =O(N)
        Stack<StringBuilder> strStack= new Stack<>();
        Stack<Integer> freqStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k =0;
        
        for(char c:s.toCharArray()){
              if(Character.isDigit(c)){
                  k=k*10+(c-'0'); // if k is of multiple digits
              }else if(Character.isLetter(c)){
                  sb.append(c);
              }else if(c=='['){
                  strStack.push(sb);
                  freqStack.push(k);
                  //reset
                  k=0;
                  sb = new StringBuilder();
              }else{
                  // ]
                  StringBuilder temp = sb;
                  int freq = freqStack.pop();
                  sb = strStack.pop();
                  
                  while(freq>0){
                      sb.append(temp);
                      freq--;
                  }
                  k=0;
              }
        }
        return sb.toString();
    }
}