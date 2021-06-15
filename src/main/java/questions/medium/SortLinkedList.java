package questions.medium;

import utilclasses.ListNode;

public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    ListNode getMid(ListNode head) {
        ListNode midPrev = head;
        while (head != null && head.next != null) {
            midPrev = midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public static void main(String[] args) {
        int[] list = {2, 1, 5, 3, 7};
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for(int i : list){
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        SortLinkedList obj = new SortLinkedList();
        final ListNode mid = obj.getMid(head.next);

    }
}
