class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        dfs(0,0,s,new ArrayList<>(),res);
        return res;
    }
    private void dfs(int start,int i,String s,List<String> cur,List<List<String>> res){
        if(i==s.length()){
            if(start==i){
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        if(isPalindrome(s,start,i)){
            cur.add(s.substring(start,i+1));
            dfs(i+1,i+1,s,cur,res);
            cur.remove(cur.size()-1);
        }
        dfs(start,i+1,s,cur,res);
    }
    private boolean isPalindrome(String s,int start,int end){
        int l=start,r=end;
        while(l<=r){
            if(s.charAt(l++)!=s.charAt(r--)){
                return false;
            }
        }
        return true;
    }
}