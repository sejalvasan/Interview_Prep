// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}
// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    Node buildTree(int inord[], int level[])
    {
        //your code here
        return  buildTree(inord, level,0,inord.length-1);
    }
    // Node construct(int[]in,int inlo,int inhi,int[] level){
    //     if(inlo>inhi)
    //     return null;
        
    //     Node node = new Node(level[0]);
        
    //     if(level.length==1)
    //     return node;
        
    //     int idx = inlo;
    //     while(in[idx]!=node.data) idx++;
        
    //     int[]level1 = new int[idx-inlo];
    //     int[]level2 = new int[inhi-idx];
        
    //     HashSet<Integer> set = new HashSet<>();
        
    //     for(int i=inlo;i<idx;i++)
    //     set.add(in[i]);
        
//         int ls=0, rs =0;
        
//         for(int i=1;i<level.length;i++){
//             int ele = level[i];
            
//             if(set.size()!=0 && set.contains(ele)){
//                 level1[ls++]=ele;
//                 set.remove(ele);
//             }else
//             level2[rs++]=ele;
//         }
        
//         node.left=construct(in,inlo ,idx-1 , level);
//         node.right=construct(in, idx+1, inhi, level);
        
//         return node;
//     }
   
// }

 public static Node buildTree(int inorder[], int levelOrder[], int isi, int iei) {
    if (isi > iei)
      return null;

    Node root = new Node(levelOrder[0]);

    int idx = isi;
    while (levelOrder[0] != inorder[idx])
      idx++;

    HashSet<Integer> s = new HashSet<>();
    for (int i = isi; i < idx; i++)
      s.add(inorder[i]);

    int n = iei - isi + 1;
    int[] lLevel = new int[s.size()]; // Left
    int[] rLevel = new int[n - s.size()]; // Right
    int li = 0, ri = 0;
    for (int i = 1; i < n; i++) {
      if (s.contains(levelOrder[i]))
        lLevel[li++] = levelOrder[i];
      else
        rLevel[ri++] = levelOrder[i];
    }

    root.left = buildTree(inorder, lLevel, isi, idx - 1);
    root.right = buildTree(inorder, rLevel, idx + 1, iei);
    return root;
  }
}

