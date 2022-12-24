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
        ListNode root = new ListNode(), itr = root;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l = 0, r = 0, rem = 0, sum = 0;
            if (l1 != null) {
                l = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                r = l2.val;
                l2 = l2.next;
            }

            sum = l + r + carry;
            rem = sum % 10;
            carry = sum / 10;
            ListNode next = new ListNode(rem);
            itr.next = next;
            itr = itr.next;
        }
        if(carry != 0){
            itr.next = new ListNode(carry);
        }
        return root.next;
    }
}