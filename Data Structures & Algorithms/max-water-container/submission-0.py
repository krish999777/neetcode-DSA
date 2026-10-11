class Solution:
    def maxArea(self, heights: List[int]) -> int:
        l,r=0,len(heights)-1
        maxi=0
        while l<r:
            vol=min(heights[l],heights[r])*(r-l)
            maxi=max(vol,maxi)
            if heights[l]<heights[r]:
                l+=1
            else:
                r-=1
        return maxi

        