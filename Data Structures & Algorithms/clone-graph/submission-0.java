/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Deque<Node> stack=new ArrayDeque<>();
        Map<Integer,Node> map=new HashMap<>();
        stack.push(node);
        while(stack.size()>0){
            Node cur=stack.pop();
            Node newNode=new Node(cur.val);
            map.put(cur.val,newNode);
            for(Node n:cur.neighbors){
                if(!map.containsKey(n.val)){
                   stack.push(n); 
                }
            }
        }
        Set<Node> visited=new HashSet<>();
        stack.push(node);
        while(stack.size()>0){
            Node cur=stack.pop();
            visited.add(cur);
            Node newNode=map.get(cur.val);
            List<Node> list=new ArrayList<>();
            for(Node n:cur.neighbors){
                list.add(map.get(n.val));
                if(!visited.contains(n)){
                    stack.push(n);
                }
            }
            newNode.neighbors=list;
        }
        return map.get(node.val);
    }
}