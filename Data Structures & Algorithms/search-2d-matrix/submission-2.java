class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int cols=matrix[0].length;
        int r=matrix.length*cols-1;
        while(l<=r){
            int mid=(l+r)/2;
            int i=mid/cols;
            int j=mid%cols;
            int num=matrix[i][j];
            if(num==target){
                return true;
            }else if(num<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return false;
    }
}
