class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0;
        int maxLen=0;
        Set<Character> set=new HashSet<>();
        while(r<s.length()){
            char ch=s.charAt(r);
            while(set.contains(ch)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(ch);
            maxLen=Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
}
