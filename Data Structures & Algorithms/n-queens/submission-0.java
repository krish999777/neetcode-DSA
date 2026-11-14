class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        dfs(res,new ArrayList<>(),n,0,new ArrayList<>());
        return res;
    }
    private void dfs(List<List<String>> res,List<String> cur,int n,int i,List<List<Integer>> queens){
        if(i==n){
            if(queens.size()==n)
                res.add(new ArrayList<>(cur));
            return;
        }
        StringBuilder s=new StringBuilder();
        for(int j=0;j<n;j++){
            s.append('.');
        }
        for(int j=0;j<n;j++){
            boolean flag=true;
            for(List<Integer> pos:queens){
                if(pos.get(1)==j||Math.abs(pos.get(0)-i)==Math.abs(pos.get(1)-j)){
                    flag=false;
                }
            }
            if(flag){
                s.setCharAt(j,'Q');
                cur.add(s.toString());
                queens.add(List.of(i,j));
                dfs(res,cur,n,i+1,queens);
                queens.remove(queens.size()-1);
                cur.remove(cur.size()-1);
                s.setCharAt(j,'.');
            }
        }
    }
}
