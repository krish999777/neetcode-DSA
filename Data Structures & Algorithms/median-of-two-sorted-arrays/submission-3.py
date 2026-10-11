class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        half=(len(nums1)+len(nums2))//2
        if len(nums1)>len(nums2):
            nums1,nums2=nums2,nums1
        l,r=0,len(nums1)-1
        while True:
            mid=(l+r)//2
            mid2=half-mid-2
            Aleft = nums1[mid] if mid>= 0 else float("-infinity")
            Aright = nums1[mid + 1] if (mid + 1) < len(nums1) else float("infinity")
            Bleft = nums2[mid2] if mid2 >= 0 else float("-infinity")
            Bright = nums2[mid2 + 1] if (mid2 + 1) < len(nums2) else float("infinity")
            if Aleft<=Bright and Bleft<=Aright:
                if (len(nums1)+len(nums2))%2==0:
                    m1=max(Aleft,Bleft)
                    m2=min(Aright,Bright)
                    return (m1+m2)/2
                else:
                    return min(Aright,Bright)
            elif Aleft>Bright:
                r=mid-1
            else:
                l=mid+1
