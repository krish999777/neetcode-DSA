class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        char[][] mapping={{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        dfs(digits,0,mapping,new StringBuilder(),res);
        return res;
    }
    private void dfs(String digits,int i,char[][] mapping,StringBuilder cur,List<String> res){
        if(i==digits.length()){
            res.add(cur.toString());
            return;
        }
        int num=digits.charAt(i)-'0';
        char[] choices=mapping[num-2];
        for(char choice:choices){
            cur.append(choice);
            dfs(digits,i+1,mapping,cur,res);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}