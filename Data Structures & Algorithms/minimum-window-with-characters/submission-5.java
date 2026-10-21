class Solution {
    public String minWindow(String s, String t) {
        int m=s.length(),n=t.length();
        if(m<n){
            return "";
        }
        int start=-1,end=-1;
        int[] sCount=new int[52];
        int[] tCount=new int[52];
        for(int i=0;i<n;i++){
            char sCh=s.charAt(i);
            char tCh=t.charAt(i);
            sCount[Character.isUpperCase(sCh)?26+sCh-'A':sCh-'a']++;
            tCount[Character.isUpperCase(tCh)?26+tCh-'A':tCh-'a']++;
        }
        int matches=0;
        for(int i=0;i<52;i++){
            if(sCount[i]>=tCount[i]){
                matches++;
            }
        }
        int l=0,r=n;
        if(matches==52){
            return s.substring(l,r);
        }
        while(r<m){
            char rightChar=s.charAt(r);
            int rightIndex=Character.isUpperCase(rightChar)?26+rightChar-'A':rightChar-'a';
            sCount[rightIndex]++;

            if(sCount[rightIndex]==tCount[rightIndex]){
                matches++;
            }
            while(matches==52){
                if(start==-1||end-start>r-l+1){
                    start=l;
                    end=r+1;
                }
                char leftChar=s.charAt(l);
                int leftIndex=Character.isUpperCase(leftChar)?26+leftChar-'A':leftChar-'a';
                if(sCount[leftIndex]==tCount[leftIndex]){
                    matches--;
                }
                sCount[leftIndex]--;
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