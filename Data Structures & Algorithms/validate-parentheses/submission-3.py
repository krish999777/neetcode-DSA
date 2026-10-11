class Solution:
    def isValid(self, s: str) -> bool:
        st=[]
        hashm={')':'(',']':'[','}':'{'}
        for c in s:
            if c in {'(','{','['}:
                st.append(c)
            else:
                if not st:
                    return False
                ch=st.pop()
                if hashm[c]!=ch:
                    return False
        if not st:
            return True
        else:
            return False