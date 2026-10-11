class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hm={}
        for i in nums:
            hm[i]=1+hm.get(i,0)
        sorted_hm=sorted(hm.items(),key=lambda x:x[1],reverse=True)
        sorted_key=[x[0] for x in sorted_hm]
        result=sorted_key[:k]
        return result
