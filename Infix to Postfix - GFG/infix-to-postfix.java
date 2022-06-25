// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to convert an infix expression to a postfix expression.
static String infixToPostfix(String str)
    {
        Stack<String> post = new Stack<>();
        Stack<Character> optors = new Stack<>();
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='('){
              optors.push(ch);
            }else if(ch==')'){
               while (optors.size()>0 && optors.peek()!='('){
                   char op = optors.pop();
                 
                   String v2post = post.pop();
                   String v1post = post.pop();
                   String valpost = v1post+v2post+String.valueOf(op);
                   post.push(valpost);
               }
               optors.pop();
            }else if(Character.isLetterOrDigit(ch)){
                post.push(String.valueOf(ch));
            }else if(ch=='*'||ch=='+'||ch=='-'||ch=='/'||ch=='^'){
                while (optors.size()>0 && optors.peek()!='(' && precedence(ch)<=precedence(optors.peek())){
                    char op = optors.pop();
        
                    String v2post = post.pop();
                    String v1post = post.pop();
                        String valpost = v1post+v2post+String.valueOf(op);
                    post.push(valpost);
                }
                optors.push(ch);
            }
        }

        while (optors.size()>0){
            char op = optors.pop();
       
            String v2post = post.pop();
            String v1post = post.pop();
            String valpost = v1post+v2post+String.valueOf(op);
            post.push(valpost);
        }
     
        return post.peek();
    }
    public static int precedence(char optors){
        if(optors=='+'){
          return 1;
        }else if(optors=='-'){
           return 1;
        }else if(optors=='*'){
          return 2;
        }else if(optors=='/') 
           return 2;
           else
           return 3;
        }
    }