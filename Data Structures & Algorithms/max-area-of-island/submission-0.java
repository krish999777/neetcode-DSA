class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int r=grid.length,c=grid[0].length;
        int max=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,dfs(grid,i,j,r,c));
                }
            }
        }
        return max;
    }
    private int dfs(int[][] grid,int i,int j,int r,int c){
        grid[i][j]=0;
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        int count=1;
        for(int[] dir:directions){
            int newI=i+dir[0];
            int newJ=j+dir[1];
            if(!(newI<0||newJ<0||newI==r||newJ==c||grid[newI][newJ]==0)){
                count+=dfs(grid,newI,newJ,r,c);
            }
        }
        return count;
    }
}
