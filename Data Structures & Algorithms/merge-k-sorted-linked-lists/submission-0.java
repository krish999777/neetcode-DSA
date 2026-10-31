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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy=new ListNode(),ptr=dummy;
        int l=lists.length;
        int completeCount=0;
        while(completeCount!=l){
            int min=-1;
            completeCount=0;
            for(int i=0;i<l;i++){
                ListNode list=lists[i];
                if(list==null){
                    completeCount++;
                    continue;
                }
                if(min==-1||list.val<lists[min].val){
                    min=i;
                }
            }
            if(min!=-1){
                ptr.next=lists[min];
                lists[min]=lists[min].next;
                ptr=ptr.next;
            }
        }
        return dummy.next;
    }
}
