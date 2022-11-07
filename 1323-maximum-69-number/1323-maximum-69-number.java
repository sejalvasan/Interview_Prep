class Solution {
    public int maximum69Number (int num) {
//         StringBuilder sb = new StringBuilder(num);
//         String s = String.valueOf(num);
//         boolean first = false;
        
//        for(int i =0;i<sb.size();i++){
//            int n = s.charAt(i) -'0';
//            if(n == 6 && first==false){
//                first = true;
//                s.charAt(i)='9';
//                break;
//            }
//        }
        
//         return Integer.parseInt(s);
        
        return Integer.parseInt(String.valueOf(num).replaceFirst("6","9"));
    }
}