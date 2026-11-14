class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        dfs(res,n,0,new ArrayList<>());
        return res;
    }
    private void dfs(List<List<String>> res,int n,int i,List<Integer> queens){
        if(i==n){
            if(queens.size()==n){
                List<String> cur=new ArrayList<>();
                StringBuilder demo=new StringBuilder();
                for(int j=0;j<n;j++){
                    demo.append('.');
                }
                for(int j=0;j<n;j++){
                    int index=queens.get(j);
                    demo.setCharAt(index,'Q');
                    cur.add(demo.toString());
                    demo.setCharAt(index,'.');
                }
                res.add(cur);
            }
            return;
        }
        for(int j=0;j<n;j++){
            boolean flag=true;
            for(int k=0;k<queens.size();k++){
                if(queens.get(k)==j||Math.abs(k-i)==Math.abs(queens.get(k)-j)){
                    flag=false;
                }
            }
            if(flag){
                queens.add(j);
                dfs(res,n,i+1,queens);
                queens.remove(queens.size()-1);
            }
        }
    }
}
