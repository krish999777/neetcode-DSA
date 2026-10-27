class Solution {
    public String minWindow(String s, String t) {
        int min[]={-1,-1};
        int tLen=t.length(),sLen=s.length();
        Map<Character,Integer> tMap=new HashMap<>();
        Map<Character,Integer> sMap=new HashMap<>();
        if(tLen>sLen){
            return "";
        }
        for(char ch:t.toCharArray()){
            tMap.compute(ch,(k,v)->v==null?1:v+1);
        }
        int unique=tMap.size();
        int matches=0;
        int l=0,r=0;
        while(r<sLen){
            char ch=s.charAt(r);
            Integer count=tMap.get(ch);
            if(count!=null){
                int c=sMap.compute(ch,(k,v)->v==null?1:v+1);
                if(c==count){
                    matches++;
                }
                while(matches==unique){
                    if(min[0]==-1||min[1]-min[0]>r-l){
                        min=new int[]{l,r};
                    }
                    char rem=s.charAt(l++);
                    if(sMap.containsKey(rem)){
                        if(sMap.get(rem).equals(tMap.get(rem))){
                            matches--;
                        }
                        sMap.compute(rem,(k,v)->v-1);
                    }
                }
            }
            r++;
        }
        if(min[0]==-1){
            return "";
        }else{
            return s.substring(min[0],min[1]+1);
        }
    }
}
