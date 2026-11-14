class TrieNode{
    TrieNode children[];
    String word;
    TrieNode(){
        children=new TrieNode[26];
        word=null;
    }
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root=new TrieNode();
        for(String word:words){
            TrieNode ptr=root;
            for(char ch:word.toCharArray()){
                int index=ch-'a';
                if(ptr.children[index]==null){
                    ptr.children[index]=new TrieNode();
                }
                ptr=ptr.children[index];
            }
            ptr.word=word;
        }
        List<String> res=new ArrayList<>();
        int l1=board.length,l2=board[0].length;
        boolean[][] visited=new boolean[l1][l2];
        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                dfs(board,root,i,j,res,visited);
            }
        }
        return res;
    }
    private void dfs(char[][] board,TrieNode root,int i,int j,List<String> res,boolean[][] visited){
        if(root.word!=null){
            res.add(root.word);
            root.word=null;
        }
        if(i<0||i>=board.length||j<0||j>=board[0].length||
        root.children[board[i][j]-'a']==null||visited[i][j]){
            return;
        }
        TrieNode child=root.children[board[i][j]-'a'];
        visited[i][j]=true;
        dfs(board,child,i+1,j,res,visited);
        dfs(board,child,i-1,j,res,visited);
        dfs(board,child,i,j+1,res,visited);
        dfs(board,child,i,j-1,res,visited);
        visited[i][j]=false;
    }
}