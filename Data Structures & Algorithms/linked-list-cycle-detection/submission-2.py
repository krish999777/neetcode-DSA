# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        checked=set()
        while head:
            if head in checked:
                return True
            checked.add(head)
            head=head.next
        return False