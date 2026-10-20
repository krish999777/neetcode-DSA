class Solution {
    public int characterReplacement(String s, int k) {
        int count[]=new int[26];
        int max=0;
        int l=0,r=0;
        while(r<s.length()){
            char ch=s.charAt(r);
            count[ch-'A']+=1;
            while(r-l-maxCount(count)+1>k){
                count[s.charAt(l)-'A']-=1;
                l++;
            }
            max=Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
    private int maxCount(int[] count){
        int max=0;
        for(int c:count){
            max=Math.max(max,c);
        }
        return max;
    }
}
