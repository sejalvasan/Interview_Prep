// { Driver Code Starts
import java.util.*;
import java.util.Stack;
import java.util.LinkedList;



class GfG
{
	public static void main(String args[])
	{
	    //Taking input using class Scanner
		Scanner sc = new Scanner(System.in);
		
		//Taking input the number of testcases
		int t = sc.nextInt();
		while(t>0)
		{
		    //Creating a new object of class StackQueue
			StackQueue g = new StackQueue();
			
			//Taking input the total number of Queries
			int q = sc.nextInt();
			while(q>0)
			{
				int QueryTyoe = sc.nextInt();
				
				//If QueryTyoe is 1 then
				//we call the Push method
				//of class StackQueue
				//else we call the Pop method
				if(QueryTyoe == 1)
				{
					int a = sc.nextInt();
					g.Push(a);
				}else
				if(QueryTyoe == 2)
				System.out.print(g.Pop()+" ");
			q--;
				
			}
			System.out.println();
		t--;
		}
	}
}

// } Driver Code Ends


class StackQueue
{
    Stack<Integer> st1 = new Stack<Integer>();
    Stack<Integer> st2 = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    
    //PUSH EFFICIENT
    
    // void Push(int x)
    // {
	   //// Your code here
	   //st1.push(x);
    // }
	
    
    // //Function to pop an element from queue by using 2 stacks.
    // int Pop()
    // {
	   //// Your code here
	   //if(st1.isEmpty())
	   //return -1;
	   
	   //while(!st1.isEmpty())
	   //    st2.push(st1.pop());
	   
	   //    int val = st2.pop();
	       
	   //    while(!st2.isEmpty())
	   //    st1.push(st2.pop());
	       
	   //    return val;
    // }
    
    //pop efficient
    
         void Push(int x){
             
             while(!st1.isEmpty())
             st2.push(st1.pop());
             
             st1.push(x);
             
             while(!st2.isEmpty())
             st1.push(st2.pop());
         }
     int Pop(){
        if(st1.isEmpty())
        return -1;
        
        return st1.pop();
     }

}
