class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            Set<Character> row=new HashSet<>();
            Set<Character> col=new HashSet<>();
            for(int j=0;j<9;j++){
                char rowNum=board[i][j];
                char colNum=board[j][i];
                if(rowNum!='.'&&row.contains(rowNum)){
                    return false;
                }
                if(colNum!='.'&&col.contains(colNum)){
                    return false;
                }
                row.add(rowNum);
                col.add(colNum);
            }
        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                Set<Character> s=new HashSet<>();
                for(int k=0;k<9;k++){
                    int row=i+k/3;
                    int col=j+k%3;
                    char item=board[row][col];
                    if(item!='.'&&s.contains(item)){
                        return false;
                    }
                    s.add(item);
                }
            }
        }
        return true;
    }
}
