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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tail=head;
        ListNode temp = head;
        int count = 1;
        while(tail.next != null){
            tail = tail.next;
            count++;
            
        }
        tail.next = head;
        k = k % count;
        for(int i =0 ; i< count - k-1 ; i++){
            temp = temp.next;
        }
        ListNode newhead = temp.next;
        temp.next = null;
        return newhead;
        
    }
}