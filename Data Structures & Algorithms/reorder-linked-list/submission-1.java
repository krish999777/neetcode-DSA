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
    public void reorderList(ListNode head) {
        int length=0;
        ListNode ptr=head;
        while(ptr!=null){
            length++;
            ptr=ptr.next;
        }
        int endCount=(length-1)/2;
        int startEndIndex=length-endCount-1;
        ListNode endPtr=head;
        int index=0;
        while(index<startEndIndex){
            endPtr=endPtr.next;
            index++;
        }
        int count=0;
        ptr=head;
        while(count<endCount){
            ListNode nthNode=endPtr;
            int count2=count;
            while(count2<endCount-1){
                nthNode=nthNode.next;
                count2++;
            }
            ListNode temp2=nthNode.next;
            nthNode.next=temp2.next;
            ListNode temp=ptr.next;
            temp2.next=temp;
            ptr.next=temp2;
            ptr=temp;
            count++;
        }
    }
}
