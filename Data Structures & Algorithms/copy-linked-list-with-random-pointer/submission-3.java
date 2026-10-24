/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map=new HashMap<>();
        Node ptr=head;
        Node start=null,last=null;
        while(ptr!=null){
            Node newNode=new Node(ptr.val);
            map.put(ptr,newNode);
            if(start==null){
                start=newNode;
                last=newNode;
            }else{
                last.next=newNode;
                last=newNode;
            }
            ptr=ptr.next;
        }
        ptr=head;
        Node ptr2=start;
        while(ptr!=null){
            ptr2.random=ptr.random==null?null:map.get(ptr.random);
            ptr2=ptr2.next;
            ptr=ptr.next;
        }
        return start;
    }
}
