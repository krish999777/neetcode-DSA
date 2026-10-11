class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res=[]
        for i in range(len(nums)-k+1):
            window=[]
            for j in range(k):
                window.append(nums[i+j])
            res.append(max(window))
        return res