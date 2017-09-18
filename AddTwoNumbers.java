/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
		ListNode lTmp = head;
		int flag = 0;
		while (l1 != null || l2 != null) {
            int x, y;
            x = (l1==null) ? 0 : l1.val;
            y = (l2==null) ? 0 : l2.val;
			int tmp = x + y + flag;
			flag = tmp / 10;
			lTmp.next = new ListNode(tmp%10);
            lTmp = lTmp.next;
            if(l1!=null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
		}
        if(flag == 1)
            lTmp.next = new ListNode(1);
		return head.next;
        
    }
}
