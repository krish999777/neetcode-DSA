class Solution(object):
    def longestConsecutive(self, nums):
        hash=set(nums)
        longest=0

        for n in hash:
            if n-1 in hash:
                continue
            else:
                length=0
                while (n+length) in hash:
                    length+=1
                longest=max(length,longest)
        return longest
        