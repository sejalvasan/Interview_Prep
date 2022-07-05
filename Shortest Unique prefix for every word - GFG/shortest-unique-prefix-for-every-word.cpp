// { Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function Template for C++

class Solution
{
   struct Trienode
 {
     int freq;
     Trienode* child[26]; //a-z
     Trienode()
     {
         freq = 0;
         for(int i=0;i<26;i++)child[i]=NULL;
     }
 };
    public: 
     Trienode* root = new Trienode();
    vector<string> findPrefixes(string arr[], int n)
    {
        //code here
        vector<string>ans;
        for(int i=0;i<n;i++)
        buildtrie(arr[i],root);
        
        for(int i=0;i<n;i++)
        ans.push_back(buildprefix(arr[i],root));
        return ans;
       
    }
    
    void buildtrie(string s,Trienode* root)
    {   
        Trienode* curr = root;
         for(int i=0;i<s.length();i++)
         {
             int index = s[i]-'a'; //25
             if(curr->child[index]==NULL)
             curr->child[index]= new Trienode();
             curr->child[index]->freq++;
             curr = curr->child[index];
         }
    }
    
    string buildprefix(string s,Trienode* root)
    {
        Trienode* curr = root;
        string ans = "";
         for(int i=0;i<s.length();i++)
         {   
             int index = s[i]-'a';
             if(curr->freq==1)break;
             ans+=s[i];
              curr = curr->child[index];
         }
         return ans;
    }
};
// { Driver Code Starts.

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;

        string arr[n];
        for (int i = 0; i < n; i++)
            cin >> arr[i];
            
        Solution ob;
        vector<string> ans = ob.findPrefixes(arr, n);
        
        for (int i = 0; i < ans.size(); i++)
            cout << ans[i] <<" ";


        cout << "\n";

    }

    return 0;
}
  // } Driver Code Ends