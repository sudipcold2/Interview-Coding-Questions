package questions.medium;

import utilclasses.ListNode;

public class AddTwoNumbersWithLinkedList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tmp = head;
        int carry = 0;
        while(l1 != null || l2 != null){
            int digit1 = l1 != null ? l1.val : 0;
            int digit2 = l2 != null ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            if(sum > 9){
                sum = sum % 10;
                carry = 1;
            }else{
                carry = 0;
            }

            tmp.next = new ListNode(sum);
            tmp = tmp.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if(carry > 0){
            tmp.next = new ListNode(carry);
            tmp = tmp.next;
        }

        return head.next;
    }
}
