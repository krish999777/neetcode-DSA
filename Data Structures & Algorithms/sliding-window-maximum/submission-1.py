class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res,window=[],[]
        for i in range(k):
            window.append(nums[i])
        res.append(max(window))
        for i in range(len(nums)-k):
            window.pop(0)
            window.append(nums[i+k])
            res.append(max(window))
        return res
