class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l=0
        r=1
        maxp=0
        while r<len(prices):
            maxp=max(maxp,prices[r]-prices[l])
            if prices[l]>prices[r]:
                l=r
            r+=1
        return maxp