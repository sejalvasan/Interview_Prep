// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}// } Driver Code Ends




class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean isOpening(Character c){
        if(c=='('||c=='{'|| c=='[')
        return true;
        
        return false;
    }
     static boolean isMatching(Character a, Character b){
            return (a=='('&& b==')' ||
                    a=='{' && b=='}' ||
                    a=='['&& b==']');
        }
        
    static boolean ispar(String s)
    {
        // add your code here
        Stack<Character> st = new Stack<>();
        
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(isOpening(c)){
                st.push(c);
            }else{
                if(st.isEmpty())
                return false;
                
                else if(!(isMatching(st.peek(),c)))
                return false;
                
                else
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
