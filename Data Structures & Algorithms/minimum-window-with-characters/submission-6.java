class Solution {
    public String minWindow(String s, String t) {
        int m=s.length(),n=t.length();
        if(m<n){
            return "";
        }
        int start=-1,end=-1;
        Map<Character,Integer> sCount=new HashMap<>();
        Map<Character,Integer> tCount=new HashMap<>();
        for(int i=0;i<n;i++){
            char tCh=t.charAt(i);
            tCount.compute(tCh,(k,v)->v==null?1:v+1);
        }
        int unique=tCount.size();
        int matches=0;
        int r=0;
        int l=0;
        while(r<m){
            char rightChar=s.charAt(r);
            if(tCount.containsKey(rightChar)){
                sCount.compute(rightChar,(k,v)->(v==null)?1:v+1);
                if(tCount.get(rightChar).equals(sCount.get(rightChar))){
                    matches++;
                }
            }
            while(matches==unique){
                if(start==-1||end-start>r-l+1){
                    start=l;
                    end=r+1;
                }
                char leftChar=s.charAt(l);
                if(tCount.containsKey(leftChar)){
                    if(sCount.get(leftChar).equals(tCount.get(leftChar))){
                        matches--;
                    }
                    sCount.compute(leftChar,(k,v)->v-1);
                }
                l++;
            }
            r++;
        }
        if(start==-1){
            return "";
        }
        return s.substring(start,end);
    }
}