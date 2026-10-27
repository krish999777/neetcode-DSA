class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0;
        int maxCount=0;
        int maxLen=0;
        int count[]=new int[26];
        while(r<s.length()){
            maxCount=Math.max(maxCount,++count[s.charAt(r)-'A']);
            while(r-l+1-maxCount>k){
                count[s.charAt(l++)-'A']--;
                continue;
            }
            maxLen=Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
}
