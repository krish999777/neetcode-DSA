/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1=l1,ptr2=l2;
        ListNode head=new ListNode(),ptr=head;
        int carry=0;
        while(ptr1!=null||ptr2!=null||carry!=0){
            int sum=carry;
            if(ptr1!=null){
                sum+=ptr1.val;
                ptr1=ptr1.next;
            }
            if(ptr2!=null){
                sum+=ptr2.val;
                ptr2=ptr2.next;
            }
            ptr.next=new ListNode(sum%10);;
            ptr=ptr.next;
            carry=sum/10;
        }
        return head.next;
    }
}
