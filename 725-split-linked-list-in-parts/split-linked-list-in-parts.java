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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;

        }
        int part = len/k;
        int extraPart = len % k;
         
        ListNode[] result = new ListNode[k];
        curr = head;
        for(int i = 0; i < k; i++){
            int sublist = ( extraPart > i ) ? (part + 1) : part;
            if(sublist == 0){
                result[i] = null;
            }
            else{
                ListNode sublistHead= curr;
                for(int j = 0; j<sublist -1;j++){
                    curr= curr.next;

                }
                ListNode nextNode = curr.next;
                curr.next = null;
                result[i] = sublistHead;
                curr = nextNode;


            }
        }
        return result;
    }
}