class TrieNode{
    TrieNode children[];
    boolean isWord;
    TrieNode(){
        children=new TrieNode[26];
        isWord=false;
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode ptr=root;
        for(char ch:word.toCharArray()){
            if(ptr.children[ch-'a']==null){
                ptr.children[ch-'a']=new TrieNode();
            }
            ptr=ptr.children[ch-'a'];
        }
        ptr.isWord=true;
    }

    public boolean search(String word) {
        return searchDfs(word,0,root);
    }
    private boolean searchDfs(String word,int i,TrieNode ptr){
        if(ptr==null){
            return false;
        }
        if(word.length()==i){
            return ptr.isWord;
        }
        char ch=word.charAt(i);
        if(ch=='.'){
            boolean flag=false;
            for(int j=0;j<26;j++){
                flag=flag||searchDfs(word,i+1,ptr.children[j]);
            }
            return flag;
        }else{
            return searchDfs(word,i+1,ptr.children[ch-'a']);
        }
    }
}
