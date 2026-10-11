# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        
        dummy=copy=head
        length=0
        while copy:
            length+=1
            copy=copy.next
        if length==n:
            return head.next
        index=length-n
        curr=1
        while head:
            if curr==index:
                head.next=head.next.next if head.next.next else None
                break
            curr+=1
            head=head.next
        return dummy
                