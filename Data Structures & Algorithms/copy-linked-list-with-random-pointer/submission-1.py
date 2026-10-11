"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        dummy=head
        nodes={}
        final=dummy2=copy=Node(head.val)
        nodes[head]=copy
        while dummy.next:
            dummy=dummy.next
            copy.next=Node(dummy.val)
            copy=copy.next
            nodes[dummy]=copy
        while head:
            rand=head.random
            if rand==None:
                dummy2.random=None
                head=head.next
                dummy2=dummy2.next
                continue
            dummy2.random=nodes[rand]
            head=head.next
            dummy2=dummy2.next
        return final     