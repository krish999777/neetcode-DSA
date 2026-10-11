class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        maxi=max(piles)
        mini=1
        res=0
        smallest=0
        while mini<=maxi:
            mid=(mini+maxi)//2
            time=0
            for i in piles:
                time+=math.ceil(i/mid)

            if time <= h:
                res=min(res,mid) if res!=0 else mid
                maxi=mid-1
            else:
                mini=mid+1
        return res
        