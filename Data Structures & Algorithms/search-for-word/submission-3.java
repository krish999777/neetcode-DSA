class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[] res=new boolean[1];
        res[0]=false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                dfs(i,j,board,word,res,new HashSet<>());
            }
        }
        return res[0];
    }
    private void dfs(int i,int j,char[][] board,String word,boolean[] res,Set<List<Integer>> set){
        if(word.length()==0){
            res[0]=true;
            return;
        }
        List<Integer> cur=new ArrayList<>(List.of(i,j));
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(0)||set.contains(cur)){
            return;
        }
        set.add(cur);
        dfs(i-1,j,board,word.substring(1),res,set);
        dfs(i+1,j,board,word.substring(1),res,set);
        dfs(i,j-1,board,word.substring(1),res,set);
        dfs(i,j+1,board,word.substring(1),res,set);
        set.remove(cur);
    }
}
