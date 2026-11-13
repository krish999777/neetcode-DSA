class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[] res=new boolean[1];
        res[0]=false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                dfs(i,j,board,word,res,new ArrayList<>());
            }
        }
        return res[0];
    }
    private void dfs(int i,int j,char[][] board,String word,boolean[] res,List<List<Integer>> list){
        if(word.length()==0){
            res[0]=true;
            return;
        }
        List<Integer> cur=List.of(i,j);
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(0)||list.contains(cur)){
            return;
        }
        list.add(cur);
        dfs(i-1,j,board,word.substring(1),res,list);
        dfs(i+1,j,board,word.substring(1),res,list);
        dfs(i,j-1,board,word.substring(1),res,list);
        dfs(i,j+1,board,word.substring(1),res,list);
        list.remove(list.size()-1);
    }
}
