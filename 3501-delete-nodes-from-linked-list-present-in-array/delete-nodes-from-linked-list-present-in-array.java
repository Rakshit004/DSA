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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Arrays.sort(nums);
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (existsInArray(nums, curr.val)) {
                prev.next = curr.next;
            } else {
                prev = curr; 
            }
            curr = curr.next;
        }

        return dummy.next;
    }

    private boolean existsInArray(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == val) return true;
            else if (nums[mid] < val) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}