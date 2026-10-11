class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t)>len(s):
            return ""
        res=""
        need={}
        for c in t:
            need[c]=1+need.get(c,0)
        l,r=0,0
        hash2={}
        corr=0
        req=len(need)
        have={}
        while r<len(s):
            if s[r] in need:
                have[s[r]]=1+have.get(s[r],0)#it will update again if 'A' comes extra
                if have[s[r]]==need[s[r]]:
                    corr+=1
            while corr==req:
                res=s[l:r+1] if (len(s[l:r+1])<len(res) or res=="") else res
                if s[l] in need:
                    have[s[l]] -= 1
                    if have[s[l]] < need[s[l]]:
                        corr -= 1
                l += 1
            r+=1
        return res