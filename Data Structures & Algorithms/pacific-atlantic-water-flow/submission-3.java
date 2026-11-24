class Solution {
    private int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r=heights.length,c=heights[0].length;
        boolean[][] canFlowPacific=new boolean[r][c];
        boolean[][] canFlowAtlantic=new boolean[r][c];
        for(int i=0;i<r;i++){
            canFlowPacific[i][0]=true;
            dfs(heights,i,0,r,c,canFlowPacific);
        }
        for(int j=0;j<c;j++){
            canFlowPacific[0][j]=true;
            dfs(heights,0,j,r,c,canFlowPacific);
        }
        for(int i=0;i<r;i++){
            canFlowAtlantic[i][c-1]=true;
            dfs(heights,i,c-1,r,c,canFlowAtlantic);
        }
        for(int j=0;j<c;j++){
            canFlowAtlantic[r-1][j]=true;
            dfs(heights,r-1,j,r,c,canFlowAtlantic);
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(canFlowPacific[i][j]&&canFlowAtlantic[i][j]){
                    res.add(List.of(i,j));
                }
            }
        }
        return res;
    }
    private void dfs(int[][] heights,int i,int j,int r,int c,
    boolean[][] canFlow){
        for(int[] direction:directions){
            int newI=direction[0]+i;
            int newJ=direction[1]+j;
            if(newI>=0&&newJ>=0&&newI<r&&newJ<c&&
            !canFlow[newI][newJ]&&heights[newI][newJ]>=heights[i][j]){
                canFlow[newI][newJ]=true;
                dfs(heights,newI,newJ,r,c,canFlow);
            }
        }
    }
}