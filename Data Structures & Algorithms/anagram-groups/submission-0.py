from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        rs=defaultdict(list)
        for s in strs:
            sor=tuple(sorted(s))
            rs[sor].append(s)
        li=[]
        for i in rs.values():
            li.append(i)
        return li



            
