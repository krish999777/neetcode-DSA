class Solution {
    private int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r=heights.length,c=heights[0].length;
        boolean[][][] canFlow=new boolean[r][c][2];
        for(int i=0;i<r;i++){
            canFlow[i][0][0]=true;
            dfs(heights,i,0,r,c,canFlow,0);
        }
        for(int j=0;j<c;j++){
            canFlow[0][j][0]=true;
            dfs(heights,0,j,r,c,canFlow,0);
        }
        for(int i=0;i<r;i++){
            canFlow[i][c-1][1]=true;
            dfs(heights,i,c-1,r,c,canFlow,1);
        }
        for(int j=0;j<c;j++){
            canFlow[r-1][j][1]=true;
            dfs(heights,r-1,j,r,c,canFlow,1);
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(canFlow[i][j][0]&&canFlow[i][j][1]){
                    res.add(List.of(i,j));
                }
            }
        }
        return res;
    }
    private void dfs(int[][] heights,int i,int j,int r,int c,
    boolean[][][] canFlow,int ocean){
        for(int[] direction:directions){
            int newI=direction[0]+i;
            int newJ=direction[1]+j;
            if(newI>=0&&newJ>=0&&newI<r&&newJ<c&&
            !canFlow[newI][newJ][ocean]&&heights[newI][newJ]>=heights[i][j]){
                canFlow[newI][newJ][ocean]=true;
                dfs(heights,newI,newJ,r,c,canFlow,ocean);
            }
        }
    }
}