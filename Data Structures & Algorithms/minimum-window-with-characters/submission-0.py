class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t)>len(s):
            return ""
        res=""
        hashmap={}
        for c in t:
            hashmap[c]=1+hashmap.get(c,0)
        l,r=0,0
        while r<len(s)+1:
            hash2={}
            for c in s[l:r]:
                hash2[c]=1+hash2.get(c,0)
            flag=1
            for c in t:
                if hashmap[c]<=hash2.get(c,0):
                    flag=1
                else:
                    flag=0
                    break
            if flag==1:
                res=s[l:r] if len(res)>len(s[l:r])or res=="" else res
                l+=1
            else:
                r+=1
        return res