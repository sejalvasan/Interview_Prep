class Solution {
    int[] parent;
    int[] rank;
    
    public int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        
        int sl = find(parent[x]);
        parent[x] = sl;
        return sl;
    }
    public void union(int u,int v) {
        int slu = find(u);
        int slv = find(v);
        
        if(slu != slv) {
            int rslu = rank[slu];
            int rslv = rank[slv];
            
            if(rslu < rslv) {
                parent[slu] = slv;
            }
            else if(rslv < rslu) {
                parent[slv] = slu;
            }
            else {
                parent[slu] = slv;
                rank[slv]++;
            }
        }
    }
    
    public boolean equationsPossible(String[] equations) {
        
        parent = new int[26];
        rank = new int[26];
        
        //initialization of parent and rank array
        for(int i = 0; i<26; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        //making connections b/w equalties olny
        for(int i = 0; i<equations.length; i++) {
            String eqn = equations[i];
            
            char ch = eqn.charAt(1);
            int u = eqn.charAt(0) - 'a';
            int v = eqn.charAt(3) - 'a';
            
            if(ch == '=') {
                union(u, v);
            }
        }
        
        //now verifiying the inequalities are true or not!?
        for(int i = 0; i<equations.length; i++) {
            String eqn = equations[i];
            
            char ch = eqn.charAt(1);
            int u = eqn.charAt(0) - 'a';
            int v = eqn.charAt(3) - 'a';
            
            if(ch == '!') {
                int slu = find(u);
                int slv = find(v);
                
                if(slu == slv) {
                    return false;
                }
            }
        }
        return true;
    }
}