class Solution {

    public String encode(List<String> strs) {
        StringBuilder s=new StringBuilder("");
        for(String str:strs){
            s.append(str+"ejrfioejrio");
        }
        return s.toString();
    }

    public List<String> decode(String str) {
        List<String> l=new ArrayList<>();
        while(str.length()!=0){
            int ind=str.indexOf("ejrfioejrio");
            l.add(str.substring(0,ind));
            str=str.substring(ind+11);
        }
        return l;
    }
}
