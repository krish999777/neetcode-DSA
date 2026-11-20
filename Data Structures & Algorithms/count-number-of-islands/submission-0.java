class Solution {
    public int numIslands(char[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        boolean[][] visited=new boolean[r][c];
        int count=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                count+=dfs(grid,visited,i,j,r,c)?1:0;
            }
        }
        return count;
    }
    private boolean dfs(char[][] grid,boolean[][] visited,int i,int j,int r,int c){
        if(i<0||j<0||i==r||j==c||visited[i][j]||grid[i][j]=='0'){
            return false;
        }
        visited[i][j]=true;
        dfs(grid,visited,i+1,j,r,c);
        dfs(grid,visited,i-1,j,r,c);
        dfs(grid,visited,i,j+1,r,c);
        dfs(grid,visited,i,j-1,r,c);
        return true;
    }
}