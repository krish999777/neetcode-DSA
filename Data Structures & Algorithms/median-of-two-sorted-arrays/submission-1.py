class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        final=sorted(nums1+nums2)
        if len(final)%2==1:
            return final[len(final)//2]
        else:
             return (final[len(final)//2]+final[(len(final)//2)-1])/2