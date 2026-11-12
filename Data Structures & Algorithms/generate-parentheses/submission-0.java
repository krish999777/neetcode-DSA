class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        dfs(0,0,n,new StringBuilder(),res);
        return res;
    }
    private void dfs(int open,int close,int n,StringBuilder s,List<String> res){
        if(open+close==n*2){
            res.add(s.toString());
            return;
        }
        if(open<n){
            s.append('(');
            dfs(open+1,close,n,s,res);
            s.deleteCharAt(s.length()-1);
        }
        if(open>close){
            s.append(')');
            dfs(open,close+1,n,s,res);
            s.deleteCharAt(s.length()-1);
        }
    }
}