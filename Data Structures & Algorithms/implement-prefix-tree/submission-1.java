class Node{
    Node children[];
    boolean isWord;
    Node(){
        children=new Node[26];
        isWord=false;
    }
}

class PrefixTree {
    Node head;
    public PrefixTree() {
        head=new Node();
    }

    public void insert(String word) {
        Node ptr=head;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(ptr.children[ch-'a']==null){
                ptr.children[ch-'a']=new Node();
            }
            ptr=ptr.children[ch-'a'];
        }
        ptr.isWord=true;
    }

    public boolean search(String word) {
        Node ptr=head;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            Node next=ptr.children[ch-'a'];
            if(next==null){
                return false;
            }
            ptr=next;
        }
        return ptr.isWord;
    }

    public boolean startsWith(String prefix) {
        Node ptr=head;
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            Node next=ptr.children[ch-'a'];
            if(next==null){
                return false;
            }
            ptr=next;
        }
        return true;
    }
}
