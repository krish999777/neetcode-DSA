class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        checked=set()
        for i in nums:
            if i in checked:
                return i
            checked.add(i)
    
        