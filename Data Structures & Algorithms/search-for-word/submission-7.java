class Solution {
    public boolean exist(char[][] board, String word) {
        int l1=board.length,l2=board[0].length;
        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                if(dfs(i,j,board,word,0,new boolean[l1][l2])){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int i,int j,char[][] board,String word,int index,boolean[][] visited){
        if(word.length()==index){
            return true;
        }
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(index)||visited[i][j]){
            return false;
        }
        visited[i][j]=true;
        boolean res=dfs(i-1,j,board,word,index+1,visited)||
        dfs(i+1,j,board,word,index+1,visited)||
        dfs(i,j-1,board,word,index+1,visited)||
        dfs(i,j+1,board,word,index+1,visited);
        visited[i][j]=false;
        return res;
    }
}
