class Node{
    Node prev;
    Node next;
    int data;
    int key;
    Node(Node prev,Node next,int data,int key){
        this.prev=prev;
        this.next=next;
        this.data=data;
        this.key=key;
    }
    Node(int data,int key){
        this(null,null,data,key);
    }
    // public String toString(){
    //     String s=data+"";
    //     Node ptr=next;
    //     while(ptr!=null){
    //         s+="->"+ptr.data;
    //         ptr=ptr.next;
    //     }
    //     return s;
    // }
}

class LRUCache {
    int capacity;
    Node first,last;
    Map<Integer,Node> map;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node n=map.get(key);
        if(n.prev==null){
            first=first.next;
        }else{
            n.prev.next=n.next;
        }
        if(n.next==null){
            last=last.prev;
        }else{
            n.next.prev=n.prev;
        }
        if(first==null){
            first=n;
        }
        n.next=null;
        n.prev=last;
        if(last!=null){
            last.next=n;
        }
        last=n;
        // System.out.println(first);
        return n.data;
    }
    
    public void put(int key, int value) {
        Node n;
        if(map.containsKey(key)){
            n=map.get(key);
            n.data=value;
            if(n.prev==null){
                first=first.next;
                if(first!=null)
                    first.prev=null;
            }else{
                n.prev.next=n.next;
            }
            if(n.next==null){
                last=last.prev;
                if(last!=null)
                    last.next=null;
            }else{
                n.next.prev=n.prev;
            }
        }else{
            n=new Node(value,key);
            map.put(key,n);
        }
        if(first==null){
            first=n;
        }
        n.next=null;
        n.prev=last;
        if(last!=null){
            last.next=n;
        }
        last=n;

        if(map.size()>capacity){
            map.remove(first.key);
            first=first.next;
            first.prev=null;
        }
        // System.out.println(first);
    }
    // private void computeUsedKey(Node n){
        // if(n.prev==null){
        //     start=start.next;
        // }else{
        //     n.prev.next=n.next;
        // }
        // if(n.next==null){
        //     last=last.prev;
        // }else{
        //     n.next.prev=n.prev;
        // }
    // }
}
