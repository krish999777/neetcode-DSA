# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        n1,n2=0,0
        power1,power2=0,0
        while l1:
            n1+=l1.val*(10**power1)
            power1+=1
            l1=l1.next
        while l2:
            n2+=l2.val*(10**power2)
            power2+=1
            l2=l2.next
        n3=n1+n2
        dummy=l3=ListNode(0)
        if n3==0:
            return dummy
        while n3>0:
            l3.next=ListNode(n3%10)
            l3=l3.next
            n3//=10
        return dummy.next