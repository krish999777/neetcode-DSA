class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        l=len(s1)
        sorteds1=sorted(s1)
        if len(s2)<len(s1):
            return False
        for le in range(len(s2)-l+1):
            sub1=s2[le:le+l]
            sub=sorted(sub1)
            if sub ==sorteds1:
                return True
        return False