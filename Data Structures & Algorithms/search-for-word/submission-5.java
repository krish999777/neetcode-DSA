class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(dfs(i,j,board,word,new ArrayList<>())){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int i,int j,char[][] board,String word,List<List<Integer>> list){
        if(word.length()==0){
            return true;
        }
        List<Integer> cur=List.of(i,j);
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(0)||list.contains(cur)){
            return false;
        }
        list.add(cur);
        boolean res=dfs(i-1,j,board,word.substring(1),list)||
        dfs(i+1,j,board,word.substring(1),list)||
        dfs(i,j-1,board,word.substring(1),list)||
        dfs(i,j+1,board,word.substring(1),list);
        list.remove(list.size()-1);
        return res;
    }
}
