class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        sub=[]
        i=0
        longest,length=0,0
        while i<len(s):
            while s[i] in sub:
                sub.pop(0)
                length-=1
            sub.append(s[i])
            i+=1
            length+=1
            longest=max(longest,length)
        return longest