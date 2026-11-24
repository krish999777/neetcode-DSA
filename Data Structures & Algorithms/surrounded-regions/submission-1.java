class Solution {
    public void solve(char[][] board) {
        int r=board.length,c=board[0].length;
        boolean[][] isNotSurrounded=new boolean[r][c];
        for(int i=0;i<r;i++){
            dfs(board,i,0,r,c,isNotSurrounded);
            dfs(board,i,c-1,r,c,isNotSurrounded);
        }
        for(int j=0;j<c;j++){
            dfs(board,0,j,r,c,isNotSurrounded);
            dfs(board,r-1,j,r,c,isNotSurrounded);
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]=='O'&&!isNotSurrounded[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
    private void dfs(char[][] board,int i,int j,int r,int c,boolean[][] isNotSurrounded){
        if(i<0||j<0||i==r||j==c||
        board[i][j]=='X'||isNotSurrounded[i][j]){
            return;
        }
        isNotSurrounded[i][j]=true;
        dfs(board,i+1,j,r,c,isNotSurrounded);
        dfs(board,i-1,j,r,c,isNotSurrounded);
        dfs(board,i,j+1,r,c,isNotSurrounded);
        dfs(board,i,j-1,r,c,isNotSurrounded);
    }
}